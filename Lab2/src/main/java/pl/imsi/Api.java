package pl.imsi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Api {

	private Manager manager;

	@Autowired
	public Api(Manager manager) {
		super();
		this.manager = manager;
	}
	
	@GetMapping("/allEmployees")
	public Iterable<Employee>getAll(){
		return manager.findAll();
		}
	
	@GetMapping("/idEmployee")
	public Optional<Employee> getById(@RequestParam Long index){
		return manager.findById(index);
	}	
	
	@PostMapping("/saveEmployee")
	public Employee addEmployee(@RequestBody Employee employee ) {
		return manager.save(employee);
	}
	
	@DeleteMapping("/delEmployee")
	public void deleteEmployee(@RequestParam Long index) {
		manager.deleteById(index);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee ) {
		return manager.save(employee);
	
	}
	
	@GetMapping("/nameEmployee")
	public Iterable<Employee> getByLastName(@RequestParam String index){
		return manager.findByLastName(index);
	}
	
	
	@GetMapping("/allDepartments")
	public Iterable<Department>getAll1(){
		return manager.findAll1();
	}
	
	@GetMapping("/idDepartment")
	public Optional<Department> getById1(@RequestParam Long index){
		return manager.findById1(index);
	}	
	
	@PostMapping("/addDepartment")
	public Department addDepartment(@RequestBody Department department ) {
		return manager.save(department);
	}
	
	@DeleteMapping("/delDepartment")
	public void deleteDepartment(@RequestParam Long index) {
		manager.deleteById1(index);
	}
}

