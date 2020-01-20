package com.quintana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quintana.model.Medico;
import com.quintana.service.IMedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {
	
	@Autowired
	private IMedicoService service;
	
	@GetMapping
	public List<Medico> listar(){
		return service.listar();
		
	}
	
	@GetMapping("/{id}")
	public Medico listarPorId(@PathVariable("id") Integer id) {
		return service.listarPorId(id);
	}

}
