package com.julioramos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julioramos.cursomc.domain.Pedido;
import com.julioramos.cursomc.repositories.PedidoRepository;
import com.julioramos.cursomc.services.exceptions.ObjectNotFoundException;

/**
 * Classe de Serviços para Pedido.
 */
@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	/**
	 * Busca um Pedido com base no id informado.
	 * 
	 * @param id Id do Pedido que deseja buscar.
	 *
	 * @return O Pedido que possui o id informado.
	 */
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " 
		+ id + ", tipo: " + Pedido.class.getSimpleName()));
	}
}
