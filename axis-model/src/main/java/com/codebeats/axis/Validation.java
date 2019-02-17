package com.codebeats.axis;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Validation implements Serializable {
	private static final long serialVersionUID = 1L;
	private Map<String, String> errors = new HashMap<String, String>();

	public void addValidationError(String field, String description) {
		if(errors.containsKey(field)) {
			String previousValue = errors.get(field);
			errors.remove(field);
			errors.put(field, previousValue + "; also, " + description);
		} else {
			errors.put(field, description);
		}
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public int getErrorsCount() {
		return errors.size();
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public String getErrorByField(String field) {
		return errors.get(field);
	}

	@Override
	public String toString() {
		ObjectMapper om = new ObjectMapper();
		try {
			return om.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "{}";
		}
	}

}
