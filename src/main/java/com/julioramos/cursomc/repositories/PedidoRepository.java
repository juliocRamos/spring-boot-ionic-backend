package com.julioramos.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julioramos.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
