package online.shixun.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import online.shixun.model.Employee;
import online.shixun.service.impl.EmployeeServiceImpl;

@Controller
@RequestMapping()
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	@RequestMapping(value = "to_login", method = RequestMethod.GET)
	public String to_login() {
		return "login";
	}

	@RequestMapping(value = "to_forgetPassword", method = RequestMethod.GET)
	public String to_forgetPassword() {
		return "forgetPassword";
	}

	@RequestMapping(value = "/to_main", method = RequestMethod.GET)
	public ModelAndView to_main() {
		ModelAndView mav = new ModelAndView("main");
		return mav;
	}

	@RequestMapping(value = "do_login", method = RequestMethod.POST)
	public String do_login(String username, String password) {
		/* System.out.println(username+password); */
		int i = 0;
		String hashedPassword = null;
		while (i < 1) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			hashedPassword = passwordEncoder.encode(password);
			System.out.println(hashedPassword);
			i++;
		}
		System.out.println(employeeServiceImpl.loginCheck(username, hashedPassword));
		if (employeeServiceImpl.loginCheck(username, hashedPassword)) {
			/* System.out.println("111"); */
			return "redirect:to_main";
		}
		return "redirect:to_login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/to_login?logout";
	}

	@RequestMapping(value = "/to_403", method = RequestMethod.GET)
	public String errorpage() {
		return "403";
	}

	@ResponseBody
	@RequestMapping(value = "checkUsername")
	public String checkUsername(String username) {
		List<Employee> list = employeeServiceImpl.queryEmployee(username);
		if (list.isEmpty()) {
			return "NO";
		} else {
			return "OK";
		}
	}
	@ResponseBody
	@RequestMapping(value = "checkPhone")
	public String checkPhone(String username,String phone) {
		List<Employee> list = employeeServiceImpl.queryEmployee(username);
		String phone1=null;
		for (Employee employee1 : list) {
			phone1=employee1.getPhone();
		}
		
		if (phone.equals(phone1)) {
			return "OK";
		} else {
			return "NO";
		}
	}
	
}
