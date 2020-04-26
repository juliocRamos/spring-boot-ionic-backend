package com.julioramos.cursomc.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julioramos.cursomc.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@GetMapping
	public List<Categoria> listar() {

		Categoria c1 = new Categoria(1, "Informática");
		Categoria c2 = new Categoria(2, "Escritório");

		List<Categoria> cats = Arrays.asList(c1, c2);

		return cats;
	}
}
