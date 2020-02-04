package com.quintana.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.quintana.exception.ModeloNotFoundException;
import com.quintana.model.Paciente;
import com.quintana.service.IPacienteService;

//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

// Colocamos la anotacion @RestController para indicar que es un controlador de un servicio rest
// Colocamos la anotacion @RequestMapping para indicar el nombre que identifica els ervico rest para realizar la peticion
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private IPacienteService service;

	// Se debe colocar @RequestBody para convertir el objeto json que se envia en la
	// petición a objeto Java
	// Se agrega la anotación @Valid para que se valide los 
/* según se definen
	// en la entity de Paciente "javax.validation.constraints"
	@PostMapping
	public ResponseEntity<Paciente> registrar(@Valid @RequestBody Paciente obj) {
		Paciente pac = service.registrar(obj);
		return new ResponseEntity<Paciente>(pac, HttpStatus.CREATED);
	}*/
	
	// Otra forma de realizar el create pero que nos devuelve en el encabezado la url para obtener mas datos del recurso creado
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Paciente obj) {
		Paciente pac = service.registrar(obj);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getIdPaciente()).toUri();
		return ResponseEntity.created(location).build();
	}

	// Se debe colocar @RequestBody para convertir el objeto json que se envia en la
	// petición a objeto Java
	// Se agrega la anotación @Valid para que se valide los datos según se definen
	// en la entity de Paciente "javax.validation.constraints"
	@PutMapping
	public ResponseEntity<Paciente> modificar(@Valid @RequestBody Paciente obj) {
		Paciente pac = service.modificar(obj);
		return new ResponseEntity<Paciente>(pac, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> elimimar(@PathVariable("id") Integer id) {
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Creamos un metodo con la anotacion @GetMapping para traer de la capa
	// IPacienteService el metodo listas
	@GetMapping
	public ResponseEntity<List<Paciente>> listar() {
		List<Paciente> lista = service.listar();
		return new ResponseEntity<List<Paciente>>(lista, HttpStatus.OK);
	}

	// Renombramos la url ya que si no saldria un error de ambiguedad a la hora de
	// realizar la petición ya que ya tenemos otro @GetMapping
	// Ademas se debe colocar @PathVariable("id") con el mismo nombre de la variable
	// @GetMapping
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> listarPorId(@PathVariable("id") Integer id) {
		Paciente obj = service.listarPorId(id);
		if (obj.getIdPaciente() == null) {
			throw new ModeloNotFoundException("ID No Encontrado : " + id);
		}
		return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
	}

	// https://docs.spring.io/spring-hateoas/docs/current/reference/html/
	// hateoas 1.0 Spring Boot 2.2
	/*
	 * @GetMapping("/hateoas/{id}") public EntityModel<Paciente>
	 * listarPorIdHateoas(@PathVariable("id") Integer id) { Paciente pac =
	 * service.listarPorId(id); //localhos:8080/pacientes/{id} EntityModel<Paciente>
	 * recurso = new EntityModel<Paciente>(pac); WebMvcLinkBuilder linkTo =
	 * LinkTo(methodOn(this.getClass()).listarPorId(id));
	 * recurso.add(linkTo.withRel("paciente-resource"));
	 * 
	 * return recurso; }
	 */

}
