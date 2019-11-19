package exercises.water_and_land;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CoordinatesTest {

	@Test
	void test1() {
		Assert.assertTrue(new Coordinates(2, 4).equals(new Coordinates(2, 4)));
		Assert.assertFalse(new Coordinates(2, 4).equals(new Coordinates(1, 5)));
		
		Assert.assertTrue(new Coordinates(2, 4).isNeighbor(new Coordinates(1, 4)));
		Assert.assertFalse(new Coordinates(2, 4).equals(new Coordinates(1, 6)));
	}
}
