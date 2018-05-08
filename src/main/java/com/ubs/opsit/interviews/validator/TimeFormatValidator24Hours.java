package com.ubs.opsit.interviews.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class TimeFormatValidator24Hours implements TimeFormatValidator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String TIME24HOURS_PATTERN = "(([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9])|24:00:00";

	public TimeFormatValidator24Hours() {
		pattern = Pattern.compile(TIME24HOURS_PATTERN);
	}

	public boolean isValidTime(final String time) {
		if (StringUtils.isNotBlank(time)) {
			matcher = pattern.matcher(time);
			return matcher.matches();
		}
		return false;
	}
}