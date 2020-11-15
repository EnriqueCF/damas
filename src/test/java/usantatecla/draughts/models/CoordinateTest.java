package usantatecla.draughts.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {

	private Coordinate coordinate;

	@Before
	public void setup() {
		this.coordinate = new Coordinate(2, 2);
	}

	@Test
	public void testGivenBooleanWhenIsOnDiagonal() {
		boolean isOnDiagonal = this.coordinate.isOnDiagonal(coordinate);
		assertThat(isOnDiagonal, is(Boolean.FALSE));
	}

	@Test
	public void testGetBetweenDiagonalCoordinate() {
		Coordinate coordinateIntermedie = new Coordinate(3, 3);
		Coordinate coordinate = this.coordinate.getBetweenDiagonalCoordinate(new Coordinate(4, 4));
		assertThat(coordinate, is(coordinateIntermedie));
	}

	@Test
	public void testgetBetweenDiagonalCoordinates() {
		List<Coordinate> coordinates = this.coordinate.getBetweenDiagonalCoordinates(new Coordinate(4, 4));
		assertThat(coordinates.size(), is(1));

	}

	@Test
	public void testGetDiagonalCoordinates() {
		List<Coordinate> coordinates = this.coordinate.getDiagonalCoordinates(2);
		assertThat(coordinates.size(), is(4));
	}

	@Test
	public void testGivenTrueWhenIsBlack() {
		boolean isBlack = this.coordinate.isBlack();
		assertThat(isBlack, is(Boolean.FALSE));

		this.coordinate = new Coordinate(5, 6);
		isBlack = this.coordinate.isBlack();
		assertThat(isBlack, is(Boolean.TRUE));

	}

	@Test
	public void testGivenTrueWhenIsLast() {
		boolean isLast = this.coordinate.isLast();
		assertThat(isLast, is(Boolean.FALSE));

	}

}
