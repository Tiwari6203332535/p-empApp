package com.empapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String to, String sub, String message) {
		SimpleMailMessage sms = new SimpleMailMessage();
		sms.setTo(to);
		sms.setSubject(sub);
		sms.setText(message);

		javaMailSender.send(sms);
	}

}
