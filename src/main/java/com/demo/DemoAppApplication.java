package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.EmployeeRepository;
import com.demo.model.Employee;
import com.demo.model.Project;

@SpringBootApplication
@RestController
//@EnableSwagger2
public class DemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);

	}

	@GetMapping()
	public List<String> getCities() {
		return Arrays.asList("Dallas", "Irving", "Plano");
		// return List.of("Dallas","Irving","Plano","Richardson");
	}

	@Bean
	CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
		return args -> {
			employeeRepository.save(new Employee("John","Doe",25000.0));
			employeeRepository.save(new Employee("Steven","Khan",20000.0));
			
			Employee empJoss = new Employee("Jossy","Ben",30000.0);
			empJoss.addProject(new Project("Accounting"));
			
			employeeRepository.save(empJoss);
			
			
			Employee empHagos = new Employee("Hagos","Belay",45000.0);
			empHagos.addProject(new Project("HR"));
			empHagos.setProjects(new HashSet<Project>(
							Arrays.asList(
										new Project("Speaking"),new Project("Public Driving"))
							       )
					);
			employeeRepository.save(empHagos);
			
			employeeRepository.save(new Employee("Filly","George",35000.0));
			
		};

	}

}
