package online.shixun.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="authorties")
public class Authorities {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String authority;
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(
			name="t_authorities_employee",
			joinColumns={
					@JoinColumn(name="authorities_id")
			},
			inverseJoinColumns={
					@JoinColumn(name="employee_id")
			}
	)
	private Set<Employee> Employees=new HashSet<Employee>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Set<Employee> getEmployees() {
		return Employees;
	}
	public void setEmployees(Set<Employee> Employees) {
		this.Employees = Employees;
	}
	public Authorities(int id, String authority, Set<Employee> Employees) {
		super();
		this.id = id;
		this.authority = authority;
		this.Employees = Employees;
	}
	public Authorities() {
		super();
	}
	public Authorities(int id) {
		super();
		this.id = id;
	}
	public Authorities(String authority, Set<Employee> Employees) {
		super();
		this.authority = authority;
		this.Employees = Employees;
	}
	@Override
	public String toString() {
		return "Authorities [id=" + id + ", authority=" + authority + "]";
	}
	public Authorities(String authority) {
		super();
		this.authority = authority;
	}
	
	

}
