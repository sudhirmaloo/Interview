package com.ubs.opsit.interviews;

import java.util.Arrays;
import java.util.Collections;

import com.ubs.opsit.interviews.constants.CommonConstants;
import com.ubs.opsit.interviews.validator.TimeFormatValidator;
import com.ubs.opsit.interviews.validator.TimeFormatValidator24Hours;

public class BerlinClockTimeConverter implements TimeConverter {

	private TimeFormatValidator timeFormatValidator;

	public BerlinClockTimeConverter() {
		timeFormatValidator = new TimeFormatValidator24Hours();
	}

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

	private String processTime(int hours, int minutes, int seconds) {

		String row1 = calculateRowString(1, 1 - (seconds % 2), CommonConstants.YELLOW_COLOUR);
		String row2 = calculateRowString(4, hours / 5, CommonConstants.RED_COLOUR);
		String row3 = calculateRowString(4, hours % 5, CommonConstants.RED_COLOUR);
		String row4 = calculateRowString(11, minutes / 5, CommonConstants.YELLOW_COLOUR)
				.replaceAll(CommonConstants.MINUTE_TRIPLE_YELLOW, CommonConstants.MINUTE_QUADRANT_LIGHT);
		String row5 = calculateRowString(4, minutes % 5, CommonConstants.YELLOW_COLOUR);

		return String.join(CommonConstants.NEW_LINE, Arrays.asList(row1, row2, row3, row4, row5));
	}

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
