package com.codebeats.axisconnect.web.jbpm.sor;

import java.util.Date;

import com.codebeats.axis.ServiceOrderRequest;
import com.codebeats.axis.Validation;

public class ServiceOrderRequestListModel extends ServiceOrderRequest {
	private static final long serialVersionUID = 1L;
	
	private Validation validation;
	private Date requestedDate;
	private Date taskDate;
	
	public Validation getValidation() {
		return validation;
	}
	public void setValidation(Validation validation) {
		this.validation = validation;
	}
	public Date getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}
	public Date getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}
	

}
