package exercises.water_and_land;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import polindrome.Polindrome;

class PolindromeTest {

	@Test
	void test() {
		Assert.assertTrue(new Polindrome("ABBA").isValid());
		Assert.assertTrue(new Polindrome("ABCBA").isValid());
	}
}
