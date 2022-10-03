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
import com.demo.model.Address;
import com.demo.model.Course;
import com.demo.model.Department;
import com.demo.model.Employee;
import com.demo.model.Project;

@SpringBootApplication
@RestController
//@EnableSwagger2
public class DemoAppApplication {
     
	//GHToken
	//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
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
			
			
			//Adding Employee Jossy
				Employee empJoss = new Employee("Jossy","Ben",30000.0);
				empJoss.addProject(new Project("Accounting"));					
				 Department deptJoss=new Department(1001,"Computer Science",new Address(5331,"Dallas","dallas st"));
				  deptJoss.addCourse(new Course("Data Structure",4));
						
				empJoss.addDepartment(deptJoss);
				//empJoss.setDepartments(new ArrayList<>(Arrays.asList(JossyDept)));			
				employeeRepository.save(empJoss);
			// End of Employee Jossy
			
			
			
			
				//Adding Employee Hagos
			
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
