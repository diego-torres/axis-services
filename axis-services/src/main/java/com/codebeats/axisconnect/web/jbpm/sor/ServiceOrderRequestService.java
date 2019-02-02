package com.codebeats.axisconnect.web.jbpm.sor;

import java.util.List;

import org.springframework.stereotype.Component;

import com.codebeats.axis.ServiceOrderRequest;
import com.codebeats.axisconnect.web.jbpm.JbpmRestClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ServiceOrderRequestService extends JbpmRestClient {

	/**
	 * 
	 * @param sor
	 */
	public void addServiceOrderRequest(ServiceOrderRequest sor, String userName) {
		// Start process instance
		ObjectMapper om = new ObjectMapper();
		String sorJson;
		try {
			sorJson = sorStringWrapper(om.writeValueAsString(sor));
			System.out.println(sorJson);
			startProcessInstance("axis-business", "com.codebeats.axis.axis_business.axis-process", sorJson, userName);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}	

	public List<ServiceOrderRequestListModel> getActiveSor(String userName) {
		return getActiveServiceOrderRequest(userName);
	}

	public List<ServiceOrderRequestListModel> getCompletedSor() {
		return null;
	}

	public List<ServiceOrderRequestListModel> getAllSor() {
		List<ServiceOrderRequestListModel> completed = getCompletedSor();
		//completed.addAll(getActiveSor());
		return completed;
	}

	private String sorStringWrapper(String sor) {
		return "{\"serviceOrderRequest\":{\"com.codebeats.axis.ServiceOrderRequest\":" + sor + "}}";
	}
}
