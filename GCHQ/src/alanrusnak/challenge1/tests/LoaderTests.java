package alanrusnak.challenge1.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import alanrusnak.challenge1.loader.Loader;
import alanrusnak.challenge1.solver.Board;
import alanrusnak.challenge1.solver.SquareState;

public class LoaderTests {

	@Test
	public void test() {
		Loader loader = new Loader();
		Board board = loader.loadBoard("board.txt");
		assertEquals(25,board.getWidth());
		assertEquals(25,board.getHeight());
		assertEquals(7,board.getHorizontalLines()[0].getBlocks()[4]);
		assertEquals(7,board.getVerticalLines()[0].getBlocks()[4]);
		assertEquals(SquareState.BLACK,board.getHorizontalLines()[3].getSquares()[3].getState());
		assertEquals(SquareState.UNDECIDED,board.getHorizontalLines()[3].getSquares()[2].getState());
		
	}

}
