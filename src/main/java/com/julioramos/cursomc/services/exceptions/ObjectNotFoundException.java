package com.julioramos.cursomc.services.exceptions;

/**
 * Classe que representa a tratativa para casos onde um Objeto não foi encontrado
 * ao requisitá-lo via endpoit.
 */
public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
