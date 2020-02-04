package com.quintana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalle_consulta")
public class DetalleConsulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalle;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_consulta", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_detalle"))
	private Consulta consulta;
	
	@Column(name = "diagnostico", nullable = false, length = 100)
	private String diagnostico;
	
	@Column(name = "tratamiento", nullable = false, length = 300)
	private String tratamiento;
	
	// Getter and Setter

	/**
	 * @return the idDetalle
	 */
	public int getIdDetalle() {
		return idDetalle;
	}

	/**
	 * @param idDetalle the idDetalle to set
	 */
	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
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

	/**
	 * @return the diagnostico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}

	/**
	 * @param diagnostico the diagnostico to set
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * @return the tratamiento
	 */
	public String getTratamiento() {
		return tratamiento;
	}

	/**
	 * @param tratamiento the tratamiento to set
	 */
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	
	
}
