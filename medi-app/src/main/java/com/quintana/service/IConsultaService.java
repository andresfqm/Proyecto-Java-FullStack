package com.quintana.service;

import com.quintana.dto.ConsultaListaExamenDTO;
import com.quintana.model.Consulta;

public interface IConsultaService extends ICRUD<Consulta, Integer>{
	
	Consulta registrarTransaccional(ConsultaListaExamenDTO dto);
}
