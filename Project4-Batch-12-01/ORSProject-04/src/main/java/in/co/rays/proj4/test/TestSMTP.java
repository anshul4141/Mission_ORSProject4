package in.co.rays.proj4.test;

import java.util.HashMap;

import in.co.rays.proj4.util.EmailBuilder;
import in.co.rays.proj4.util.EmailMessage;
import in.co.rays.proj4.util.EmailUtility;

public class TestSMTP {

	public static void main(String[] args) {

		testUserRegistrationMail();

	}

	public static void testUserRegistrationMail() {

		HashMap<String, String> map = new HashMap<String, String>();
		EmailMessage msg = new EmailMessage();

		map.put("login", "abhaymalve889@gmail.com");
		map.put("password", "abhy123");

		msg.setTo(map.get("login"));
		msg.setSubject("User Rgistration Information");
		msg.setMessage(EmailBuilder.getUserRegistrationMessage(map));
		msg.setMessageType(EmailMessage.HTML_MSG);

		EmailUtility.sendMail(msg);
		System.out.println("mail send successfully");

	}

}
