package com.ubs.opsit.interviews.constants;

/**
 * The Class CommonConstants.
 */
public class CommonConstants {

	/** The Constant EMPTY_STRING. */
	public static final String EMPTY_STRING = "";
	
	/** The Constant NEW_LINE. */
	public static final String NEW_LINE = System.getProperty("line.separator");

	/** The Constant COLON_SEPERATOR. */
	public static final String COLON_SEPERATOR = ":";

	/** The Constant YELLOW_COLOUR. */
	public static final String YELLOW_COLOUR = "Y";
	
	/** The Constant RED_COLOUR. */
	public static final String RED_COLOUR = "R";
	
	/** The Constant OFF. */
	public static final String OFF = "O";
	
	/** The Constant MINUTE_QUADRANT_LIGHT. */
	public static final String MINUTE_QUADRANT_LIGHT = "YYR";
	
	/** The Constant MINUTE_TRIPLE_YELLOW. */
	public static final String MINUTE_TRIPLE_YELLOW = "YYY";

	/** The Constant INVALID_TIME_EXCEPTION. */
	public static final String INVALID_TIME_EXCEPTION = "Invalid time as per 24 hours format." + NEW_LINE
			+ "Min Valid time is 00:00:00 and Max Valid Time is 23:59:59." + NEW_LINE
			+ "Please provide the time in HH:mm:ss format in integers only.";

}