package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootRabbitApplication implements CommandLineRunner{
	
	@Autowired
	Sender sender;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
	   System.out.println("Comomand line runner");
	   
	   System.out.println(sender);
	   
       sender.send("Sending data from spring boot sender project....");
	   
	}
}
