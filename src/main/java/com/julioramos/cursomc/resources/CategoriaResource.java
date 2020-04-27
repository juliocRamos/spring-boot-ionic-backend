package com.julioramos.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julioramos.cursomc.domain.Categoria;
import com.julioramos.cursomc.services.CategoriaService;

/**
 * Controlador REST que define os endpoints para Categoria.
 */
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	
	/**
	 * Endpoing para a consulta de uma Categoria.
	 * 
	 * @param id
	 *   Id da Categoria que deseja-se buscar.
	 *
	 * @return
	 *   A Categoria com base no Id informado.
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Categoria obj = service.buscar(id);
		return ResponseEntity.ok(obj);
	}
}
