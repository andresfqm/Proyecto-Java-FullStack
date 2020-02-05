package com.quintana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quintana.model.Examen;

public interface IExamenRepo extends JpaRepository<Examen, Integer>{

}
