package alanrusnak.challenge1.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import alanrusnak.challenge1.solver.Line;
import alanrusnak.challenge1.solver.Square;

public class SolverTests {

	@Test
	public void testCalculatePossibilitiesForOne() {
		assertEquals(0, (new Line(0,new int[]{1}, new Square[]{})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{1}, new Square[]{Square.UNDECIDED})).calculatePossibilities());
		assertEquals(2, (new Line(0,new int[]{1}, new Square[]{Square.UNDECIDED,Square.UNDECIDED})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{2}, new Square[]{})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{2}, new Square[]{Square.UNDECIDED})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{2}, new Square[]{Square.UNDECIDED,Square.UNDECIDED})).calculatePossibilities());
		assertEquals(2, (new Line(0,new int[]{2}, new Square[]{Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED})).calculatePossibilities());
		assertEquals(3, (new Line(0,new int[]{2}, new Square[]{Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED})).calculatePossibilities());
		
		}
	
	@Test
	public void testCalculatePossibilitiesForTwo() {
		assertEquals(0, (new Line(0,new int[]{1,2}, new Square[]{})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{1,2}, new Square[]{Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{1,2}, new Square[]{Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED})).calculatePossibilities());
		assertEquals(3, (new Line(0,new int[]{1,2}, new Square[]{Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED})).calculatePossibilities());
	
	}
	
	@Test
	public void testCalculatePossibilitiesWithBlack() {
		assertEquals(1, (new Line(0,new int[]{1}, new Square[]{Square.BLACK,Square.UNDECIDED,Square.UNDECIDED})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{1}, new Square[]{Square.UNDECIDED,Square.BLACK,Square.UNDECIDED})).calculatePossibilities());
		assertEquals(2, (new Line(0,new int[]{2}, new Square[]{Square.UNDECIDED,Square.BLACK,Square.UNDECIDED})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{1,1}, new Square[]{Square.BLACK,Square.UNDECIDED,Square.UNDECIDED})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{1,1}, new Square[]{Square.UNDECIDED,Square.BLACK,Square.UNDECIDED})).calculatePossibilities());
	
	}
	
	@Test
	public void testCalculatePossibilitiesWithWhite() {
		assertEquals(0, (new Line(0,new int[]{1}, new Square[]{Square.WHITE})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{1}, new Square[]{Square.WHITE,Square.WHITE})).calculatePossibilities());
		assertEquals(1, (new Line(0,new int[]{1}, new Square[]{Square.WHITE,Square.UNDECIDED,Square.WHITE})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{2}, new Square[]{Square.UNDECIDED,Square.WHITE,Square.UNDECIDED})).calculatePossibilities());
		assertEquals(2, (new Line(0,new int[]{2}, new Square[]{Square.UNDECIDED,Square.UNDECIDED,Square.WHITE,Square.UNDECIDED,Square.UNDECIDED})).calculatePossibilities());
	}
	
	@Test
	public void testCalculatePossibilitiesComplex() {
		assertEquals(1, (new Line(0,new int[]{1,10,1}, new Square[]{Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.BLACK,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED})).calculatePossibilities());
		assertEquals(0, (new Line(0,new int[]{1,10,1}, new Square[]{Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.BLACK,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.UNDECIDED,Square.WHITE})).calculatePossibilities());
		}

	
}
