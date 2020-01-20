package com.quintana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quintana.model.Medico;

public interface IMedicoRepo extends JpaRepository<Medico, Integer>{

}
