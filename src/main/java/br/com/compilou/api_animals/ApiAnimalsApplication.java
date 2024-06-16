package br.com.compilou.api_animals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.compilou.api_animals.repositories")
public class ApiAnimalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAnimalsApplication.class, args);
	}

}
