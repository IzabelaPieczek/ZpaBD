package pl.imsi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	//Zadanie2
	Iterable<Employee> findByFirstName(String firstName);
	
	//Zadanie3
	@Query("SELECT e FROM Employee e where e.lastName LIKE %?1")
	Iterable<Employee> findAllWhereName(String lastName);

}
