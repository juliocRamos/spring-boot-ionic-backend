package com.julioramos.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julioramos.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
