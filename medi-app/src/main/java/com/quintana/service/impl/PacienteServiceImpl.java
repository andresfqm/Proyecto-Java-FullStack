package com.quintana.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quintana.model.Paciente;
import com.quintana.repo.IPacienteRepo;
import com.quintana.service.IPacienteService;

// Colocamos esta clase como Service para que otra clase la pueda leer mas adelante
@Service
public class PacienteServiceImpl implements IPacienteService{

	// Obtenemos una instancia de la interfaz IPacienteRepo
	@Autowired
	private IPacienteRepo repo;
	
	
	// Sobre escribimos los metodos abstractos
	@Override
	public Paciente registrar(Paciente pac) {
		return repo.save(pac);	
	}

	@Override
	public Paciente modificar(Paciente pac) {
		return repo.save(pac);
	}

	@Override
	public List<Paciente> listar() {
	return repo.findAll();
	}
	
	@Override
	public Paciente listarPorId(Integer id) {
		// Clase optional esta disponible desde java 8, y controla si viene un nulo desde la BD
		Optional<Paciente> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Paciente();
	}

	@Override
	public boolean eliminar(Integer id) {
	  repo.deleteById(id);
	  return true;
		
	}

}
