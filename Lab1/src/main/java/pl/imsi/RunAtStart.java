package pl.imsi;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunAtStart {
	
	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;

	@Autowired
	public RunAtStart(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}


	@PostConstruct
	public void runAtStart() {
		Department department = new Department();
		department.setDeptName("Sales");	
		department.setJob("Manager");
		departmentRepository.save(department);
		
		Department department2 = new Department();
		department2.setDeptName("Development");	
		department2.setJob("Engineering");
		departmentRepository.save(department2);
		
		Employee employee = new Employee();
		employee.setDepartment(department);
		employee.setFirstName("Jan");	
		employee.setLastName("Kowalski");
		employee.setSalary(new BigDecimal("3000"));
		employeeRepository.save(employee);
		
		Employee employee2 = new Employee();
		employee2.setDepartment(department);
		employee2.setFirstName("Anna");	
		employee2.setLastName("Nowak");
		employee2.setSalary(new BigDecimal("4500"));
		employeeRepository.save(employee2);
		
		Employee employee3 = new Employee();
		employee3.setDepartment(department2);
		employee3.setFirstName("Karol");	
		employee3.setLastName("Marciniak");
		employee3.setSalary(new BigDecimal("10000"));
		employeeRepository.save(employee3);
		
		
		//Zadanie2 
		System.out.println(employee);
		System.out.println(employee2);
		System.out.println(employee3);
		
		//Zadanie3
		Iterable<Employee> em = employeeRepository.findAllWhereName("K%");
		Employee k= em.iterator( ).next();
		System.out.println( "Nazwisko na K: "+ k);
		
	}

}
