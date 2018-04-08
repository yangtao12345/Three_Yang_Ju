package online.shixun.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.shixun.dao.EmployeeDao;
import online.shixun.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployee() {
		Query query = getSession().createQuery("from Employee");
		return query.list();
	}

	public void saveEmployee(Employee employee) {
		getSession().save(employee);
	}

	public void deleteEmployee(Employee employee) {
		getSession().delete(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> queryEmployee(String username) {
		Query query = getSession().createQuery("from Employee where name=?").setString(0, username);
		return query.list();
	}

	public void updateEmployee(Employee employee) {
		getSession().update(employee);
	}

	public long getTotalSize() {
		Query query = sessionFactory.getCurrentSession().createQuery("select count(id) from Employee");
		long result = (long) query.uniqueResult();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getPage(int pageCount) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Employee");
		query.setMaxResults(5);
		int firstResult = (pageCount - 1) * 5;
		query.setFirstResult(firstResult);
		return query.list();
	}

	public List<Employee> getEmployee(String username, String password) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Employee e where e.name=? and e.password=?");
		query.setString(0, username);
		query.setString(1, password);
		@SuppressWarnings("unchecked")
		List<Employee> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeById(int id) {
		return sessionFactory.getCurrentSession().createQuery("from Employee where id=?").setInteger(0, id).list();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> queryEmployeeByPhone(String phone) {
		return sessionFactory.getCurrentSession().createQuery("from Employee where phone=?").setString(0,phone).list();
	}

}
