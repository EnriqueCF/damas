package usantatecla.draughts.views;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import usantatecla.draughts.controllers.StartController;

public class StartViewTest {

	@InjectMocks
	private StartView startView;
	@Mock
	private StartController startController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGivenVoidWhenInteract() {
		this.startView.interact(startController);
		verify(startController).start();
	}
}
