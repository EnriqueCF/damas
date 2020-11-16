package usantatecla.draughts.controllers;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ResumeControllerTest extends ControllerTest {

	@InjectMocks
	private ResumeController controller;

	@Mock
	private InteractorControllersVisitor interactorControllerVisitor;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGivenVoidWhenNext() {
		this.controller.next();
		verify(state).next();
	}

	@Test
	public void testGivenVoidWhenReset() {
		this.controller.reset();
		verify(state).reset();
		verify(game).reset();
	}

	@Test
	public void testGivenVoidWhenAccept() {
		this.controller.accept(interactorControllerVisitor);
		verify(interactorControllerVisitor).visit(controller);
	}

}
