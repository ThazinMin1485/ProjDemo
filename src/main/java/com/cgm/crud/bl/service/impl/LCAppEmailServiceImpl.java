//package com.cgm.crud.bl.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.cgm.crud.bl.dto.EmployeeDto;
//import com.cgm.crud.bl.service.EmployeeServices;
//import com.cgm.crud.bl.service.LCAppEmailService;
//
//@Service
//public class LCAppEmailServiceImpl implements LCAppEmailService {
//
//	@Autowired
//	private JavaMailSenderImpl javaMailSender;
//	
//	@Autowired
//	private EmployeeServices empServices;
//
//	@Override
//	public void sendEmail(String userEmail) throws UsernameNotFoundException{
//		EmployeeDto emp=empServices.findByEmail(userEmail);
//		if(emp==null) {
//			throw new UsernameNotFoundException("Employee not found");
//		}
//		SimpleMailMessage newEmail = new SimpleMailMessage();
//		newEmail.setTo(emp.getEmail());
//		newEmail.setSubject("Password Reset Link");
//		newEmail.setText("Hello,"+"\n\n" + "You have requested to reset your password."
//				+ "\n\n"+"Click the link below to change your password:"
//				+"\n\n"+ "<a href='passwordProcess' />Change my password</a>"
//				+ "\n\n"+"Ignore this email if you do remember your password or you have not make the request");
//		javaMailSender.send(newEmail);
//	}
//}
