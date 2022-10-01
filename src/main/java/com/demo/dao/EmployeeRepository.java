package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.dto.EmployeeDTO;
import com.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("select DISTINCT e from Employee e join fetch e.projects")
	public List<Employee> findAllJoinFetch();
	
	List<EmployeeDTO> findBy();
}
