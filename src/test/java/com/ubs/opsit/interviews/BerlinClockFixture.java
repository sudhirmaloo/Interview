package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing
 * stories. You should not need to edit this class to complete the exercise,
 * this is your definition of done.
 */
public class BerlinClockFixture {

	private TimeConverter berlinClock;
	private String theTime;

	@BeforeStory
	public void setup() {
		berlinClock = new BerlinClockTimeConverter();
	}

	@AfterStory
	public void cleanup() {
		berlinClock = null;
	}

	@Test
	public void berlinClockAcceptanceTests() throws Exception {
		aBehaviouralTestRunner().usingStepsFrom(this).withStory("berlin-clock.story").run();
	}

	@When("the time is $time")
	public void whenTheTimeIs(String time) {
		theTime = time;
	}

	@Then("the clock should look like $")
	public void thenTheClockShouldLookLike(String theExpectedBerlinClockOutput) {
		assertThat(berlinClock.convertTime(theTime)).isEqualTo(theExpectedBerlinClockOutput);
	}
}
