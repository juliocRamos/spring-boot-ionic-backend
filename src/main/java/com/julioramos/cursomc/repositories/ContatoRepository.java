package com.julioramos.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julioramos.cursomc.domain.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer>{
}
