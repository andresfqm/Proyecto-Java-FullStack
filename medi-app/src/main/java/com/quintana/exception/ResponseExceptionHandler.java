package com.quintana.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// Utilizamos la anotación ControllerAdvice para intercepar otras clases y asi poder obtener los errores correspondientes
@ControllerAdvice
// Exponemos esta clase como servicio rest
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	// Metodo para controlar exepciones de tipo NOT_FOUND
	public final ResponseEntity<ExceptionResponse> manejarModeloException(ModeloNotFoundException ex,
			WebRequest request) {
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.NOT_FOUND);
	}

	// Metodo para lanzar excepciones cuando se envia algo mal en la petición
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
	}

	// Metodo para controlar todas las excepciones que no caigan en los metodos
	// anteriores
	public final ResponseEntity<ExceptionResponse> manejarTodasExceptions(ModeloNotFoundException ex,
			WebRequest request) {
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
