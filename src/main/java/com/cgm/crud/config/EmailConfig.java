package com.cgm.crud.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost("smtp.gmail.com");
		javaMailSenderImpl.setUsername("jensonarial@gmail.com");
		javaMailSenderImpl.setPassword("qmfnlqijcqdxxmoc\r\n");
		javaMailSenderImpl.setPort(587);
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.auth", true);
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.host", "smtp.gmail.com");
		mailProperties.put("mail.smtp.port", 587);
		mailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		mailProperties.put("mail.smtp.ssl.trust", "*");
		javaMailSenderImpl.setJavaMailProperties(mailProperties);
		return javaMailSenderImpl;
	}
}
