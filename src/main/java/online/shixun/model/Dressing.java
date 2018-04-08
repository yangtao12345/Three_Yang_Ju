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
@Table(name="t_dressing")
public class Dressing {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date dressingTime;
	private String classifyName;
	private int classifyNumber;
	private String path;
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(
			name="t_dressing_employee",
			joinColumns={
					@JoinColumn(name="dressing_id")
			},
			inverseJoinColumns={
					@JoinColumn(name="employee_id")
			}
	)
	private Set<Employee> Employees=new HashSet<Employee>();
	public Set<Employee> getEmployees() {
		return Employees;
	}
	public void setEmployees(Set<Employee> employees) {
		Employees = employees;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDressingTime() {
		return dressingTime;
	}
	public void setDressingTime(Date dressingTime) {
		this.dressingTime = dressingTime;
	}
	public String getClassifyName() {
		return classifyName;
	}
	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	public int getClassifyNumber() {
		return classifyNumber;
	}
	public void setClassifyNumber(int classifyNumber) {
		this.classifyNumber = classifyNumber;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Dressing(int id, Date dressingTime, String classifyName, int classifyNumber, String path,
			Set<Employee> employees) {
		super();
		this.id = id;
		this.dressingTime = dressingTime;
		this.classifyName = classifyName;
		this.classifyNumber = classifyNumber;
		this.path = path;
		Employees = employees;
	}
	public Dressing() {
		super();
	}
	public Dressing(Date dressingTime, String classifyName, int classifyNumber, String path, Set<Employee> employees) {
		super();
		this.dressingTime = dressingTime;
		this.classifyName = classifyName;
		this.classifyNumber = classifyNumber;
		this.path = path;
		Employees = employees;
	}
	public Dressing(int id) {
		super();
		this.id = id;
	}
	public Dressing(Date dressingTime, String classifyName, int classifyNumber, String path) {
		super();
		this.dressingTime = dressingTime;
		this.classifyName = classifyName;
		this.classifyNumber = classifyNumber;
		this.path = path;
	}
	@Override
	public String toString() {
		return "Dressing [id=" + id + ", dressingTime=" + dressingTime + ", classifyName=" + classifyName
				+ ", classifyNumber=" + classifyNumber + ", path=" + path + ", Employees=" + Employees + "]";
	}
	

}
