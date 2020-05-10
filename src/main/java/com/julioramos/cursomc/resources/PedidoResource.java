package com.julioramos.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julioramos.cursomc.domain.Pedido;
import com.julioramos.cursomc.services.PedidoService;

/**
 * Controlador REST que define os endpoints para Pedido.
 */
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;

	/**
	 * Endpoint para a consulta de um Pedido.
	 * 
	 * @param id Id do Pedido que deseja-se buscar.
	 *
	 * @return O Pedido com base no Id informado.
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		Pedido obj = service.find(id);
		return ResponseEntity.ok(obj);
	}

}
