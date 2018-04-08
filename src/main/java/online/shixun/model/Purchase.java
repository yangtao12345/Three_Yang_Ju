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
@Table(name="t_purchase")
public class Purchase {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date purchaseTime;
	private int purchaseNumber;
	private String path;
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(
			name="t_purchase_employee",
			joinColumns={
					@JoinColumn(name="purchase_id")
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
	public Date getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public int getPurchaseNumber() {
		return purchaseNumber;
	}
	public void setPurchaseNumber(int purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Purchase(int id, Date purchaseTime, int purchaseNumber, String path, Set<Employee> employees) {
		super();
		this.id = id;
		this.purchaseTime = purchaseTime;
		this.purchaseNumber = purchaseNumber;
		this.path = path;
		Employees = employees;
	}
	public Purchase(Date purchaseTime, int purchaseNumber, String path, Set<Employee> employees) {
		super();
		this.purchaseTime = purchaseTime;
		this.purchaseNumber = purchaseNumber;
		this.path = path;
		Employees = employees;
	}
	public Purchase(int id) {
		super();
		this.id = id;
	}
	public Purchase() {
		super();
	}
	public Set<Employee> getEmployees() {
		return Employees;
	}
	public void setEmployees(Set<Employee> employees) {
		Employees = employees;
	}
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", purchaseTime=" + purchaseTime + ", purchaseNumber=" + purchaseNumber
				+ ", path=" + path + ", Employees=" + Employees + "]";
	}
	public Purchase(Date purchaseTime, int purchaseNumber, String path) {
		super();
		this.purchaseTime = purchaseTime;
		this.purchaseNumber = purchaseNumber;
		this.path = path;
	}
	

}
