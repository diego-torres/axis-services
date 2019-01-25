package com.codebeats.axisconnect.web.jbpm.sor;

import org.springframework.stereotype.Component;

import com.codebeats.axis.ServiceOrderRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ServiceOrderRequestService extends JbpmRestClient {
	public void addServiceOrderRequest(ServiceOrderRequest sor) {
		// Start process instance
		ObjectMapper om = new ObjectMapper();
		String sorJson;
		try {
			sorJson = om.writeValueAsString(sor);
			System.out.println(sorJson);
			startProcessInstance("axis-business", "com.codebeats.axis.axis_business.axis-process", sorJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
