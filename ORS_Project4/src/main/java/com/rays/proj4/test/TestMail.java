package com.rays.proj4.test;

import java.util.HashMap;

import com.rays.proj4.exception.ApplicationException;
import com.rays.proj4.util.EmailBuilder;
import com.rays.proj4.util.EmailMessage;
import com.rays.proj4.util.EmailUtility;

public class TestMail {

	public static void main(String[] args) throws ApplicationException {

		testUserRegistrationMail();

	}

	private static void testUserRegistrationMail() throws ApplicationException {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", "apurvaraut9@gmail.com");
		map.put("password", "apurva123");

		String message = EmailBuilder.getUserRegistrationMessage(map);

		System.out.println("message == " + message);

		EmailMessage msg = new EmailMessage();

		msg.setTo("apurvaraut9@gmail.com");
		msg.setSubject("Registration is successful for ORSProject-04");
		msg.setMessage(message);
		msg.setMessageType(EmailMessage.HTML_MSG);

		EmailUtility.sendMail(msg);

		System.out.println("mail send successfully");
	}

}
