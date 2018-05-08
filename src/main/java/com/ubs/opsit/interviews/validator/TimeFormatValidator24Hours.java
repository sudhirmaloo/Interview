package com.ubs.opsit.interviews.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * The Class TimeFormatValidator24Hours.
 * This class is a time format validator class 
 * returns true; if input string is valid as per 24 Hours format.
 * else returns false.
 * 
 */
public class TimeFormatValidator24Hours implements TimeFormatValidator {

	/** The pattern. */
	private Pattern pattern;
	
	/** The matcher. */
	private Matcher matcher;

	/** The Constant TIME24HOURS_PATTERN. */
	private static final String TIME24HOURS_PATTERN = "(([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9])|24:00:00";

	/**
	 * Instantiates a new time format validator 24 hours.
	 */
	public TimeFormatValidator24Hours() {
		pattern = Pattern.compile(TIME24HOURS_PATTERN);
	}

	/* (non-Javadoc)
	 * @see com.ubs.opsit.interviews.validator.TimeFormatValidator#isValidTime(java.lang.String)
	 */
	public boolean isValidTime(final String time) {
		if (StringUtils.isNotBlank(time)) {
			matcher = pattern.matcher(time);
			return matcher.matches();
		}
		return false;
	}
}