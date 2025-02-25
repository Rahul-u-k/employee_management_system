package com.rahul.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rahul.customexception.EmployeeNotFoundException;
import com.rahul.customexception.ResourceNotFoundException;
import com.rahul.entity.Employee;
import com.rahul.repo.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        // Fetch the existing employee by ID
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        // Update fields with respect to the entity class you have
        if (updatedEmployee.getName() != null) {
            emp.setName(updatedEmployee.getName());
        }
        
        if (updatedEmployee.getEmail() != null) {
            emp.setEmail(updatedEmployee.getEmail());
        }
      
        if (updatedEmployee.getPhoneNumber() != null) {
            emp.setPhoneNumber(updatedEmployee.getPhoneNumber());
        }
        if (updatedEmployee.getDepartment() != null) {
            emp.setDepartment(updatedEmployee.getDepartment());
        }

        return employeeRepository.save(emp); // Save and return the updated employee
    }


    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
    
    public List<Employee> searchEmployees(String name) {
        // Find employees by name (case-insensitive search)
        List<Employee> employees = employeeRepository.findByNameContainingIgnoreCase(name);

        // If no employees found, throw custom exception
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundException("No employees found with the name: " + name);
        }

        return employees;
    }
}