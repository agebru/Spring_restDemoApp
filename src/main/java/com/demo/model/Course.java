package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Dont pass Id through the constructor since it's auto generatd. Else it will give "DETACHED ENTITY PASSED" error
	private Integer id;
	private String courseName;
	private int crtHr;

	@ManyToOne
	@JoinColumn(name = "departmentId")
	@JsonIgnore
	private Department department;

	public Course() {
	}

	public Course(String courseName, int crtHr) {
		this.courseName = courseName;
		this.crtHr = crtHr;
	}

	public Integer getId() {
		return id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCrtHr() {
		return crtHr;
	}

	public void setCrtHr(int crtHr) {
		this.crtHr = crtHr;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", crtHr=" + crtHr + ", department=" + department
				+ "]";
	}

}
