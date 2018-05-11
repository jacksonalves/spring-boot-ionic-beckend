	package com.jackson.cursoemc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jackson.cursoemc.domain.Categoria;
import com.jackson.cursoemc.domain.Produto;
import com.jackson.cursoemc.repositories.CategoriaRepository;
import com.jackson.cursoemc.repositories.ProdutoRepository;


@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository; 

	public Produto find(Integer id)  {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.jackson.cursoemc.services.exception.ObjectNotFoundException(
					"Objeto não encontrado! id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	@Transactional(readOnly=true)
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
				@SuppressWarnings("deprecation")
				PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
				List<Categoria> categorias = categoriaRepository.findAllById(ids);
				return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);	
			}
	}
