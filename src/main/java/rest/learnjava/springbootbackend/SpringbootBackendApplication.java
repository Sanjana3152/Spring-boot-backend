package rest.learnjava.springbootbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rest.learnjava.springbootbackend.model.Employee;
import rest.learnjava.springbootbackend.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		
		
		Employee employee = new Employee();
		employee.setFirstname("sanjana");
		employee.setLastname("Chauhan");
		employee.setEmailId("sanjana.chauhan");
		employeeRepository.save(employee);
		
		
		
		
		Employee employee1 = new Employee();
		employee1.setFirstname("Rakesh");
		employee1.setLastname("Chauhan");
		employee1.setEmailId("Rakesh.chauhan");
		employeeRepository.save(employee1);
		
		
		
		
		//Employee employee2 = new Employee();
		//employee2.setFirstname("sangeeta");
		//employee2.setLastname("yadav");
		//employee2.setEmailId("sangeeta.yadav");
		//employeeRepository.save(employee2);
		
		
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
