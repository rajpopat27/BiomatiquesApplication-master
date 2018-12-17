package com.biomatiques.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biomatiques.model.Employee;
import com.biomatiques.repository.EmployeeRepository;



@Service
public class EmployeeService {
   
    @Autowired
    private EmployeeRepository employeeRepository;
   
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeList::add);
        return employeeList;
    }
   
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    
    public void updateEmployee(Employee employee) {
    	employeeRepository.save(employee);
    }
    public void deleteEmployee(long id) {
    	employeeRepository.deleteById(id);
    }

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
		
		
	}
}