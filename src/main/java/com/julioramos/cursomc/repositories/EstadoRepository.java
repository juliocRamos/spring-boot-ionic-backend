package com.julioramos.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julioramos.cursomc.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
