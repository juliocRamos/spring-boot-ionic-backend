package com.julioramos.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julioramos.cursomc.domain.Cliente;
import com.julioramos.cursomc.services.ClienteService;

/**
 * Controlador REST que define os endpoints para Cliente.
 */
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	/**
	 * Endpoint para a consulta de um Cliente.
	 * 
	 * @param id Id do Cliente que deseja-se buscar.
	 *
	 * @return O Cliente com base no Id informado.
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente obj = service.find(id);
		return ResponseEntity.ok(obj);
	}
}
