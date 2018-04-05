package com.jackson.cursoemc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.jackson.cursoemc.domain.Cliente;
import com.jackson.cursoemc.domain.enums.TipoCliente;
import com.jackson.cursoemc.dto.ClenteNewDTO;
import com.jackson.cursoemc.repositories.ClienteRepository;
import com.jackson.cursoemc.resouces.exception.FieldMessege;
import com.jackson.cursoemc.services.validation.utils.BR;

public class ClienteInsertValidation implements ConstraintValidator<ClienteInsert, ClenteNewDTO> {

	@Autowired
	private ClienteRepository repo;;
	
	@Override
	public void initialize(ClienteInsert ann) {
		
	}

	@Override
	public boolean isValid(ClenteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessege> list = new ArrayList<>();
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessege("CpfOuCnpj", "CPF inválido"));
		}
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessege("CpfOuCnpj", "CNPJ inválido"));
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if(aux != null) {
			list.add(new FieldMessege("email", "Email já existente"));
		}
		
		for (FieldMessege e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
