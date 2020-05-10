package com.julioramos.cursomc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	 * Endpoint para a consulta de uma Categoria.
	 * 
	 * @param id Identificador da Categoria que deseja-se buscar.
	 *
	 * @return A Categoria com base no Id informado.
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok(obj);
	}

	/**
	 * Endpoint para inserir uma nova Categoria.
	 * 
	 * @param obj Json com os dados da Categoria.
	 *
	 * @return Um ResponseEntity vazio com o HttpCode 201 (Created).
	 */
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
