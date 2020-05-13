package com.julioramos.cursomc.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.julioramos.cursomc.domain.Categoria;
import com.julioramos.cursomc.repositories.CategoriaRepository;
import com.julioramos.cursomc.services.exceptions.DataIntegrityException;
import com.julioramos.cursomc.services.exceptions.ObjectNotFoundException;

import dtos.CategoriaDTO;

/**
 * Classe de Serviços para Categoria.
 */
@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	/**
	 * Busca uma Categoria com base no Id informado.
	 * 
	 * @param id Id da Categoria que deseja buscar.
	 * 
	 * @return A Categoria que possuí o id informado.
	 */
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getSimpleName()));
	}

	/**
	 * Cria uma nova Categoria.
	 *
	 * @param obj Objeto com os dados da nova Categoria.
	 *
	 * @return A Categoria que foi criada.
	 */
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	/**
	 * Deleta uma Categoria com base no Id informado.
	 * 
	 * @param id Identificador da Categoria que será deleteada.
	 */
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException ex) {
			throw new DataIntegrityException("Não foi possível excluir a Categoria com id: " + id
					+ " pois a mesma está sendo referênciada por outras entidades", ex);
		}

	}

	/**
	 * Retorna todas as Categorias cadastradas.
	 *
	 * @return Uma lista com todas as Categorias.
	 */
	public List<CategoriaDTO> findAll() {
		List<CategoriaDTO> categorias = repo.findAll().stream().map(e -> new CategoriaDTO(e))
				.collect(Collectors.toList());
		return categorias;
	}
}
