package com.ubs.opsit.interviews.validator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TimeFormatValidator24HoursTest {

	private TimeFormatValidator24Hours timeValidator;

	@Before
	public void setup() {
		timeValidator = new TimeFormatValidator24Hours();
	}

	@After
	public void cleanup() {
		timeValidator = null;
	}

	@Test
	public void testNull() {
		Assert.assertFalse(timeValidator.isValidTime(null));
	}

	@Test
	public void testBlank() {
		Assert.assertFalse(timeValidator.isValidTime(" "));
	}

	@Test
	public void testStringInvalidTime() {
		Assert.assertFalse(timeValidator.isValidTime("Invalid Time"));
	}

	@Test
	public void testStringMinTimeInvalidString() {
		Assert.assertFalse(timeValidator.isValidTime("OO:OO:OO"));
	}

	@Test
	public void testMinTime() {
		Assert.assertTrue(timeValidator.isValidTime("00:00:00"));
	}

	@Test
	public void testMaxTime() {
		Assert.assertTrue(timeValidator.isValidTime("24:00:00"));
	}

	@Test
	public void testMaxValidTime() {
		Assert.assertTrue(timeValidator.isValidTime("12:00:00"));
	}

	@Test
	public void testMidDayTime() {
		Assert.assertTrue(timeValidator.isValidTime("23:59:59"));
	}

	@Test
	public void testNegativeCaseExceedingMax() {
		Assert.assertFalse(timeValidator.isValidTime("24:00:01"));
	}

	@Test
	public void testNegativeCaseExceedingMax36() {
		Assert.assertFalse(timeValidator.isValidTime("36:00:01"));
	}
}
