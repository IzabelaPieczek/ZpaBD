package pl.imsi;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//import org.hibernate.annotations.CascadeType;
//import javax.persistence.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long IdDept;
	private String deptName;
	private String job;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "department")
	//cascade= {CascadeType.REFRESH, CascadeType.REMOVE},
	private Set<Employee> employees;

	public Long getIdDept() {
		return IdDept;
	}

	public void setIdDept(Long idDept) {
		IdDept = idDept;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [IdDept=" + IdDept + ", deptName=" + deptName + ", job=" + job + ", employees=" + employees
				+ "]";
	}
	
	
}