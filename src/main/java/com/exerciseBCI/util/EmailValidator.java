package com.exerciseBCI.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailValidator {
	private static Pattern pattern;
	private static Matcher matcher;

	private static final String EMAIL_PATTERN = 
		"^[^@]+@[^@]+\\.cl$";

	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
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
