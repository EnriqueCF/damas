package usantatecla.draughts.controllers;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import usantatecla.draughts.models.State;
import usantatecla.draughts.models.StateValue;

public class LogicTest {

	@InjectMocks
	private Logic logic;
	
	@Mock 
	private State state;
	
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGivenControllerWhenInitialStateThenStart() {
		when(this.state.getValueState()).thenReturn(StateValue.INITIAL);
		assertThat(this.logic.getController(), is(instanceOf(StartController.class)));
	}
	
	@Test
	public void testGivenControllerWhenFinishStateThenResume() {
		when(this.state.getValueState()).thenReturn(StateValue.FINAL);
		assertThat(this.logic.getController(), is(instanceOf(ResumeController.class)));
	}
	
	@Test
	public void testGivenControllerWhenExitStateThenNull() {
		when(this.state.getValueState()).thenReturn(StateValue.EXIT);
		assertThat(this.logic.getController(), nullValue());
	}
}
