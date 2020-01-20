package com.quintana.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quintana.model.Medico;
import com.quintana.repo.IMedicoRepo;
import com.quintana.service.IMedicoService;

@Service
public class MedicoServiceImpl implements IMedicoService{
	
	@Autowired
	private IMedicoRepo repo;

	@Override
	public Medico registrar(Medico med) {
		return repo.save(med);
	}

	@Override
	public Medico modificar(Medico med) {
		return repo.save(med);
	}

	@Override
	public List<Medico> listar() {
	return repo.findAll();
	}

	@Override
	public Medico listarPorId(Integer id) {
		Optional<Medico> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Medico();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return false;
	}
	

}
