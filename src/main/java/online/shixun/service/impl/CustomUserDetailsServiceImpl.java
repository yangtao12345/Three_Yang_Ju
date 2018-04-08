package online.shixun.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import online.shixun.model.Authorities;
import online.shixun.model.Employee;
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@Transactional()
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("1111");
		List<Employee> employees = employeeServiceImpl.queryEmployee(username);
		Employee employee = null;
		for (Employee employee1 : employees) {
			employee = employee1;
		}
		if (employee == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(employee.getName(), employee.getPassword(),employee.isEnable(),true,true,true,getGrantedAuthorities(employee));
	}
	private List<GrantedAuthority> getGrantedAuthorities(Employee employee){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Authorities userProfile : employee.getAuthorities()){
			System.out.println("UserProfile : "+userProfile);
			authorities.add(new SimpleGrantedAuthority(userProfile.getAuthority()));
		}
		return authorities;
	}
}
	


