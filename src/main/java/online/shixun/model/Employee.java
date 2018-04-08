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
@Table(name="t_employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private String sex;
	private boolean enable;
	private String phone;
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Set<Purchase> getPurchase() {
		return purchase;
	}

	public void setPurchase(Set<Purchase> purchase) {
		this.purchase = purchase;
	}

	public Set<Wrap> getWrap() {
		return wrap;
	}

	public void setWrap(Set<Wrap> wrap) {
		this.wrap = wrap;
	}

	public Set<Drying> getDrying() {
		return drying;
	}

	public void setDrying(Set<Drying> drying) {
		this.drying = drying;
	}

	public Set<Packing> getPacking() {
		return packing;
	}

	public void setPacking(Set<Packing> packing) {
		this.packing = packing;
	}

	public Set<Dressing> getDressing() {
		return dressing;
	}

	public void setDressing(Set<Dressing> dressing) {
		this.dressing = dressing;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name="t_authorities_employee",
			joinColumns={
					@JoinColumn(name="employee_id")
			},
			inverseJoinColumns={
					@JoinColumn(name="authorities_id")
			}
	)
	private Set<Authorities> authorities=new HashSet<Authorities>();
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name="t_purchase_employee",
			joinColumns={
					@JoinColumn(name="employee_id")
			},
			inverseJoinColumns={
					@JoinColumn(name="purchase_id")
			}
	)
	private Set<Purchase> purchase=new HashSet<Purchase>();
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name="t_wrap_employee",
			joinColumns={
					@JoinColumn(name="employee_id")
			},
			inverseJoinColumns={
					@JoinColumn(name="wrap_id")
			}
	)
	private Set<Wrap> wrap=new HashSet<Wrap>();
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name="t_drying_employee",
			joinColumns={
					@JoinColumn(name="employee_id")
			},
			inverseJoinColumns={
					@JoinColumn(name="drying_id")
			}
	)
	private Set<Drying> drying=new HashSet<Drying>();
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name="t_packing_employee",
			joinColumns={
					@JoinColumn(name="employee_id")
			},
			inverseJoinColumns={
					@JoinColumn(name="packing_id")
			}
	)
	private Set<Packing> packing=new HashSet<Packing>();
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name="t_dressing_employee",
			joinColumns={
					@JoinColumn(name="employee_id")
			},
			inverseJoinColumns={
					@JoinColumn(name="dressing_id")
			}
	)
	private Set<Dressing> dressing=new HashSet<Dressing>();
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name="t_product_employee",
			joinColumns={
					@JoinColumn(name="employee_id")
			},
			inverseJoinColumns={
					@JoinColumn(name="product_id")
			}
	)
	private Set<Product> product=new HashSet<Product>();

	public Set<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public Employee(int id, String name, String password, String sex, boolean enable, Set<Authorities> authorities,
			Set<Purchase> purchase, Set<Wrap> wrap, Set<Drying> drying, Set<Packing> packing, Set<Dressing> dressing,
			Set<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.enable = enable;
		this.authorities = authorities;
		this.purchase = purchase;
		this.wrap = wrap;
		this.drying = drying;
		this.packing = packing;
		this.dressing = dressing;
		this.product = product;
	}

	public Employee() {
		super();
	}

	public Employee(String name, String password, String sex, boolean enable, Set<Authorities> authorities,
			Set<Purchase> purchase, Set<Wrap> wrap, Set<Drying> drying, Set<Packing> packing, Set<Dressing> dressing,
			Set<Product> product) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.enable = enable;
		this.authorities = authorities;
		this.purchase = purchase;
		this.wrap = wrap;
		this.drying = drying;
		this.packing = packing;
		this.dressing = dressing;
		this.product = product;
	}

	public Employee(int id) {
		super();
		this.id = id;
	}

	public Employee(String name, String password, String sex, boolean enable) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.enable = enable;
	}

	public Employee(String name, String password, String sex, boolean enable, String phone) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.enable = enable;
		this.phone = phone;
	}
	
	

}
