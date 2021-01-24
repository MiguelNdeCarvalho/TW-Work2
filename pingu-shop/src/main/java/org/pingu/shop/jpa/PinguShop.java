package org.pingu.shop.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PinguShop {

    // @Autowired
    // private ClientRepository repository;
    
	public static void main(String[] args) {
		SpringApplication.run(PinguShop.class, args);
	}

}
