package pl.imsi;

import java.math.BigDecimal;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class Manager {

	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;

	@Autowired
	public Manager(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}

	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}

	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}

	public Employee update(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Iterable<Employee> findByLastName(String lastName) {
		return employeeRepository.findByLastName(lastName);
	}

	public Iterable<Department> findAll1() {
		return departmentRepository.findAll();
	}

	public Optional<Department> findById1(Long id) {
		return departmentRepository.findById(id);
	}

	public Department save(Department department) {
		return departmentRepository.save(department);
	}

	public void deleteById1(Long id) {
		departmentRepository.deleteById(id);
	}

	
	  
	  @PostConstruct public void runAtStart() {
	  
		  Department department1 = new Department(); 
		  department1.setDeptName("Sales");
		  department1.setJob("Manager"); 
		  //department1.setEmployees(null);
		  departmentRepository.save(department1);
		  
		  Department department2 = new Department();
		  department2.setDeptName("Development"); 
		  department2.setJob("Engineering");
		  //department2.setEmployees(null); 
		  departmentRepository.save(department2);
		  	  
		  Employee employee1 = new Employee(); 
		  employee1.setFirstName("Harry");
		  employee1.setLastName("Potter"); 
		  employee1.setSalary(new BigDecimal("3500"));
		  employee1.setDepartment(department1); 
		  employeeRepository.save(employee1);
		  
		  Employee employee2 = new Employee(); 
		  employee2.setFirstName("Ron");
		  employee2.setLastName("Wesley"); 
		  employee2.setSalary(new BigDecimal("4500"));
		  employee2.setDepartment(department1); 
		  employeeRepository.save(employee2);
		  
		  Employee employee4 = new Employee(); 
		  employee4.setFirstName("Draco");
		  employee4.setLastName("Malfoy"); 
		  employee4.setSalary(new BigDecimal("5000"));
		  employee4.setDepartment(department2); 
		  employeeRepository.save(employee4);
		  
		  Employee employee3 = new Employee(); 
		  employee3.setFirstName("Hemriona");
		  employee3.setLastName("Granger"); 
		  employee3.setSalary(new
		  BigDecimal("7500")); 
		  employee3.setDepartment(department2);
		  employeeRepository.save(employee3); 
		  }
}
