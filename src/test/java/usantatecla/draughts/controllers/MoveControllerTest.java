package usantatecla.draughts.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Error;

public class MoveControllerTest extends ControllerTest{

	@InjectMocks
	private MoveController moveController;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGivenMovesWhenNullListThenException() {
		Coordinate coordinate1 = new Coordinate(1,1);
		Coordinate coordinate2 = new Coordinate(2,2);
		when(this.game.isBlocked()).thenReturn(Boolean.TRUE);

		Error error = this.moveController.move(coordinate1, coordinate2);
		assertThat(error, nullValue());
		verify(this.moveController.state).next();
	}
	
	@Test
	public void testGivenErrorWhenMove() {
		Coordinate coordinate1 = new Coordinate(1,1);
		Coordinate coordinate2 = new Coordinate(2,2);
		when(this.game.move(coordinate1, coordinate2)).thenReturn(Error.BAD_FORMAT);

		Error error = this.moveController.move(coordinate1, coordinate2);
		assertThat(error, is(Error.BAD_FORMAT));
	}
	
	@Test
	public void testGivenNullWhenMove() {
		Coordinate coordinate1 = new Coordinate(1,1);
		Coordinate coordinate2 = new Coordinate(2,2);
		when(this.game.move(coordinate1, coordinate2)).thenReturn(null);

		Error error = this.moveController.move(coordinate1, coordinate2);
		assertThat(error, nullValue());
	}
}
