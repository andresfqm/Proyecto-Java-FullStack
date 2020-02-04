package com.quintana.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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
import com.quintana.model.Consulta;
import com.quintana.service.IConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

	IConsultaService service;

	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Consulta obj) {
		Consulta con = service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(con.getIdConsulta()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Consulta> modificar(@Valid @RequestBody Consulta obj) {
		Consulta con = service.modificar(obj);
		return new ResponseEntity<Consulta>(con, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<Consulta>> listar() {
		List<Consulta> ls = service.listar();
		return new ResponseEntity<List<Consulta>>(ls, HttpStatus.OK);
	}
	
	// Renombramos la url ya que si no saldria un error de ambiguedad a la hora de
	// realizar la petición ya que ya tenemos otro @GetMapping
	// Ademas se debe colocar @PathVariable("id") con el mismo nombre de la variable
	// @GetMapping
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> listarPorId(@PathVariable("id") Integer id) {
		Consulta obj = service.listarPorId(id);
		if (obj.getIdConsulta() == null) {
			throw new ModeloNotFoundException("ID No Encontrado : " + id);
		}
		return new ResponseEntity<Consulta>(obj, HttpStatus.OK);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> elimimar(@PathVariable("id") Integer id) {
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
