package com.quintana.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "consultaExamen")
// Con la anotación IdClass indicamos donde esta la definción de la clase
@IdClass(ConsultaExamenPK.class)
public class ConsultaExamen {
	
	@Id
	private Examen examen;
	
	@Id
	private Consulta consulta;

	
	// Getter and Setter
	/**
	 * @return the examen
	 */
	public Examen getExamen() {
		return examen;
	}

	/**
	 * @param examen the examen to set
	 */
	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	/**
	 * @return the consulta
	 */
	public Consulta getConsulta() {
		return consulta;
	}

	/**
	 * @param consulta the consulta to set
	 */
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
	

}
