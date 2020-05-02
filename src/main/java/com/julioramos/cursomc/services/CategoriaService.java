package com.julioramos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julioramos.cursomc.domain.Categoria;
import com.julioramos.cursomc.repositories.CategoriaRepository;
import com.julioramos.cursomc.services.exceptions.ObjectNotFoundException;

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
	 * @return A Categoria que possuí o id informado ou null.
	 */
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getSimpleName()));
	}
}
