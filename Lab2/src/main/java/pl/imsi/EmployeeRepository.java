package pl.imsi;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	Iterable<Employee> findByLastName(String lastName);
}
