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

public class PlayControllerTest extends ControllerTest{

	@InjectMocks
	private PlayController controller;
	
	@Mock
	private CancelController cancelController;
	
	@Mock
	private MoveController moveController;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);	
	}
	
	@Test
	public void testGivenErrorWhenMoveControllerMove() {
		Coordinate origin = new Coordinate(1,1);
		Coordinate target = new Coordinate(2,2);
		when(moveController.move(origin, target)).thenReturn(Error.BAD_FORMAT);
		
		Error error = this.controller.move(origin, target);
		assertThat(error, is(Error.BAD_FORMAT));
	}
	
	@Test
	public void testGivenBooleanWhenIsBlocked() {
		when(game.isBlocked()).thenReturn(Boolean.TRUE);
		
		boolean result = this.controller.isBlocked();
		assertThat(result, is(Boolean.TRUE));
	}
	
}
