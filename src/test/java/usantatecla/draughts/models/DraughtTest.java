package usantatecla.draughts.models;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class DraughtTest {

	private Draught draught;
	
	@Before
	public void setup() {
		this.draught = new Draught(Color.BLACK);
	}
	
	@Test
	public void testGivenColorWhenGetColorThenBlack() {
		Color color = this.draught.getColor();
		assertThat(color, is(Color.BLACK));
	}
	
	@Test
	public void testGivenStringCodeWhenGetCodeThenReturnBlack() {
		String code = this.draught.getCode();
		assertThat(code, is("N"));
	}
	
	@Test
	public void testGivenErrorWhenTooMuchEatingsThenReturnError() {
		Coordinate origin = new Coordinate(0,0);
		Coordinate target = new Coordinate(2,2);
		Error error = this.draught.isCorrectDiagonalMovement(2, 2, origin, target);
		assertThat(error, is(Error.TOO_MUCH_EATINGS));
	}
	
	@Test
	public void testGivenErrorWhenTooMuchEatingsThenReturnNull() {
		Coordinate origin = new Coordinate(0,0);
		Coordinate target = new Coordinate(2,2);
		Error error = this.draught.isCorrectDiagonalMovement(1, 2, origin, target);
		assertThat(error, nullValue());
	}
}
