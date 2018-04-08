package online.shixun.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_drying")
public class Drying {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date dryingTime;
	private int dryingNumber;
	private String path;
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(
			name="t_drying_employee",
			joinColumns={
					@JoinColumn(name="drying_id")
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
	public Date getDryingTime() {
		return dryingTime;
	}
	public void setDryingTime(Date dryingTime) {
		this.dryingTime = dryingTime;
	}
	public int getDryingNumber() {
		return dryingNumber;
	}
	public void setDryingNumber(int dryingNumber) {
		this.dryingNumber = dryingNumber;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Set<Employee> getEmployees() {
		return Employees;
	}
	public void setEmployees(Set<Employee> employees) {
		Employees = employees;
	}
	public Drying(int id, Date dryingTime, int dryingNumber, String path, Set<Employee> employees) {
		super();
		this.id = id;
		this.dryingTime = dryingTime;
		this.dryingNumber = dryingNumber;
		this.path = path;
		Employees = employees;
	}
	public Drying() {
		super();
	}
	public Drying(Date dryingTime, int dryingNumber, String path, Set<Employee> employees) {
		super();
		this.dryingTime = dryingTime;
		this.dryingNumber = dryingNumber;
		this.path = path;
		Employees = employees;
	}
	public Drying(int id) {
		super();
		this.id = id;
	}
	public Drying(Date dryingTime, int dryingNumber, String path) {
		super();
		this.dryingTime = dryingTime;
		this.dryingNumber = dryingNumber;
		this.path = path;
	}
	@Override
	public String toString() {
		return "Drying [id=" + id + ", dryingTime=" + dryingTime + ", dryingNumber=" + dryingNumber + ", path=" + path
				+ ", Employees=" + Employees + "]";
	}
	

}
