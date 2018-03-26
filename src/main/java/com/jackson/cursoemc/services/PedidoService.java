package com.jackson.cursoemc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jackson.cursoemc.domain.Pedido;
import com.jackson.cursoemc.repositories.PedidoRepository;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id)  {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.jackson.cursoemc.services.exception.ObjectNotFoundException(
					"Objeto não encontrado! id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
