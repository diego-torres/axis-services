package com.codebeats.axisconnect.web.jbpm.sor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;

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

	protected void startProcessInstance(String container, String processId, String input) {
		try {
			// http://localhost:8080/kie-server/services/rest/server/containers/axis-business/processes/com.codebeats.axis.axis_business.axis-process/instances
			String postUrl = ksDomain + ksApp + REST_SERVICES + CONTAINERS + container + "/processes/" + processId
					+ "/instances";
			System.out.println("posting to: " + postUrl);
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
			/*
			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				conn.disconnect();
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
			}*/
			
			conn.disconnect();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected String basicAuthenticationString() {
		String authStr = ksSysUser + ":" + ksSysCredentials;
		return Base64.getEncoder().encodeToString(authStr.getBytes());
	}

}
