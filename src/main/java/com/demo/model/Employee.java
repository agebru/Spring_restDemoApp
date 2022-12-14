package com.demo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "emp_tbl")
@JsonInclude(Include.NON_EMPTY)
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName;
	private String lastName;
	private double salary;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<Project> projects = new HashSet<>();

	@OneToMany(mappedBy = "employee"  , cascade = CascadeType.ALL  )
	private List<Department> departments = new ArrayList<>();

	LocalDateTime creationTime;

	LocalDateTime updatedOn;

	@PrePersist
	public void EmployeeCreation() {
		this.creationTime = LocalDateTime.now();
		this.updatedOn = LocalDateTime.now();

	}

	@PreUpdate
	public void EmployeeUpdation() {
		this.updatedOn = LocalDateTime.now();

	}

	public Employee(String firstName, String lastName, double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public Employee() {
	}

	public void addProject(Project project) {
		this.projects.add(project);
		for (Project p : projects) {
			p.setEmployee(this);
		}

	}

	public void addDepartment(Department department) {
		
		if(this.departments==null) {
			this.departments=new ArrayList<>();
		}
		this.departments.add(department);
		for (Department dept : departments) {
			dept.setEmployee(this);
		}

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		if (projects == null) {
			this.projects = projects;
		}
		this.projects.addAll(projects);
		for (Project p : projects) {
			p.setEmployee(this);
		}

	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
		for (Department dept : departments) {
			dept.setEmployee(this);
		}
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", projects=" + projects + "]";
	}

}
