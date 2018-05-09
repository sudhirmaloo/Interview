package com.ubs.opsit.interviews;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BerlinClockTest {

	private BerlinClock timeConverter;

	@Before
	public void setup() {
		timeConverter = new BerlinClock();
	}

	@After
	public void cleanup() {
		timeConverter = null;
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConvertTimeForNull() {
		timeConverter.convertTime(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConvertTimeForBlank() {
		timeConverter.convertTime(" ");
	}

	@Test
	public void testConvertTimeForInputTimeMidnight1() {
		String expectedString = "Y\n" + "OOOO\n" + "OOOO\n" + "OOOOOOOOOOO\n" + "OOOO";
		Assert.assertEquals(expectedString, timeConverter.convertTime("00:00:00"));
	}

	@Test
	public void testConvertTimeForInputTimeMidnight_1() {
		String expectedString = "O\n" + "OOOO\n" + "OOOO\n" + "OOOOOOOOOOO\n" + "OOOO";
		Assert.assertEquals(expectedString, timeConverter.convertTime("00:00:01"));
	}

	@Test
	public void testConvertTimeForInputTime3AM() {
		String expectedString = "Y\n" + "OOOO\n" + "RRRO\n" + "OOOOOOOOOOO\n" + "OOOO";
		String actualString = timeConverter.convertTime("3:00:00");
		Assert.assertEquals(expectedString, actualString);
	}

	@Test
	public void testConvertTimeForInputTime10AM() {
		String expectedString = "Y\n" + "RROO\n" + "OOOO\n" + "OOOOOOOOOOO\n" + "OOOO";
		String actualString = timeConverter.convertTime("10:00:00");
		Assert.assertEquals(expectedString, actualString);
	}

	@Test
	public void testConvertTimeForInputTime01PM() {
		String expectedString = "Y\n" + "RROO\n" + "RRRO\n" + "OOOOOOOOOOO\n" + "OOOO";
		String actualString = timeConverter.convertTime("13:00:00");
		Assert.assertEquals(expectedString, actualString);
	}

	@Test
	public void testConvertTimeForInputTime120401PM() {
		String expectedString = "O\n" + "RROO\n" + "RROO\n" + "OOOOOOOOOOO\n" + "YYYY";
		String actualString = timeConverter.convertTime("12:04:01");
		Assert.assertEquals(expectedString, actualString);
	}

	@Test
	public void testConvertTimeForInputTime121301PM() {
		String expectedString = "O\n" + "RROO\n" + "RROO\n" + "YYOOOOOOOOO\n" + "YYYO";
		String actualString = timeConverter.convertTime("12:13:01");
		Assert.assertEquals(expectedString, actualString);
	}

	@Test
	public void testConvertTimeForInputTime123210PM() {
		String expectedString = "Y\n" + "RROO\n" + "RROO\n" + "YYRYYROOOOO\n" + "YYOO";
		String actualString = timeConverter.convertTime("12:32:10");
		Assert.assertEquals(expectedString, actualString);
	}

	@Test
	public void testConvertTimeForInputTime235957() {
		String expectedString = "O\n" + "RRRR\n" + "RRRO\n" + "YYRYYRYYRYY\n" + "YYYY";
		String actualString = timeConverter.convertTime("23:59:57");
		Assert.assertEquals(expectedString, actualString);
	}

	@Test
	public void testConvertTimeForInputTimeMidnight2() {
		String expectedString = "Y\n" + "RRRR\n" + "RRRR\n" + "OOOOOOOOOOO\n" + "OOOO";
		String actualString = timeConverter.convertTime("24:00:00");
		Assert.assertEquals(expectedString, actualString);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConvertTimeForString() {
		timeConverter.convertTime("SudhirTest");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConvertTimeForStringColonSeperator() {
		timeConverter.convertTime("22:0O:12");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConvertTimeFor240001() {
		timeConverter.convertTime("24:00:01");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConvertTimeForNegativeInteger() {
		timeConverter.convertTime("-1:35:56");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConvertTimeFor245957() {
		timeConverter.convertTime("24:59:57");
	}

}
