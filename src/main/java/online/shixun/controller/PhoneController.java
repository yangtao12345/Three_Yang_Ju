package online.shixun.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import online.shixun.common1.SendMsg_webchinese;
import online.shixun.model.Employee;
import online.shixun.service.impl.EmployeeServiceImpl;
@Controller
@RequestMapping()
public class PhoneController {
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	private static final String VALIDATE_PHONE_CODE = "VALIDATE_PHONE_CODE";
	private static final String VALIDATE_PHONE = "VALIDATE_PHONE";
	
	@RequestMapping("sendCode")
	@ResponseBody
	protected void sendCode(String phone, HttpServletRequest request) throws HttpException, IOException {
		StringBuilder code = new StringBuilder();
		Random random = new Random();
		// 6位验证码
		for (int i = 0; i < 6; i++) {
			code.append(String.valueOf(random.nextInt(10)));
		}
		HttpSession session = request.getSession();
		session.setAttribute(VALIDATE_PHONE, phone);
		session.setAttribute(VALIDATE_PHONE_CODE, code.toString());
		String smsText = "验证码：" + code;
		System.out.println("手机号：" + phone + ", " + smsText);
		SendMsg_webchinese.sendMessage(phone, smsText);
	}
	@RequestMapping("checkCode")
	public String checkCode(HttpServletRequest request,String code) throws HttpException{
		HttpSession session=request.getSession();
		String phoneCode=(String) session.getAttribute(VALIDATE_PHONE_CODE);
		System.out.println(phoneCode);
		if(code.equals(phoneCode)){
			return "resetPassword";
		}else{
			return "forgetPassword";
		}
		
	}
	@RequestMapping("resetPassword")
	public String resetPassword(String password,HttpServletRequest request){
		HttpSession session=request.getSession();
		String phone=(String) session.getAttribute(VALIDATE_PHONE);
		int i = 0;
		String hashedPassword=null;
		while (i < 1) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			hashedPassword = passwordEncoder.encode(password);

			System.out.println(hashedPassword);
			i++;
		}
		List<Employee> list=employeeServiceImpl.queryEmployeeByPhone(phone);
		Employee employee=null;
		for (Employee employee1 : list) {
			employee=employee1;
		}
		employee.setPassword(hashedPassword);
		return "login";
	}

}
