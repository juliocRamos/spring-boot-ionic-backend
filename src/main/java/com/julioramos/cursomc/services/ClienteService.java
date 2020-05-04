package com.julioramos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julioramos.cursomc.domain.Cliente;
import com.julioramos.cursomc.repositories.ClienteRepository;
import com.julioramos.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	/**
	 * Busca um Cliente com base no id informado.
	 * 
	 * @param id Id do Cliente que deseja buscar.
	 *
	 * @return O Cliente que possui o id informado ou null.
	 */
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getSimpleName()));
	}
}
