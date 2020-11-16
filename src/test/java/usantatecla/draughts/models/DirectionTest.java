package usantatecla.draughts.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DirectionTest {

	@Test
	public void testNEIsOnDirection() {
		assertThat(Direction.NE.isOnDirection(new Coordinate(2, 2)), is(Boolean.TRUE));
		assertThat(Direction.NE.isOnDirection(new Coordinate(-5, -5)), is(Boolean.FALSE));
		assertThat(Direction.NE.isOnDirection(new Coordinate(1, 3)), is(Boolean.FALSE));
		assertThat(Direction.NE.isOnDirection(new Coordinate(3, 1)), is(Boolean.FALSE));

	}

	@Test
	public void testSEIsOnDirection() {
		assertThat(Direction.SE.isOnDirection(new Coordinate(-2, 2)), is(Boolean.TRUE));
		assertThat(Direction.SE.isOnDirection(new Coordinate(1, 2)), is(Boolean.FALSE));
		assertThat(Direction.SE.isOnDirection(new Coordinate(2, 1)), is(Boolean.FALSE));
		assertThat(Direction.SE.isOnDirection(new Coordinate(2, 2)), is(Boolean.FALSE));
	}

	@Test
	public void testSWIsOnDirection() {
		assertThat(Direction.SW.isOnDirection(new Coordinate(1, 1)), is(Boolean.FALSE));
		assertThat(Direction.SW.isOnDirection(new Coordinate(-2, -2)), is(Boolean.TRUE));
		assertThat(Direction.SW.isOnDirection(new Coordinate(4, 1)), is(Boolean.FALSE));
		assertThat(Direction.SW.isOnDirection(new Coordinate(1, 5)), is(Boolean.FALSE));
	}

	@Test
	public void testNWIsOnDirection() {
		assertThat(Direction.NW.isOnDirection(new Coordinate(1, 1)), is(Boolean.FALSE));
		assertThat(Direction.NW.isOnDirection(new Coordinate(-3, 1)), is(Boolean.FALSE));
		assertThat(Direction.NW.isOnDirection(new Coordinate(1, -3)), is(Boolean.FALSE));
		assertThat(Direction.NW.isOnDirection(new Coordinate(-2, -2)), is(Boolean.FALSE));
	}
}
