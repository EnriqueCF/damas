package usantatecla.draughts.views;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import usantatecla.draughts.controllers.InteractorController;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.controllers.StartController;

public class ViewTest {

	@InjectMocks
	private View view;
	@Mock
	private StartView startView;
	@Mock
	private PlayView playView;
	@Mock
	private ResumeView resumeView;
	@Mock
	private InteractorController interactorController;
	@Mock
	private StartController startController;
	@Mock
	private ResumeController resumeController;
	@Mock
	private PlayController playController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGivenVoidWhenInteract() {
		this.view.interact(interactorController);
		verify(interactorController).accept(view);
	}

	@Test
	public void testStartViewWhenStartController() {
		this.view.visit(resumeController);
		verify(resumeView).interact(resumeController);
	}

	@Test
	public void testResumeViewWhenResumeController() {
		this.view.visit(startController);
		verify(startView).interact(startController);
	}

	@Test
	public void testPlayViewWhenPlayController() {
		this.view.visit(playController);
		verify(playView).interact(playController);
	}

}
