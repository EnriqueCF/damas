package usantatecla.draughts.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;

public class PlayControllerTest {

	@InjectMocks
	private PlayController controller;
	
	@Mock
	private CancelController cancelController;
	
	@Mock
	private MoveController moveController;
	
	@Mock
	private Game game;
	
	@Mock
	private State state;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		this.controller = new PlayController(game, state);

	}
	
	@Test
	public void testGivenErrorWhenMoveControllerMove() {
		Coordinate coordinate = new Coordinate(1,1);
		Coordinate coordinate2 = new Coordinate(2,2);
		when(moveController.move(coordinate, coordinate2)).thenReturn(Error.BAD_FORMAT);
		
		Error error = this.controller.move(coordinate, coordinate2);
		assertThat(error, is(Error.BAD_FORMAT));
	}
	
	@Test
	public void testGivenBooleanWhenIsBlocked() {
		when(game.isBlocked()).thenReturn(Boolean.TRUE);
		
		boolean result = this.controller.isBlocked();
		assertThat(result, is(Boolean.TRUE));
	}
	
}
