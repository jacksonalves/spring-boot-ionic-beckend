package com.jackson.cursoemc.resouces.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessege> erros = new ArrayList<>();
	
	public ValidationError(Long timeStamp, Integer status, String error, String message, String path) {
		super(timeStamp, status, error, message, path);
	}
	
	public List<FieldMessege> getErrors() {
		return erros;
	}
	public void addError(String fieldName, String message) {
		erros.add(new FieldMessege(fieldName, message));
	}
	

	

}
