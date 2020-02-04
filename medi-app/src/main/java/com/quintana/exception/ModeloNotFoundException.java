package com.quintana.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Ya no necesito la anotación @ResponseStatus por que ya la controlo en la clase ResponseExceptionHandler
//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModeloNotFoundException extends RuntimeException{
	
	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}

}
