package usantatecla.draughts.models;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PawnTest {

	private static final int ZERO = 0;
	private static final int FIRST = 1;
	private static final int SECOND = 2;

	private Pawn pawn;

	@Before
	public void setup() {
		this.pawn = new Pawn(Color.BLACK);
	}

	@Test
	public void testGivenTrueWhenGetColor() {
		Color color = this.pawn.getColor();
		assertThat(color, is(Color.BLACK));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void test() {
		Coordinate origin = new Coordinate(FIRST, FIRST);
		Coordinate target = new Coordinate(SECOND, SECOND);
		Error error = this.pawn.isCorrectDiagonalMovement(FIRST, SECOND, origin, target);
		assertThat(error, nullValue());
	}

	@Test
	public void testGivenErrorWhenIsCorrectDiagonalMovement() {
		Coordinate origin = new Coordinate(FIRST, FIRST);
		Coordinate target = new Coordinate(SECOND, SECOND);
		Error error = this.pawn.isCorrectDiagonalMovement(FIRST, ZERO, origin, target);
		assertThat(error, nullValue());
	}

	@Test
	public void testGivenErrorWhenIsCorrectDiagonalMovementThenErrorAdvanced() {
		Coordinate origin = new Coordinate(FIRST, FIRST);
		Coordinate target = new Coordinate(5, 5);
		Error error = this.pawn.isCorrectDiagonalMovement(FIRST, ZERO, origin, target);
		assertThat(error, is(Error.TOO_MUCH_ADVANCED));
	}

	@Test
	public void testGivenErrorWhenIsCorrectDiagonalMovementThenErrorEating() {
		Coordinate origin = new Coordinate(FIRST, FIRST);
		Coordinate target = new Coordinate(5, 5);
		Coordinate intermediate = new Coordinate(3, 3);
		Error error = this.pawn.isCorrectDiagonalMovement(SECOND, FIRST, origin, intermediate, target);
		assertThat(error, is(Error.WITHOUT_EATING));
	}

	@Test
	public void testGivenErrorWhenIsCorrectDiagonalMovementThenErrorNotAdvanced() {
		Coordinate origin = new Coordinate(FIRST, FIRST);
		Coordinate target = new Coordinate(FIRST, FIRST);
		Error error = this.pawn.isCorrectDiagonalMovement(FIRST, ZERO, origin, target);
		assertThat(error, is(Error.NOT_ADVANCED));
	}

}
