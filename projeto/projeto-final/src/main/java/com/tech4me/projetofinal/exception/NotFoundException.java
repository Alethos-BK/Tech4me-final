package com.tech4me.projetofinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	public NotFoundException() {
		super("Recurso não foi encontrado");
	}

	public NotFoundException(String mensagem) {
		super(mensagem);
	}

}