package usantatecla.draughts.models;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PawnTest {

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
		Coordinate origin = new Coordinate(1, 1);
		Coordinate target = new Coordinate(2, 2);
		Error error = this.pawn.isCorrectDiagonalMovement(1, 2, origin, target);
		assertThat(error, nullValue());
	}

	@Test
	public void testGivenErrorWhenIsCorrectDiagonalMovement() {
		Coordinate origin = new Coordinate(1, 1);
		Coordinate target = new Coordinate(2, 2);
		Error error = this.pawn.isCorrectDiagonalMovement(1, 0, origin, target);
		assertThat(error, nullValue());
	}
	
	@Test
	public void testGivenErrorWhenIsCorrectDiagonalMovementThenErrorAdvanced() {
		Coordinate origin = new Coordinate(1, 1);
		Coordinate target = new Coordinate(5, 5);
		Error error = this.pawn.isCorrectDiagonalMovement(1, 0, origin, target);
		assertThat(error, is(Error.TOO_MUCH_ADVANCED));
	}
	
	@Test
	public void testGivenErrorWhenIsCorrectDiagonalMovementThenErrorEating() {
		Coordinate origin = new Coordinate(1, 1);
		Coordinate target = new Coordinate(5, 5);
		Coordinate intermediate = new Coordinate(3,3);
		Error error = this.pawn.isCorrectDiagonalMovement(2, 1, origin, intermediate, target);
		assertThat(error, is(Error.WITHOUT_EATING));
	}
	

	@Test
	public void testGivenErrorWhenIsCorrectDiagonalMovementThenErrorNotAdvanced() {
		Coordinate origin = new Coordinate(1, 1);
		Coordinate target = new Coordinate(1, 1);
		Error error = this.pawn.isCorrectDiagonalMovement(1, 0, origin, target);
		assertThat(error, is(Error.NOT_ADVANCED));
	}

}
