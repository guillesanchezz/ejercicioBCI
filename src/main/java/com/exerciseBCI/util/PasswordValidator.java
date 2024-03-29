package com.exerciseBCI.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PasswordValidator {
	private static Pattern pattern;
	private static Matcher matcher;

	private static final String PASSWORD_PATTERN = 
		"^(?=\\w*\\d{2})(?=\\w*[A-Z])(?=\\w*[a-z])\\S{4,}$";

	public PasswordValidator() {
		pattern = Pattern.compile(PASSWORD_PATTERN);
	}

	/**
	 * Validate hex with regular expression
	 * 
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public static boolean validate(final String hex) {
		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
}
