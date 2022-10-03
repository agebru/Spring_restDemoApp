package com.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// If The ID is auto generated, dont pass it through the contructor. It will give "Detached entity passed" error
	private Integer deptId;
	private String deptName;

	@Embedded
	private Address address;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Course> courses = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "employeeId")
	@JsonIgnore
	private Employee employee;

	public Department() {
	}

	public Department(Integer id, String deptName, Address address) {
		this.deptId = id;
		this.deptName = deptName;
		this.address = address;
	}

	public Integer getDeptId() {
		return deptId;
	}

	/*
	 * public void setDeptId(Integer deptId) { this.deptId = deptId; }
	 */

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
		for (Course crs : courses) {
			crs.setDepartment(this);
		}
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void addCourse(Course course) {
		if (this.courses == null) {
			courses = new ArrayList<>();
		}
		courses.add(course);
		for (Course c : courses) {
			c.setDepartment(this);
		}
	}

}
