package com.example.demo;


import java.math.BigDecimal;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManager {
	
	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;

	@Autowired
	public EmployeeManager(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
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
	
	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}

	@PostConstruct
	public void runAtStart() {
		Department department1 = new Department();
		department1.setDeptName("Departament Tajemnic");
		departmentRepository.save(department1);
		
		Department department2 = new Department();
		department2.setDeptName("Departament Kontroli Nad Magicnzymi Stworzeniami");
		departmentRepository.save(department2);
		
		Employee employee1 = new Employee();
		employee1.setFirstName("Harry");
		employee1.setLastName("Potter");
		employee1.setSalary(new BigDecimal("6000"));
		employee1.setDepartment(department1);
		employeeRepository.save(employee1);
		
		Employee employee2 = new Employee();
		employee2.setFirstName("Ron");
		employee2.setLastName("Wesley");
		employee2.setSalary(new BigDecimal("8000"));
		employee2.setDepartment(department2);
		employeeRepository.save(employee2);
		
		Employee employee3 = new Employee();
		employee3.setFirstName("Hermiona");
		employee3.setLastName("Granger");
		employee3.setSalary(new BigDecimal("9500"));
		employee3.setDepartment(department2);
		employeeRepository.save(employee3);
		
		Employee employee4 = new Employee();
		employee4.setFirstName("Draco");
		employee4.setLastName("Malfoy");
		employee4.setSalary(new BigDecimal("7500"));
		employee4.setDepartment(department1);
		employeeRepository.save(employee4);
		
		
		/*
		 * Iterable<Employee> janki = employeeRepository.findByfirstName("Jan");
		 * Employee jan = janki.iterator().next(); System.out.println("ziomek: " + jan);
		 * 
		 * Iterable<Employee> em =
		 * departmentRepository.findAllWhereLastNameAndDeptId("Kowalski", (long) 1);
		 * for(Employee e:em) { System.out.println("EmployeeFromMethod " + e); }
		 */
		}	
	}

