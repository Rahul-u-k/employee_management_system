package com.rahul.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContainingIgnoreCase(String name);
}