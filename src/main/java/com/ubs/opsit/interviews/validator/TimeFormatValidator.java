package com.ubs.opsit.interviews.validator;

/**
 * The Interface TimeFormatValidator.
 */
public interface TimeFormatValidator {
	
	/**
	 * Checks if is valid time.
	 *
	 * @param time the time
	 * @return true, if is valid time
	 */
	public boolean isValidTime(final String time);
}
