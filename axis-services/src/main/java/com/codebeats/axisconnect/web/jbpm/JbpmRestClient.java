package com.codebeats.axisconnect.web.jbpm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.codebeats.axis.Validation;
import com.codebeats.axisconnect.web.jbpm.model.ProcessInstance;
import com.codebeats.axisconnect.web.jbpm.model.Task;
import com.codebeats.axisconnect.web.jbpm.sor.ServiceOrderRequestListModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * From
 * https://www.mkyong.com/webservices/jax-rs/restfull-java-client-with-java-net-url/
 * 
 * @author dtorresf
 *
 */
public abstract class JbpmRestClient {
	// http://localhost:8080
	@Value("${kieserver.domain}")
	private String ksDomain;

	// /kie-server
	@Value("${kieserver.app}")
	private String ksApp;

	@Value("${kieserver.user}")
	private String ksSysUser;

	@Value("${kieserver.pwd}")
	private String ksSysCredentials;

	private static final String REST_SERVICES = "/services/rest/server/";
	private static final String CONTAINERS = "containers/";

	protected void startProcessInstance(String container, String processId, String input, String userName) {
		try {
			// http://localhost:8080/kie-server/services/rest/server/containers/axis-business/processes/com.codebeats.axis.axis_business.axis-process/instances
			String postUrl = ksDomain + ksApp + REST_SERVICES + CONTAINERS + container + "/processes/" + processId
					+ "/instances?user=" + userName;
			URL url = new URL(postUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// Planning to send POST information
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("content-type", "application/json");
			conn.setRequestProperty("accept", "application/json");
			conn.setRequestProperty("Authorization", "Basic " + basicAuthenticationString());

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			// This is a fire and forget request, get results with an snippet like this:

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				conn.disconnect();
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			br.readLine();
			conn.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected ProcessInstance getProcessInstance(Integer pid) {
		String processInstanceDetails = getProcesInstanceDetails(pid);
		ProcessInstance processInstance = new ProcessInstance();
		ObjectMapper om = new ObjectMapper();
		try {
			JsonNode rootNode = om.readTree(processInstanceDetails.getBytes());
			processInstance.setId(pid);
			processInstance.setName(rootNode.path("process-name").asText());
			Date startDate = new Date(rootNode.path("start-date").path("java.util.Date").asLong());
			processInstance.setStartDate(startDate);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return processInstance;
	}

	protected String getProcesInstanceDetails(Integer pid) {
		// http://localhost:8080/kie-server/services/rest/server/containers/axis-business/processes/instances/2?withVars=false
		String getUrl = ksDomain + ksApp + REST_SERVICES + "containers/axis-business/processes/instances/" + pid
				+ "?withVars=true";
		return getFromKieServer(getUrl);
	}

	protected List<ServiceOrderRequestListModel> getActiveServiceOrderRequest(String userName) {
		List<ServiceOrderRequestListModel> result = new ArrayList<>();
		List<Task> taskInstances = getReadyOrderEntryTaskIds(userName);
		for (Task task : taskInstances) {
			String taskDetails = getTaskDetails(task);
			ObjectMapper om = new ObjectMapper();
			try {
				JsonNode rootNode = om.readTree(taskDetails.getBytes());
				JsonNode taskInputNode = rootNode.path("task-input-data");

				JsonNode sorNode = taskInputNode.path("serviceOrderRequest")
						.path("com.codebeats.axis.ServiceOrderRequest");

				ServiceOrderRequestListModel sor = new ServiceOrderRequestListModel();
				Integer processInstanceId = rootNode.path("task-process-instance-id").asInt();
				sor.setProcessInstanceId(processInstanceId);

				ProcessInstance pi = getProcessInstance(processInstanceId);
				sor.setRequestedDate(pi.getStartDate());
				sor.setTaskDate(task.getCreatedOn());

				sor.setId(sorNode.path("id").asInt());
				sor.setCustomer(sorNode.path("customer").asText());
				sor.setDescription(sorNode.path("description").asText());
				sor.setClassNumber(sorNode.path("classNumber").asInt());
				sor.setConsignee(sorNode.path("consignee").asText());
				sor.setCustomerRef(sorNode.path("customerRef").asText());
				sor.setDimensions(sorNode.path("dimensions").asText());
				sor.setHu(sorNode.path("hu").asText());
				sor.setRequiresCustomerApproval(sorNode.path("requiresCustomerApproval").asBoolean());
				sor.setService(sorNode.path("service").asText());
				sor.setShipper(sorNode.path("shipper").asText());
				sor.setStatus(sorNode.path("status").asText());
				sor.setVendorRef(sorNode.path("vendorRef").asText());
				sor.setWeightLbs(sorNode.path("weightLbs").asInt());

				String rsd = sorNode.path("requestedShippingDate").path("java.sql.Date").asText();
				if (!"".equals(rsd)) {
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					try {
						sor.setRequestedShippingDate(df.parse(rsd));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}

				// Complete all fields (Process instance date and task dates).
				if ("Fix SOR".equals(task.getName())) {
					JsonNode validationNode = taskInputNode.path("validation").path("com.codebeats.axis.Validation")
							.path("errors");
					if (!validationNode.isMissingNode()) {
						Validation val = new Validation();
						validationNode.fieldNames().forEachRemaining(fn -> {
							val.addValidationError(fn, validationNode.path(fn).asText());
						});

						sor.setValidation(val);
					}
				}
				result.add(sor);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	private List<Task> getReadyOrderEntryTaskIds(String userName) {
		List<Task> result = new ArrayList<Task>();
		// from:
		// https://www.journaldev.com/2324/jackson-json-java-parser-api-example-tutorial
		String taskInstancesString = getReadyOrderEntryTasks(userName);
		if (!"".equals(taskInstancesString)) {
			ObjectMapper om = new ObjectMapper();
			try {
				JsonNode rootNode = om.readTree(taskInstancesString.getBytes());
				JsonNode taskSummaryNode = rootNode.path("task-summary");

				Iterator<JsonNode> processInstanceElements = taskSummaryNode.elements();
				while (processInstanceElements.hasNext()) {
					JsonNode taskInstanceNode = processInstanceElements.next();
					Task roet = new Task();
					roet.setId(taskInstanceNode.path("task-id").asInt());
					roet.setName(taskInstanceNode.path("task-name").asText());
					roet.setStatus(taskInstanceNode.path("task-status").asText());

					Date created = new Date(taskInstanceNode.path("task-created-on").path("java.util.Date").asLong());
					roet.setCreatedOn(created);
					Date activated = new Date(
							taskInstanceNode.path("task-activation-time").path("java.util.Date").asLong());
					roet.setActivatedOn(activated);

					result.add(roet);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	private String getTaskDetails(Task taskInstance) {
		// http://localhost:8080/kie-server/services/rest/server/containers/axis-business/tasks/2?withInputData=true&withAssignments=true
		String getUrl = ksDomain + ksApp + REST_SERVICES + "containers/axis-business/tasks/" + taskInstance.getId()
				+ "?withInputData=true";
		return getFromKieServer(getUrl);
	}

	private String getReadyOrderEntryTasks(String userName) {
		// http://localhost:8080/kie-server/services/rest/server/queries/tasks/instances/pot-owners?status=Ready&groups=order_entry&user=jboss
		String getUrl = ksDomain + ksApp + REST_SERVICES
				+ "queries/tasks/instances/pot-owners?status=Ready&groups=order_entry&user=" + userName;
		return getFromKieServer(getUrl);
	}

	private String basicAuthenticationString() {
		String authStr = ksSysUser + ":" + ksSysCredentials;
		return Base64.getEncoder().encodeToString(authStr.getBytes());
	}

	private String getFromKieServer(String getUrl) {
		StringBuilder sb = new StringBuilder();
		try {
			// TODO: Reusable connections or methods for this code
			URL url = new URL(getUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("content-type", "application/json");
			conn.setRequestProperty("accept", "application/json");
			conn.setRequestProperty("Authorization", "Basic " + basicAuthenticationString());

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			while ((output = br.readLine()) != null) {
				sb.append(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

}
