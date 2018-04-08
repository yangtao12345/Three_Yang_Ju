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
@Table(name="t_wrap")
public class Wrap {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date wrapTime;
	private int wrapNUmber;
	private String path;
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(
			name="t_wrap_employee",
			joinColumns={
					@JoinColumn(name="wrap_id")
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
	public Date getWrapTime() {
		return wrapTime;
	}
	public void setWrapTime(Date wrapTime) {
		this.wrapTime = wrapTime;
	}
	public int getWrapNUmber() {
		return wrapNUmber;
	}
	public void setWrapNUmber(int wrapNUmber) {
		this.wrapNUmber = wrapNUmber;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Wrap(int id, Date wrapTime, int wrapNUmber, String path, Set<Employee> employees) {
		super();
		this.id = id;
		this.wrapTime = wrapTime;
		this.wrapNUmber = wrapNUmber;
		this.path = path;
		Employees = employees;
	}
	public Wrap() {
		super();
	}
	public Wrap(Date wrapTime, int wrapNUmber, String path, Set<Employee> employees) {
		super();
		this.wrapTime = wrapTime;
		this.wrapNUmber = wrapNUmber;
		this.path = path;
		Employees = employees;
	}
	public Wrap(int id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "Wrap [id=" + id + ", wrapTime=" + wrapTime + ", wrapNUmber=" + wrapNUmber + ", path=" + path
				+ ", Employees=" + Employees + "]";
	}
	public Set<Employee> getEmployees() {
		return Employees;
	}
	public void setEmployees(Set<Employee> employees) {
		Employees = employees;
	}
	public Wrap(Date wrapTime, int wrapNUmber, String path) {
		super();
		this.wrapTime = wrapTime;
		this.wrapNUmber = wrapNUmber;
		this.path = path;
	}
	

}
