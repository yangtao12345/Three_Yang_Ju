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
@Table(name="t_product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date productTime;
	private int productNumber;
	private String department;
	private String path;
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(
			name="t_product_employee",
			joinColumns={
					@JoinColumn(name="product_id")
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
	public Date getProductTime() {
		return productTime;
	}
	public void setProductTime(Date productTime) {
		this.productTime = productTime;
	}
	public int getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Product(int id, Date productTime, int productNumber, String department, String path,
			Set<Employee> employees) {
		super();
		this.id = id;
		this.productTime = productTime;
		this.productNumber = productNumber;
		this.department = department;
		this.path = path;
		Employees = employees;
	}
	public Product() {
		super();
	}
	public Product(Date productTime, int productNumber, String department, String path, Set<Employee> employees) {
		super();
		this.productTime = productTime;
		this.productNumber = productNumber;
		this.department = department;
		this.path = path;
		Employees = employees;
	}
	public Product(int id) {
		super();
		this.id = id;
	}
	public Product(Date productTime, int productNumber, String department, String path) {
		super();
		this.productTime = productTime;
		this.productNumber = productNumber;
		this.department = department;
		this.path = path;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productTime=" + productTime + ", productNumber=" + productNumber
				+ ", department=" + department + ", path=" + path + ", Employees=" + Employees + "]";
	}

}
