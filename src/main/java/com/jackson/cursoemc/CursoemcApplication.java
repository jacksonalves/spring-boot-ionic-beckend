package com.jackson.cursoemc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jackson.cursoemc.services.S3Service;

@SpringBootApplication
public class CursoemcApplication implements CommandLineRunner{
	
	@Autowired
	private S3Service s3Service;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoemcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		s3Service.uploadFile("C:\\Users\\jackson danielson\\Desktop\\imagens-institucional\\de.png");
	}
	
}
