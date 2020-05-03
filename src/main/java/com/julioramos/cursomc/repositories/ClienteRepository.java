package com.julioramos.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julioramos.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
}
