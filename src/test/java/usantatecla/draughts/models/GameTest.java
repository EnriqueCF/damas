package usantatecla.draughts.models;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	
	@Before
	public void setup() {
		this.game = new Game();
	}
	
	@Test
	public void testGivenFalseWhenIsNotBlocked() {
		boolean isBlocked = this.game.isBlocked();
		assertThat(isBlocked, is(Boolean.FALSE));
	}
	
	@Test
	public void testGivenColorWhenGetColor() {
		Color color = this.game.getColor(new Coordinate(1,1));
		assertThat(color, nullValue());
	}
}
