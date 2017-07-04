package de.johannesschwalb.evaluation.postgresjson;

import de.johannesschwalb.evaluation.postgresjson.entities.Root;
import de.johannesschwalb.evaluation.postgresjson.services.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PostgresjsonApplication {

	@Autowired
	RootService rootService;

	public static void main(String[] args) {
		SpringApplication.run(PostgresjsonApplication.class, args);
	}

}