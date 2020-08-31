package com.produto.produto;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@ComponentScan(basePackages = "com.produto.produto.controller")
@EntityScan(basePackages = { "com.produto.produto.model" })
@EnableJpaRepositories(basePackages = { "com.produto.produto.repository" })
@SpringBootApplication
public class ProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}

}
