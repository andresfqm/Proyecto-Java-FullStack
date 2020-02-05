package com.quintana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quintana.model.Examen;
import com.quintana.service.IExamenService;

@RestController
@RequestMapping("/examenes")
public class ExamenController {
	
	@Autowired
	private IExamenService service;
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody Examen obj){
		Examen ex = service.registrar(obj);
		return new ResponseEntity<Object>(ex, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Examen>> listar(){
		List<Examen> ls = service.listar();
		return new ResponseEntity<List<Examen>>(ls,HttpStatus.OK);
	
	}

}
