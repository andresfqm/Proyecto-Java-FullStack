package com.quintana.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.quintana.model.ConsultaExamen;

public interface IConsultaExamenRepo extends JpaRepository<ConsultaExamen, Integer> {

	@Modifying
    @Query(value = "INSERT INTO consulta_examen(id_consulta, id_examen) VALUES (:idConsulta, :idExamen)", nativeQuery = true)
	Integer consultaexamen(@Param("idConsulta") Integer idConsulta, @Param("idExamen") Integer idExamen);

	//@Procedure(name = "consultaExamen")
	//String consultaexamen(@Param("idConsulta") Integer idConsulta,@Param("idExamen") Integer idExamen);

}
