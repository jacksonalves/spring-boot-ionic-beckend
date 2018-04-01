package com.jackson.cursoemc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jackson.cursoemc.domain.Cliente;
import com.jackson.cursoemc.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id)  {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.jackson.cursoemc.services.exception.ObjectNotFoundException(
					"Objeto não encontrado! id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
