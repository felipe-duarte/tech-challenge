package com.contractfree.framework.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import com.contractfree.framework.template.EmailTemplate;

public class MailDigest {

	private static final Logger LOGGER = Logger.getLogger(EmailTemplate.class.getName());
	
	public static String digest(String email) {

		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(email.getBytes());
			byte[] byteData = md.digest();

			sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			LOGGER.severe("ERROR DIGEST MAIL" + e.getMessage());
		}
		return sb.toString();
	}
}
