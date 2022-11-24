package com.amazon.ask.voicebanking.utils;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.security.core.context.SecurityContextHolder;

import com.amazon.ask.model.User;
import com.amazon.ask.voicebanking.dao.Database;
import com.amazon.ask.voicebanking.model.BankingFormVO;
public class BaseMethods {
	public static String getUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUserId();
		return userName;
	}

	public static String generatePassword() {

		int n = 8;
		// chose a Character random from this String
		String AlphaNumericString = "abcdefghijklmnopqrstuvxyz" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	public static void sendMail(String email,String accountName) {
		System.out.println("in mail send method::::");
		java.util.Properties properties = new java.util.Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);

		try {
			MimeMessage message = new MimeMessage(mailSession);
			Database obj=new Database();
			BankingFormVO bankingFormVO=obj.formByName(accountName);
			String path=bankingFormVO.getBankingFormlink();
			System.out.println(path);
			message.setContent("You can download the form from <a href="+path+" download target='_blank'> Download </a>", "text/html");
			message.setSubject("Digital Form for "+accountName);

			InternetAddress sender = new InternetAddress("----------@gmail.com", "project");
			InternetAddress receiver = new InternetAddress(email);
			message.setFrom(sender);
			message.setRecipient(Message.RecipientType.TO, receiver);
			message.saveChanges();

			javax.mail.Transport transport = mailSession.getTransport("smtp");
			transport.connect("smtp.gmail.com", 587, "-------------------@gmail.com", "----password");
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Msg sent :::: ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
