package alanrusnak.challenge1.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import alanrusnak.challenge1.solver.Line;
import alanrusnak.challenge1.solver.Square;
import alanrusnak.challenge1.solver.SquareState;

public class SolverTests {

	@Test
	public void testCalculatePossibilitiesForOne() {
		assertEquals(0, (new Line(0,new int[]{1}, new Square[]{})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{1}, new Square[]{new Square(SquareState.UNDECIDED)})).calculatePossibilities());
		assertEquals(2, (new Line(0,new int[]{1}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{2}, new Square[]{})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{2}, new Square[]{new Square(SquareState.UNDECIDED)})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{2}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)})).calculatePossibilities());
		assertEquals(2, (new Line(0,new int[]{2}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)})).calculatePossibilities());
		assertEquals(3, (new Line(0,new int[]{2}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)})).calculatePossibilities());
		
		}
	
	@Test
	public void testCalculatePossibilitiesForTwo() {
		assertEquals(0, (new Line(0,new int[]{1,2}, new Square[]{})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{1,2}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{1,2}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)})).calculatePossibilities());
		assertEquals(3, (new Line(0,new int[]{1,2}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)})).calculatePossibilities());
	
	}
	
	@Test
	public void testCalculatePossibilitiesWithBlack() {
		assertEquals(1, (new Line(0,new int[]{1}, new Square[]{new Square(SquareState.BLACK),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{1}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.BLACK),new Square(SquareState.UNDECIDED)})).calculatePossibilities());
		assertEquals(2, (new Line(0,new int[]{2}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.BLACK),new Square(SquareState.UNDECIDED)})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{1,1}, new Square[]{new Square(SquareState.BLACK),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{1,1}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.BLACK),new Square(SquareState.UNDECIDED)})).calculatePossibilities());
	
	}
	
	@Test
	public void testCalculatePossibilitiesWithWhite() {
		assertEquals(0, (new Line(0,new int[]{1}, new Square[]{new Square(SquareState.WHITE)})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{1}, new Square[]{new Square(SquareState.WHITE),new Square(SquareState.WHITE)})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{1}, new Square[]{new Square(SquareState.WHITE),new Square(SquareState.UNDECIDED),new Square(SquareState.WHITE)})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{2}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.WHITE),new Square(SquareState.UNDECIDED)})).calculatePossibilities());
		assertEquals(2, (new Line(0,new int[]{2}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.WHITE),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)})).calculatePossibilities());
	}
	
	@Test
	public void testCalculatePossibilitiesComplex() {
		assertEquals(1, (new Line(0,new int[]{1,10,1}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.BLACK),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{1,10,1}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.BLACK),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.WHITE)})).calculatePossibilities());
		
		Line l1 = new Line(0,new int[]{7,2,1,1,7}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.BLACK),new Square(SquareState.BLACK),new Square(SquareState.UNDECIDED),new Square(SquareState.BLACK),new Square(SquareState.UNDECIDED),new Square(SquareState.BLACK),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.WHITE),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.BLACK),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)});
		assertTrue(6<l1.calculatePossibilities());
		}

	@Test
	public void testCompareLines() {
		Line line0 = new Line(0,new int[]{1}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.BLACK),new Square(SquareState.UNDECIDED)});
		Line line1 = new Line(0,new int[]{1}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)});
		Line line2 = new Line(0,new int[]{2}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)});
		Line line3 = new Line(0,new int[]{3}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)});
		Line line4 = new Line(1,new int[]{3}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)});
		
		assertEquals(-1,line0.compareTo(line1));
		assertEquals(1,line1.compareTo(line2));
		assertEquals(1,line2.compareTo(line3));
		assertEquals(0,line0.compareTo(line3));
		assertEquals(-1,line0.compareTo(line4));
		
		
		}
	
//	@Test
//	public void testGetAllSolutions() {
//		Line l1 = (new Line(0,new int[]{1}, new Square[]{new Square(SquareState.UNDECIDED),new Square(SquareState.UNDECIDED)}));
//		l1.calculatePossibilities();
//		Assert.assertArrayEquals(new int[][]{new int[]{1}, new int[]{0}},l1.getAllSolutions() );
//		
//		
//		}
	
	
}
