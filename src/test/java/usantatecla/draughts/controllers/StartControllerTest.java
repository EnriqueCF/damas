package usantatecla.draughts.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;

public class StartControllerTest {

	private static final int UPPER_LIMIT = 7;
	private static final int DIMENSION = UPPER_LIMIT + 1;

	private StartController controller;

	@Spy
	private Game game;
	
	@Mock
	private State state;

	@Before
	public void before() {
		
		MockitoAnnotations.initMocks(this);
		this.controller = new StartController(game, state);
	}

	@Test
	public void testNextState() {
		this.controller.start();
		verify(this.controller.state).next();
	}

	@Test
	public void testGetDimension() {
		when(this.game.getDimension()).thenReturn(DIMENSION);

		assertThat(this.controller.getDimension(), is(Coordinate.getDimension()));
	}
//	
//	@Test
//	public void testGetPiece() {
//		this.controller.getPiece(coordinate);
//	}
//	
//	@Test
//	public void testGetColor(){
//		this.controller.getColor(coordinate);
//		
//	}
}
