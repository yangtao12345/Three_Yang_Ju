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
@Table(name="t_packing")
public class Packing {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date packingTime;
	private int packingNumber;
	private String path;
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(
			name="t_packing_employee",
			joinColumns={
					@JoinColumn(name="packing_id")
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
	public Date getPackingTime() {
		return packingTime;
	}
	public void setPackingTime(Date packingTime) {
		this.packingTime = packingTime;
	}
	public int getPackingNumber() {
		return packingNumber;
	}
	public void setPackingNumber(int packingNumber) {
		this.packingNumber = packingNumber;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Packing(int id, Date packingTime, int packingNumber, String path, Set<Employee> employees) {
		super();
		this.id = id;
		this.packingTime = packingTime;
		this.packingNumber = packingNumber;
		this.path = path;
		Employees = employees;
	}
	public Packing() {
		super();
	}
	public Packing(Date packingTime, int packingNumber, String path, Set<Employee> employees) {
		super();
		this.packingTime = packingTime;
		this.packingNumber = packingNumber;
		this.path = path;
		Employees = employees;
	}
	public Packing(int id) {
		super();
		this.id = id;
	}
	public Packing(Date packingTime, int packingNumber, String path) {
		super();
		this.packingTime = packingTime;
		this.packingNumber = packingNumber;
		this.path = path;
	}
	@Override
	public String toString() {
		return "Packing [id=" + id + ", packingTime=" + packingTime + ", packingNumber=" + packingNumber + ", path="
				+ path + ", Employees=" + Employees + "]";
	}

}
