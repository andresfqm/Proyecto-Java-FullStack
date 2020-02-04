package com.quintana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

// La anotación @ApiModel se usa para mostrar mas información de nuestras clases y servicios en la documentación
@ApiModel(description = "Información de paciente")
@Entity
@Table(name = "paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;

	@ApiModelProperty(notes = "Nombres debe tener como minimo 3 caracteres")
	@Size(min = 3, message = "Nombres debe tener como minimo 3 caracteres")
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;

	@ApiModelProperty(notes = "Apellidos debe tener como minimo 3 caracteres")
	@Size(min = 3, message = "Apellidos debe tener como minimo 3 caracteres")
	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;

	@ApiModelProperty(notes = "El número de identificación debe de tener como minimo 5 caracteres y maximo 12 caracteres")
	@Size(min = 5, max = 12, message = "El número de identificación debe de tener como minimo 5 caracteres y maximo 12 caracteres")
	@Column(name = "dni", nullable = false, length = 12)
	private String dni;

	@ApiModelProperty(notes = "La dirección debe de tener como minimo 4 caracteres y maximo 150")
	@Size(min = 4, max = 150, message = "La dirección debe de tener como minimo 4 caracteres y maximo 150")
	@Column(name = "direccion", nullable = true, length = 150)
	private String direccion;

	@ApiModelProperty(notes = "El número de telefono debe de tener como minimo 5 caracteres y maximo 12 caracteres")
	@Size(min = 5, max = 12, message = "El número de telefono debe de tener como minimo 5 caracteres y maximo 12 caracteres")
	@Column(name = "telefono", nullable = false, length = 12)
	private String telefono;

	@Email(message = "Ingrese un correo valido")
	@Column(name = "email", nullable = false, length = 70)
	private String email;

	// Getter and Setter
	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
