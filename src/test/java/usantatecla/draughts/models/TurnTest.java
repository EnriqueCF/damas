package usantatecla.draughts.models;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TurnTest {

	private Turn turn;
	
	@Before
	public void before() {
		this.turn = new Turn();
	}
	
	@Test
	public void testTurnWhiteColor() {
		assertThat(this.turn.getColor(), is(equalTo(Color.WHITE)));
	}
	
	@Test
	public void testChangeColor() {
		this.turn.change();
		assertThat(this.turn.getColor(), is(equalTo(Color.BLACK)));
	}
}
