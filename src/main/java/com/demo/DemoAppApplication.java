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

	// GHToken
	// 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
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
			
			employeeRepository.save(new Employee("Steven", "Khan", 20000.0));

			// Adding Employee Jossy
			Employee empJoss = new Employee("Jossy", "Ben", 30000.0);
			empJoss.addProject(new Project("Accounting"));
			Department deptJoss = new Department(1001, "Computer Science", new Address(5331, "Dallas", "dallas st"));
			deptJoss.addCourse(new Course("Data Structure", 4));

			empJoss.addDepartment(deptJoss);
			// empJoss.setDepartments(new ArrayList<>(Arrays.asList(JossyDept)));
			employeeRepository.save(empJoss);
			// End of Employee Jossy

			
			
			// Adding Employee Hagos
			Employee empHagos = new Employee("Hagos", "Belay", 45000.0);
			empHagos.addProject(new Project("HR Project"));
			empHagos.setProjects(new HashSet<Project>(
					Arrays.asList(new Project("Field work Project"), new Project("Development project")))
					);
			Department empHagosDept = new Department(1002, "HR Dept", new Address(75301, "Roswell street", "Roswell"));
			empHagosDept.addCourse(new Course("Intruduction to Human Resources", 3));
			empHagos.addDepartment(empHagosDept);
			employeeRepository.save(empHagos);
           //  END OF HAGOS
			
			
			
			 //  Adding Filly
			Employee empFilly = new Employee("Filly", "George", 35000.0);
			empFilly.addProject(new Project("Water Consruction Project"));
			empFilly.setDepartments(
					Arrays.asList(
							new Department(							
								3002,"Construction Dept",
								new Address(65231,"6050 highway dr","Plano"),
								Arrays.asList(new Course("Water Technlogy",4),new Course("Hydrolics Technlogy",3))
							
							))
					);
			
			employeeRepository.save(empFilly);
			// End of Employee Filly
			
			
			
			// Adding John Employee
				Employee empJohn = new Employee("John", "Doe", 25000.0);
				empJohn.setProjects(new HashSet<>(Arrays.asList(new Project("Educational Project"),new Project("Professional Project"))));
			    Employee populatedEmployee=createDepartment(empJohn);
				employeeRepository.save(empJohn);
				employeeRepository.save(populatedEmployee);
			//  End of John
				

		};

	}

	private Employee createDepartment(Employee empJohn) {
		
		List<Department> deparmentList=new ArrayList<>();
		
		  List<Course> courseList1=new ArrayList<>();
		  courseList1.add(new Course("Database programming",3));
		  courseList1.add(new Course("Java Basics",4));
		Department ITDept=new Department(3007, "IT Dept", new Address(75235,"parklane street","Dallas"),courseList1);
		
		 
		
		
		List<Course> courseList2=new ArrayList<>();
		  courseList2.add(new Course("C# programming",3));
		  courseList2.add(new Course("MongoDB",4));		  
		  Department CSEDept=new Department(3008, "CSE Dept", new Address(80002,"dallas st","Dallas"),courseList2);
		
		  deparmentList.add(ITDept);
		  deparmentList.add(CSEDept);
		  
		  empJohn.setDepartments(deparmentList);
		
		return empJohn;
	}

}
