package com.jackson.cursoemc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jackson.cursoemc.domain.Estado;
import com.jackson.cursoemc.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	@SuppressWarnings("unused")
	public List<Estado>findAll(){
		return repo.findAllByOrderByNome();
	}
}
