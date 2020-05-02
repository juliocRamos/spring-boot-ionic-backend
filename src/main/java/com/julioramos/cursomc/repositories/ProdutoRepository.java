package com.julioramos.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julioramos.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
