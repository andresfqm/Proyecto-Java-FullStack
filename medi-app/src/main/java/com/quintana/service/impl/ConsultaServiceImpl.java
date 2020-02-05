package com.quintana.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quintana.dto.ConsultaListaExamenDTO;
import com.quintana.model.Consulta;
import com.quintana.repo.IConsultaExamenRepo;
import com.quintana.repo.IConsultaRepo;
import com.quintana.service.IConsultaService;
@Service
public class ConsultaServiceImpl implements IConsultaService{

    @Autowired
	private IConsultaRepo repo;
    
	@Autowired
	private IConsultaExamenRepo ceRepo;
	
  //  @Autowired
  //  private IConsultaExamenRepo ceRepo;
    
	@Override
	public Consulta registrar(Consulta obj) {
		obj.getDetalleConsulta().forEach(det ->{
			det.setConsulta(obj);
		});
		return repo.save(obj);
	}
	
	@Transactional
	@Override
	public Consulta registrarTransaccional(ConsultaListaExamenDTO dto) {
		dto.getConsulta().getDetalleConsulta().forEach(det -> {
			det.setConsulta(dto.getConsulta());
		});
		repo.save(dto.getConsulta());
		
		dto.getLstExamen().forEach(ex -> ceRepo.consultaexamen(dto.getConsulta().getIdConsulta(), ex.getIdExamen()));
		
		return dto.getConsulta();
		
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
