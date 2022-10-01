package com.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(Include.NON_EMPTY)
@JsonPropertyOrder
public interface EmployeeDTO {
	String getFirstName();

	String getLastName();

	double getSalary();

	List<ProjectDTO> getProjects();

}
