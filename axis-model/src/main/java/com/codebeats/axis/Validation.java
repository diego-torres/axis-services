package com.codebeats.axis;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Validation implements Serializable {
	private static final long serialVersionUID = 1L;
	private Map<String, String> errors = new HashMap<String, String>();

	public void addValidationError(String field, String description) {
		errors.put(field, description);
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
		return "Validation [errors=" + errors + ", errorCount=" + getErrorsCount() + "]";
	}

}
