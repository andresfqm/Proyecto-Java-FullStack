package com.mitocode.model;

import java.time.LocalDateTime;

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
@Table(name = "signos_vitales")
public class Signos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSigno;
	
	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_signo_paciente"))
	private Paciente paciente;
	
	@Column(name = "fecha")
	private LocalDateTime fecha;
	
	@Column(name = "temperatura", nullable = false, length = 30)
	private String temperatura;
	
	@Column(name = "pulso", nullable = false, length = 30)
	private String pulso;
	
	@Column(name = "ritmoRespiratorio", nullable = false, length = 30)
	private String ritmoRespiratorio;
	

	
	// Getter and Setter

	/**
	 * @return the idSigno
	 */
	public Integer getIdSigno() {
		return idSigno;
	}

	/**
	 * @param idSigno the idSigno to set
	 */
	public void setIdSigno(Integer idSigno) {
		this.idSigno = idSigno;
	}

	/**
	 * @return the paciente
	 */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	/**
	 * @return the temperatura
	 */
	public String getTemperatura() {
		return temperatura;
	}

	/**
	 * @param temperatura the temperatura to set
	 */
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	/**
	 * @return the pulso
	 */
	public String getPulso() {
		return pulso;
	}

	/**
	 * @param pulso the pulso to set
	 */
	public void setPulso(String pulso) {
		this.pulso = pulso;
	}

	/**
	 * @return the ritmoRespiratorio
	 */
	public String getRitmoRespiratorio() {
		return ritmoRespiratorio;
	}

	/**
	 * @param ritmoRespiratorio the ritmoRespiratorio to set
	 */
	public void setRitmoRespiratorio(String ritmoRespiratorio) {
		this.ritmoRespiratorio = ritmoRespiratorio;
	}

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
	
	
}
