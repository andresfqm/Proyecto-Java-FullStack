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
import com.quintana.model.Especialidad;
import com.quintana.service.IEspecialidadService;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {

	@Autowired
	private IEspecialidadService service;

	@PostMapping
	public ResponseEntity<Especialidad> registrar(@Valid @RequestBody Especialidad obj) {
		Especialidad esp = service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(esp.getIdEspecialidad()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Especialidad> modificar(@Valid @RequestBody Especialidad obj) {
		Especialidad esp = service.modificar(obj);
		return new ResponseEntity<Especialidad>(esp, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<Especialidad>> listar() {
		List<Especialidad> ls = service.listar();
		return new ResponseEntity<List<Especialidad>>(ls, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialidad> listarPorId(@PathVariable("id") Integer id){
		Especialidad esp = service.listarPorId(id);
		if(esp.getIdEspecialidad() == null) {
			throw new ModeloNotFoundException("ID No Encontrado : " + id);
		}
		return new ResponseEntity<Especialidad>(esp, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object>eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		
	}

}
