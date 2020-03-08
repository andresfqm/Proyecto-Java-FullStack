package com.mitocode.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
//https://memorynotfound.com/spring-security-forgot-password-send-email-reset-password/
public class ResetToken implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String token;

	@OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "id_usuario")
	private Usuario user;

	@Column(nullable = false)
	private LocalDateTime expiracion;	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Usuario getUsuario() {
		return user;
	}

	public void setUsuario(Usuario user) {
		this.user = user;
	}

	public LocalDateTime getExpiracion() {
		return expiracion;
	}

	public void setExpiracion(LocalDateTime expiracion) {
		this.expiracion = expiracion;
	}

	public void setExpiracion(int minutes) {
		LocalDateTime now = LocalDateTime.now();
		//Calendar now = Calendar.getInstance();
		now.plusMinutes(minutes);
		//now.add(Calendar.MINUTE, minutes);
		this.expiracion = now; //.get .getTime();
	}

	public boolean isExpirado() {
		return LocalDateTime.now().isAfter(this.expiracion);
	}
}