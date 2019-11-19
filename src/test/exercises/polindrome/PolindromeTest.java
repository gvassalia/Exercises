package exercises.polindrome;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PolindromeTest {

	@Test
	void test() {
		Assert.assertFalse(new Polindrome(null).isValid());
		Assert.assertFalse(new Polindrome("").isValid());
		Assert.assertFalse(new Polindrome("polindrom").isValid());
		
		Assert.assertTrue(new Polindrome("ABBA").isValid());
		Assert.assertTrue(new Polindrome("ABCBA").isValid());
		
		Assert.assertTrue(new Polindrome("ABba").isValid());
	}
}
