package grassi.demo;

import grassi.demo.model.Aluno;
import grassi.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	AlunoService alunoService;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}

}
