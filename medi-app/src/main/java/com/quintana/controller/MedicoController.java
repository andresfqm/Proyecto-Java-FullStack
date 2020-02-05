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
import com.quintana.model.Medico;
import com.quintana.model.Paciente;
import com.quintana.service.IMedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {
	
	@Autowired
	private IMedicoService service;
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Medico obj) {
		Medico med = service.registrar(obj);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(med.getIdMedico()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Medico> modificar(@Valid @RequestBody Medico obj) {
		Medico med = service.modificar(obj);
		return new ResponseEntity<Medico>(med, HttpStatus.OK);

	}
	
	// Creamos un metodo con la anotacion @GetMapping para traer de la capa
	// IMedicoService el metodo listas
	@GetMapping
	public ResponseEntity<List<Medico>> listar() {
		List<Medico> lista = service.listar();
		return new ResponseEntity<List<Medico>>(lista, HttpStatus.OK);
	}

	
	// Renombramos la url ya que si no saldria un error de ambiguedad a la hora de
	// realizar la petición ya que ya tenemos otro @GetMapping
	// Ademas se debe colocar @PathVariable("id") con el mismo nombre de la variable
	// @GetMapping
	@GetMapping("/{id}")
	public ResponseEntity<Medico> listarPorId(@PathVariable("id") Integer id) {
		Medico obj = service.listarPorId(id);
		if (obj.getIdMedico() == null) {
			throw new ModeloNotFoundException("ID No Encontrado : " + id);
		}
		return new ResponseEntity<Medico>(obj, HttpStatus.OK);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> elimimar(@PathVariable("id") Integer id) {
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}


}
