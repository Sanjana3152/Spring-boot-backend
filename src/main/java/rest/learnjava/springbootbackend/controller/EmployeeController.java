package rest.learnjava.springbootbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.learnjava.springbootbackend.exception.ResourceNotFoundException;
import rest.learnjava.springbootbackend.model.Employee;
import rest.learnjava.springbootbackend.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public List<Employee>getAllEmployees(){
		
		return employeeRepository.findAll();
		
	}
	
	
	
	//buid create rest api
	@PostMapping
	public Employee creatEmployee(@RequestBody Employee employee) {
		
		
		return employeeRepository.save(employee);
		
		
		
		
	
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exits with id: "+ id));
		return ResponseEntity.ok(employee);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(Long id, Employee employeeDetails){
		Employee updateEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id : "+ id));
		updateEmployee.setFirstname(employeeDetails.getFirstname());
		updateEmployee.setLastname(employeeDetails.getLastname());
		updateEmployee.setEmailId(employeeDetails.getEmailId());
		employeeRepository.save(updateEmployee);
		
		
		
		
		return ResponseEntity.ok(updateEmployee);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
		
		Employee employee= employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee not exist with the id "+ id));
		employeeRepository.delete(employee);
		
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	

}
