package usantatecla.draughts.models;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class StateTest {

	private State state;
	
	@Before
	public void before() {
		this.state = new State();
	}
	
	@Test
	public void testInitial() {
		assertThat(this.state.getValueState(), is(equalTo(StateValue.INITIAL)));
	}
	
	@Test
	public void testNextIterations() {
		for(int i=0; i<StateValue.EXIT.ordinal(); i++) {
			
		}
	}
}
