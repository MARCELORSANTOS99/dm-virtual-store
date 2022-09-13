package com.dmvirtualstore.services.exception;

import java.util.ArrayList;
import java.util.List;

import com.dmvirtualstore.resources.exception.FieldMessage;
import com.dmvirtualstore.resources.exception.StandardError;

public class ValidationError extends StandardError {

	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);

	}

	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>(); 



	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String messagem) {
		errors.add(new FieldMessage(fieldName, messagem));
	}





}
