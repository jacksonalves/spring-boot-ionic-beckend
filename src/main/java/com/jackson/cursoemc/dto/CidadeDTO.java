package com.jackson.cursoemc.dto;

import java.io.Serializable;

import com.jackson.cursoemc.domain.Cidade;

public class CidadeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public CidadeDTO() {
		
	}

	public CidadeDTO(Cidade cidadeObj) {
		id = cidadeObj.getId();
		nome = cidadeObj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
