package com.quintana.controller;

import java.util.List;

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

import com.quintana.model.Paciente;
import com.quintana.service.IPacienteService;

// Colocamos la anotacion @RestController para indicar que es un controlador de un servicio rest
// Colocamos la anotacion @RequestMapping para indicar el nombre que identifica els ervico rest para realizar la peticion
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private IPacienteService service;
	
	// Creamos un metodo con la anotacion @GetMapping para traer de la capa IPacienteService el metodo listas
	@GetMapping
	public ResponseEntity<List<Paciente>> listar(){
		List<Paciente> lista = service.listar();
		return new ResponseEntity<List<Paciente>>(lista, HttpStatus.OK);
	}
	
	// Renombramos la url ya que si no saldria un error de ambiguedad a la hora de realizar la petición ya que ya tenemos otro @GetMapping
	// Ademas se debe colocar @PathVariable("id") con el mismo nombre de la variable @GetMapping
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> listarPorId(@PathVariable("id") Integer id) {
		Paciente obj = service.listarPorId(id);
		return new ResponseEntity<Paciente> (obj, HttpStatus.OK);
	}
	
	// Se debe colocar @RequestBody para convertir el objeto json que se envia en la petición a objeto Java
	@PostMapping
	public ResponseEntity<Paciente> registrar(@RequestBody Paciente obj) {
		Paciente pac  =  service.registrar(obj);
		return new ResponseEntity<Paciente>(pac, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Paciente> modificar(@RequestBody Paciente obj) {
		Paciente pac = service.modificar(obj);	
		return new ResponseEntity<Paciente>(pac, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> elimimar(@PathVariable("id") Integer id) {
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
