package ua.maestr0.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ua.maestr0.todolist.config.FlywayConfig;

@SpringBootApplication
@EnableJpaRepositories
public class TodoListApplication {
	public static void main(String[] args) {
		FlywayConfig.migrate();
		SpringApplication.run(TodoListApplication.class, args);
	}
}
