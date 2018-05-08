package com.ubs.opsit.interviews;

import java.util.Arrays;
import java.util.Collections;

import com.ubs.opsit.interviews.constants.CommonConstants;
import com.ubs.opsit.interviews.validator.TimeFormatValidator;
import com.ubs.opsit.interviews.validator.TimeFormatValidator24Hours;

/**
 * The Class BerlinClockTimeConverter.
 * This class will convert the 24 Hour time (HH:mm:ss) in Berlin clock representation.
 */
public class BerlinClockTimeConverter implements TimeConverter {

	/** The time format validator. */
	private TimeFormatValidator timeFormatValidator;

	/**
	 * Instantiates a new berlin clock time converter.
	 */
	public BerlinClockTimeConverter() {
		timeFormatValidator = new TimeFormatValidator24Hours();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ubs.opsit.interviews.TimeConverter#convertTime(java.lang.String)
	 */
	@Override
	public String convertTime(String time) {

		// Validate time format
		if (!timeFormatValidator.isValidTime(time)) {
			throw new IllegalArgumentException(CommonConstants.INVALID_TIME_EXCEPTION);
		}

		// Split time in hours, minutes and seconds
		String[] times = time.split(CommonConstants.COLON_SEPERATOR, 3);
		int hours, minutes, seconds = 0;
		try {
			hours = Integer.parseInt(times[0]);
			minutes = Integer.parseInt(times[1]);
			seconds = Integer.parseInt(times[2]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(CommonConstants.INVALID_TIME_EXCEPTION);
		}

		return processTime(hours, minutes, seconds);
	}

	/**
	 * Process time.
	 *
	 * @param hours
	 *            the hours
	 * @param minutes
	 *            the minutes
	 * @param seconds
	 *            the seconds
	 * @return the string
	 */
	private String processTime(int hours, int minutes, int seconds) {

		String row1 = calculateRowString(1, 1 - (seconds % 2), CommonConstants.YELLOW_COLOUR);
		String row2 = calculateRowString(4, hours / 5, CommonConstants.RED_COLOUR);
		String row3 = calculateRowString(4, hours % 5, CommonConstants.RED_COLOUR);
		String row4 = calculateRowString(11, minutes / 5, CommonConstants.YELLOW_COLOUR)
				.replaceAll(CommonConstants.MINUTE_TRIPLE_YELLOW, CommonConstants.MINUTE_QUADRANT_LIGHT);
		String row5 = calculateRowString(4, minutes % 5, CommonConstants.YELLOW_COLOUR);

		return String.join(CommonConstants.NEW_LINE, Arrays.asList(row1, row2, row3, row4, row5));
	}

	/**
	 * Calculate row string.
	 *
	 * @param totalLights
	 *            the total lights
	 * @param onLights
	 *            the on lights
	 * @param lampColours
	 *            the lamp colours
	 * @return the string
	 */
	private String calculateRowString(int totalLights, int onLights, String lampColours) {

		int offLights = totalLights - onLights;
		StringBuilder rowString = new StringBuilder(totalLights);
		if (onLights > 0) {
			rowString.append(String.join(CommonConstants.EMPTY_STRING, Collections.nCopies(onLights, lampColours)));
		}
		if (offLights > 0) {
			rowString.append(
					String.join(CommonConstants.EMPTY_STRING, Collections.nCopies(offLights, CommonConstants.OFF)));
		}

		return rowString.toString();
	}

}
