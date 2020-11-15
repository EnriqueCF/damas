package usantatecla.draughts.models;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	private static final int ZERO = 0;
	private static final int FIRST = 1;
	private static final int SECOND = 2;
	private static final int LAST = 7;
	
	private Board board;

	@Before
	public void before() {
		this.board = new Board();
		Pawn pawn = new Pawn(Color.WHITE);
		Coordinate coordinate = new Coordinate(FIRST, FIRST);
		this.board.put(coordinate, pawn);
		Pawn blackPawn = new Pawn(Color.BLACK);
		Coordinate coordinateBlack = new Coordinate(LAST, LAST);
		this.board.put(coordinateBlack, blackPawn);

	}

	@Test
	public void testGivenPieceWhenGetPiece() {
		Coordinate coordinate = new Coordinate(ZERO, ZERO);
		Piece piece = this.board.getPiece(coordinate);
		assertThat(piece, nullValue());

		Piece otherPiece = this.board.getPiece(new Coordinate(FIRST, FIRST));
		assertThat(otherPiece.getColor(), is(Color.WHITE));

		Color color = this.board.getColor(new Coordinate(FIRST, FIRST));
		assertThat(color, is(Color.WHITE));
	}

	@Test
	public void testGivenBooleanWhenIsEmpty() {
		Coordinate coordinate = new Coordinate(ZERO, ZERO);

		boolean isEmptyPiece = this.board.isEmpty(coordinate);
		assertThat(isEmptyPiece, is(Boolean.TRUE));
	}

	@Test
	public void testGivenVoidWhenPutPiece() {
		Pawn pawn = new Pawn(Color.WHITE);
		Coordinate coordinate = new Coordinate(SECOND, SECOND);
		this.board.put(coordinate, pawn);

		assertThat(this.board.getPiece(coordinate), is(equalTo(pawn)));
	}

	@Test
	public void testGivenPieceWhenMove() {
		Coordinate origin = new Coordinate(FIRST, FIRST);
		Coordinate target = new Coordinate(SECOND, SECOND);
		Pawn pawn = new Pawn(Color.WHITE);

		this.board.move(origin, target);
		assertThat(this.board.getPiece(target), is(equalTo(pawn)));
	}

	@Test
	public void testGivenPiceWhenRemovePiece() {
		Pawn pawn = new Pawn(Color.WHITE);
		Coordinate coordinate = new Coordinate(FIRST, FIRST);
		this.board.put(coordinate, pawn);

		Piece piece = this.board.remove(coordinate);
		assertThat(piece.getColor(), is(Color.WHITE));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testExceptionWhenWorstCoordinateThenCatchException() {
		Pawn pawn = new Pawn(Color.WHITE);
		Coordinate coordiante = new Coordinate(-1, -1);
		this.board.put(coordiante, pawn);
	}

	@Test
	public void testGivenListWhenGetDiagonalThenResturnList() {
		Coordinate origin = new Coordinate(ZERO, ZERO);
		Coordinate target = new Coordinate(LAST, LAST);
		List<Piece> list = this.board.getBetweenDiagonalPieces(origin, target);
		Pawn pawn = new Pawn(Color.WHITE);

		assertThat(list.size(), is(FIRST));
		assertThat(list.get(ZERO), is(equalTo(pawn)));

		list = this.board.getBetweenDiagonalPieces(target, target);
		assertThat(list.isEmpty(), is(Boolean.TRUE));
	}

	@Test
	public void testGivenIntWhenGetAmountPiecesThenReturnDiagonal() {
		Coordinate origin = new Coordinate(ZERO, ZERO);
		Coordinate target = new Coordinate(LAST, LAST);
		int amount = this.board.getAmountBetweenDiagonalPieces(origin, target);

		assertThat(amount, is(1));
	}

	@Test
	public void testGivenStringWhenToStringThenCompare() {
		//@formatter:off
        String boardWithTwoPieces =
                " 01234567\n" +
                " 0        0\n" +
                " 1 b      1\n" +
                " 2        2\n" +
                " 3        3\n" +
                " 4        4\n" +
                " 5        5\n" +
                " 6        6\n" +
                " 7       n7\n" +
                " 01234567\n";
        //@formatter:on
        assertThat(this.board.toString(), is(equalTo(boardWithTwoPieces)));
	}
}
