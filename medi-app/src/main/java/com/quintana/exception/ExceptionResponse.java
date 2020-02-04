package com.quintana.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {

	private LocalDateTime fecha;
	private String mensaje;
	private String detalles;
	
	// Pojo para manejar las exception de forma personalizadas, sobreescribiendo el constructor en la clase ResponseExceptionHandler
	
	public ExceptionResponse(LocalDateTime fecha, String mensaje, String detalles) {
		super();
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.detalles = detalles;
	}
	// Getter and Setter
	/**
	 * @return the fecha
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * @return the detalles
	 */
	public String getDetalles() {
		return detalles;
	}
	/**
	 * @param detalles the detalles to set
	 */
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	
	
}
