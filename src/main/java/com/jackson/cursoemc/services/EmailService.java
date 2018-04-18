package com.jackson.cursoemc.services;

import org.springframework.mail.SimpleMailMessage;

import com.jackson.cursoemc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
