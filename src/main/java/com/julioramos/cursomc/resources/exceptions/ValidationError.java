package com.julioramos.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que encapsula erros de validação de campos preenchidos com informações inesperadas.
 */
public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errorList = new ArrayList<>();
	
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}
	
	public void addError(String fieldName, String message) {
		errorList.add(new FieldMessage(fieldName, message));
	}

	public List<FieldMessage> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<FieldMessage> errorList) {
		this.errorList = errorList;
	}
}
