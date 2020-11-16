package usantatecla.draughts.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;

public class ControllerTest {

	private static final int DIMENSION = 7;

	@InjectMocks
	private Controller controller;

	@Mock
	protected Game game;
	@Mock
	protected State state;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGivenColorWhengetColor() {
		when(game.getColor(Mockito.any(Coordinate.class))).thenReturn(Color.BLACK);

		Color color = this.controller.getColor(new Coordinate(1, 2));
		assertThat(color, is(Color.BLACK));
	}

	@Test
	public void test() {
		when(game.getDimension()).thenReturn(DIMENSION);

		int dimension = this.controller.getDimension();
		assertThat(dimension, is(DIMENSION));
	}
}
