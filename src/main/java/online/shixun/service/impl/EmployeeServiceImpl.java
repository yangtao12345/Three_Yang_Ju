package online.shixun.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.dao.impl.EmployeeDaoImpl;
import online.shixun.model.Employee;
import online.shixun.service.EmployeeService;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDaoImpl employeeDaoImpl;

	public List<Employee> listEmployee() {
		return employeeDaoImpl.listEmployee();
	}

	public void saveEmployee(Employee employee) {
		employeeDaoImpl.saveEmployee(employee);
	}

	public void deleteEmployee(Employee employee) {
		employeeDaoImpl.deleteEmployee(employee);
	}

	public List<Employee> queryEmployee(String username) {
		
		return employeeDaoImpl.queryEmployee(username);
	}

	public void updateEmployee(Employee employee) {
		employeeDaoImpl.updateEmployee(employee);
	}

	public long getTotalSize() {
		return employeeDaoImpl.getTotalSize();
	}

	public List<Employee> getPage(int pageCount) {
		return employeeDaoImpl.getPage(pageCount);
	}

	@Override
	public List<Employee> getEmployee(String username, String password) {
		return employeeDaoImpl.getEmployee(username, password);
	}

	@Override
	public List<Employee> getEmployeeById(int id) {
		return employeeDaoImpl.getEmployeeById(id);
	}
	public boolean loginCheck(String username, String password) {
		if (employeeDaoImpl.getEmployee(username, password)==null||employeeDaoImpl.getEmployee(username, password).size()<1){
			return false;
		}
		return true;
	}

	@Override
	public List<Employee> queryEmployeeByPhone(String phone) {
		return employeeDaoImpl.queryEmployeeByPhone(phone);
	}

}
