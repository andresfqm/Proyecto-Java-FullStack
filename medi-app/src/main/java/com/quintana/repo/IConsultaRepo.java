package com.quintana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quintana.model.Consulta;

public interface IConsultaRepo extends JpaRepository<Consulta, Integer>{

}
