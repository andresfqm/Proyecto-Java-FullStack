// El paquete repo se usa mucho para el acceso a datos
package com.quintana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quintana.model.Paciente;


// La interfaz JpaRepository pide la entidad que se va a trabajar y el tipo de la llame primaria
public interface IPacienteRepo extends JpaRepository<Paciente, Integer>{
	

}
