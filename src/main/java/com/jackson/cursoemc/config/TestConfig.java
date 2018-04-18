package com.jackson.cursoemc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jackson.cursoemc.services.DBService;
import com.jackson.cursoemc.services.EmailService;
import com.jackson.cursoemc.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		
		dbService.instatiateTestDataBase();
		
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}
