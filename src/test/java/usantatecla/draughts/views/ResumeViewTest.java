package usantatecla.draughts.views;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.utils.YesNoDialog;

public class ResumeViewTest {

	@InjectMocks
	private ResumeView resumeView;
	@Mock
	private YesNoDialog yesNoDialog;
	@Mock
	private ResumeController resumeController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGivenVoidWhenResetAndInteract() {
		when(yesNoDialog.read(Mockito.anyString())).thenReturn(Boolean.TRUE);
		this.resumeView.interact(resumeController);
		verify(this.resumeController).reset();
	}

	@Test
	public void testGivenVoidWhenNextAndInteract() {
		when(yesNoDialog.read(Mockito.anyString())).thenReturn(Boolean.FALSE);
		this.resumeView.interact(resumeController);
		verify(this.resumeController).next();
	}
}
