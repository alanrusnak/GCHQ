package alanrusnak.challenge1.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import alanrusnak.challenge1.solver.Line;
import alanrusnak.challenge1.solver.SquareState;

public class SolverTests {

	@Test
	public void testCalculatePossibilitiesForOne() {
		assertEquals(0, (new Line(0,new int[]{1}, new SquareState[]{})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{1}, new SquareState[]{SquareState.UNDECIDED})).calculatePossibilities());
		assertEquals(2, (new Line(0,new int[]{1}, new SquareState[]{SquareState.UNDECIDED,SquareState.UNDECIDED})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{2}, new SquareState[]{})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{2}, new SquareState[]{SquareState.UNDECIDED})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{2}, new SquareState[]{SquareState.UNDECIDED,SquareState.UNDECIDED})).calculatePossibilities());
		assertEquals(2, (new Line(0,new int[]{2}, new SquareState[]{SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED})).calculatePossibilities());
		assertEquals(3, (new Line(0,new int[]{2}, new SquareState[]{SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED})).calculatePossibilities());
		
		}
	
	@Test
	public void testCalculatePossibilitiesForTwo() {
		assertEquals(0, (new Line(0,new int[]{1,2}, new SquareState[]{})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{1,2}, new SquareState[]{SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{1,2}, new SquareState[]{SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED})).calculatePossibilities());
		assertEquals(3, (new Line(0,new int[]{1,2}, new SquareState[]{SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED})).calculatePossibilities());
	
	}
	
	@Test
	public void testCalculatePossibilitiesWithBlack() {
		assertEquals(1, (new Line(0,new int[]{1}, new SquareState[]{SquareState.BLACK,SquareState.UNDECIDED,SquareState.UNDECIDED})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{1}, new SquareState[]{SquareState.UNDECIDED,SquareState.BLACK,SquareState.UNDECIDED})).calculatePossibilities());
		assertEquals(2, (new Line(0,new int[]{2}, new SquareState[]{SquareState.UNDECIDED,SquareState.BLACK,SquareState.UNDECIDED})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{1,1}, new SquareState[]{SquareState.BLACK,SquareState.UNDECIDED,SquareState.UNDECIDED})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{1,1}, new SquareState[]{SquareState.UNDECIDED,SquareState.BLACK,SquareState.UNDECIDED})).calculatePossibilities());
	
	}
	
	@Test
	public void testCalculatePossibilitiesWithWhite() {
		assertEquals(0, (new Line(0,new int[]{1}, new SquareState[]{SquareState.WHITE})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{1}, new SquareState[]{SquareState.WHITE,SquareState.WHITE})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{1}, new SquareState[]{SquareState.WHITE,SquareState.UNDECIDED,SquareState.WHITE})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{2}, new SquareState[]{SquareState.UNDECIDED,SquareState.WHITE,SquareState.UNDECIDED})).calculatePossibilities());
		assertEquals(2, (new Line(0,new int[]{2}, new SquareState[]{SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.WHITE,SquareState.UNDECIDED,SquareState.UNDECIDED})).calculatePossibilities());
	}
	
	@Test
	public void testCalculatePossibilitiesComplex() {
		assertEquals(1, (new Line(0,new int[]{1,10,1}, new SquareState[]{SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.BLACK,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{1,10,1}, new SquareState[]{SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.BLACK,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.WHITE})).calculatePossibilities());
		}

	@Test
	public void testCompareLines() {
		Line line0 = new Line(0,new int[]{1}, new SquareState[]{SquareState.UNDECIDED,SquareState.BLACK,SquareState.UNDECIDED});
		Line line1 = new Line(0,new int[]{1}, new SquareState[]{SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED});
		Line line2 = new Line(0,new int[]{2}, new SquareState[]{SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED});
		Line line3 = new Line(0,new int[]{3}, new SquareState[]{SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED});
		Line line4 = new Line(1,new int[]{3}, new SquareState[]{SquareState.UNDECIDED,SquareState.UNDECIDED,SquareState.UNDECIDED});
		
		assertEquals(-1,line0.compareTo(line1));
		assertEquals(1,line1.compareTo(line2));
		assertEquals(1,line2.compareTo(line3));
		assertEquals(0,line0.compareTo(line3));
		assertEquals(-1,line0.compareTo(line4));
		
		
		}
	
}
