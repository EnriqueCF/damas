package usantatecla.draughts.controllers;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StartControllerTest extends ControllerTest {

	@InjectMocks
	private StartController controller;

	@Mock
	private InteractorControllersVisitor controllersVisitor;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNextState() {
		this.controller.start();
		verify(this.controller.state).next();
	}

	@Test
	public void testAccept() {
		this.controller.accept(controllersVisitor);
		verify(controllersVisitor).visit(controller);
	}

}
