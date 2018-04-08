package online.shixun.test;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import online.shixun.dao.impl.AuthoritiesDaoImpl;
import online.shixun.dao.impl.EmployeeDaoImpl;
import online.shixun.model.Employee;
import online.shixun.model.Wrap;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@WebAppConfiguration("src/main/resources")
@Rollback(false)
@Transactional(value="txManager")
public class TestDB {
	@Autowired
	AuthoritiesDaoImpl authoritiesDaoImpl;
	@Autowired
	EmployeeDaoImpl employeeDaoImpl;
	@Repeat(5)
	@Test
	public void TestEmployee(){
		List<Employee> employeeList=employeeDaoImpl.queryEmployee("yangtao");
		Set<Wrap> wraps=new HashSet<Wrap>();
		Wrap wrap=new Wrap(new Date(),100,"C://");
		wraps.add(wrap);
		Employee employee=new Employee();
		for (Employee employee1 : employeeList) {
			employee=employee1;
		}
		employee.setWrap(wraps);
		employeeDaoImpl.saveEmployee(employee);
		/*Set<Employee> employees=new HashSet<Employee>();
		int i=0;
		String hashedPassword=null;
		while(i<1){
			String password="123456";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			hashedPassword = passwordEncoder.encode(password);
			System.out.println(hashedPassword);
			i++;
		}
		Employee employee=new Employee("heqingmao",hashedPassword,"男",true);
		employees.add(employee);
		Authorities authorities=new Authorities("ROLE_EMPLOYEE3");
		authorities.setEmployees(employees);
		authoritiesDaoImpl.save(authorities);*/
	}

}
