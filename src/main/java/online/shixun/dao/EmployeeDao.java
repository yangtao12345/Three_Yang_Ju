package online.shixun.dao;

import java.util.List;

import online.shixun.model.Employee;

public interface EmployeeDao {
	public List<Employee> listEmployee();

	/*
	 * 保存用户信息
	 */
	public void saveEmployee(Employee employee);

	/*
	 * 删除用户
	 */
	public void deleteEmployee(Employee employee);

	/*
	 * 查询用户
	 */
	public List<Employee> queryEmployee(String username);

	/*
	 * 修改用户信息
	 */
	public void updateEmployee(Employee employee);

	/*
	 * 获取页数
	 */
	public long getTotalSize();

	/*
	 * 根据页数查询
	 */
	public List<Employee> getPage(int pageCount);

	/*
	 * 登录验证
	 */
	public List<Employee> getEmployee(String username, String password);

	public List<Employee> getEmployeeById(int id);
	
	public List<Employee> queryEmployeeByPhone(String phone);
}
