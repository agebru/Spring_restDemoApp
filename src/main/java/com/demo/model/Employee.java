package com.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "emp_tbl")
public class Employee {
	@Id
	@GeneratedValue
	private Integer id;

	private String firstName;
	private String lastName;
	private double salary;

	@OneToMany(mappedBy = "employee", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private Set<Project> projects = new HashSet<>();

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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", projects=" + projects + "]";
	}

}
