package usantatecla.draughts.controllers;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CancelControllerTest extends ControllerTest{

	@InjectMocks
	private CancelController cancelController;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGivenVoidWhenCancelMethod() {
		this.cancelController.cancel();
		verify(game).cancel();
		verify(state).next();
	}
}
