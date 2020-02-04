package com.quintana.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quintana.model.Consulta;
import com.quintana.repo.IConsultaExamenRepo;
import com.quintana.repo.IConsultaRepo;
import com.quintana.service.IConsultaService;
@Service
public class ConsultaServiceImpl implements IConsultaService{

    @Autowired
	private IConsultaRepo repo;
	
  //  @Autowired
  //  private IConsultaExamenRepo ceRepo;
    
	@Override
	public Consulta registrar(Consulta obj) {
		obj.getDetalleConsulta().forEach(det ->{
			det.setConsulta(obj);
		});
		return repo.save(obj);
	}

	@Override
	public Consulta modificar(Consulta obj) {
		return repo.save(obj);
	}

	@Override
	public List<Consulta> listar() {
		return repo.findAll();
	}

	@Override
	public Consulta listarPorId(Integer id) {
		Optional<Consulta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Consulta();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return false;
	}

}
