package com.julioramos.cursomc.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.julioramos.cursomc.domain.Categoria;
import com.julioramos.cursomc.dtos.CategoriaDTO;
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
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria obj = service.find(id);
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
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDTO) {
		Categoria obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	/**
	 * Atualiza uma Categoria com os dados informados.
	 *
	 * @param obj Json com os novos dados da Categoria.
	 * @param id  Identificador da Categoria que será atualizada.
	 *
	 * @return Um Response entity vazio com o HttpCode 204 (No Content).
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDTO, @PathVariable Integer id) {
		Categoria obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	/**
	 * Endpoint para deletar uma Categoria.
	 *
	 * @param id Identificador da Categoria que será deletada.
	 *
	 * @return Um Response entity vazio com o HttpCode 204 (No Content).
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	/**
	 * Endepoint que retorna todas as Categorias.
	 *
	 * @return Um response entity com uma lista contendo todas as Categorias.
	 */
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<CategoriaDTO> categorias = service.findAll();
		return ResponseEntity.ok(categorias);
	}

	/**
	 * Endpoint para consultar as categorias com paginação.
	 * 
	 * @param page         Número da página.
	 * @param linesPerPage Linhas por páginas.
	 * @param orderBy      Critério de ordenação
	 * @param direction    Direção da ordenação (ASC ou DESC)
	 *
	 * @return Um ResponseEntity contendo a página com a paginação aplicados.
	 */
	@GetMapping(value = "/page")
	public ResponseEntity<Page<CategoriaDTO>> findPaginated(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {
		Page<CategoriaDTO> resultPage = service.findPaginated(page, linesPerPage, orderBy, direction)
				.map(e -> new CategoriaDTO(e));
		return ResponseEntity.ok(resultPage);
	}
}
