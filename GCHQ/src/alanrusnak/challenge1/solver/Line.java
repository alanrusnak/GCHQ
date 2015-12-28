package alanrusnak.challenge1.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Line implements Comparable<Line> {

	private final int id;
	private int[] blocks;
	private Square[] squares;
	private int possibilities;

	
	
	
	public void setSquares(Square[] squares) {
		this.squares = squares;
	}



	public Line(int id, int[] blocks, Square[] squares) {
		super();
		this.id = id;
		this.blocks = blocks;
		this.squares = squares;
	}

	

	public Line(int id, int[] blocks) {
		this.id = id;
		this.blocks = blocks;
	}



	public int calculatePossibilities() {
		return possibilities = calculatePossibilities(0, 0);
	}

	private int calculatePossibilities(int blocksUsed, int squaresUsed) {
		if (blocks.length - blocksUsed == 0)
			return calculateForZero(blocksUsed, squaresUsed);

		int ifBlockUsed = 0;
		int ifBlockNotUsed = 0;

//		if (squaresUsed < squares.length && squares[squaresUsed].getState() == SquareState.WHITE) {
//			if (squaresUsed < squares.length) {
//				ifBlockNotUsed = calculatePossibilities(blocksUsed,
//						squaresUsed + 1);
//			}
//		}
		//else if
		if (squaresUsed < squares.length && squares[squaresUsed].getState() == SquareState.BLACK) {
			if (blocksUsed<blocks.length && blockCanBeUsedHere(blocks[blocksUsed], squares, squaresUsed)) {
				ifBlockUsed = calculatePossibilities(blocksUsed + 1,
						squaresUsed + blocks[blocksUsed] + 1);
			} else {
				return 0;
			}
		} else {
			if (blocksUsed<blocks.length && blockCanBeUsedHere(blocks[blocksUsed], squares, squaresUsed)) {
				ifBlockUsed = calculatePossibilities(blocksUsed + 1,
						squaresUsed + blocks[blocksUsed] + 1);
			}
			if (squaresUsed < squares.length) {
				ifBlockNotUsed = calculatePossibilities(blocksUsed,
						squaresUsed + 1);
			}
		}

		return ifBlockUsed + ifBlockNotUsed;

	}

	private int calculateForZero(int blocksUsed, int squaresUsed) {
		//System.out.println("Enter calculate for zero!");
		if (squaresUsed < squares.length) {
			for (int i = squaresUsed; i < squares.length; i++) {
				//System.out.println("In calculate for zero loop, squaresUsed: " + squaresUsed + ", i: " + i + ", squares.length: " + squares.length);
				if (squares[i].getState() == SquareState.BLACK)
					return 0;
			}
			return 1;
		}
		return 1;
	}

	private boolean isNoSquaresLeft(SquareState[] squares, int squaresUsed) {
		return squares.length - squaresUsed == 0;
	}

	private boolean isNoBlocksLeft(int[] blocks, int blocksUsed) {
		return blocks.length - blocksUsed == 0;
	}

	private boolean isLastBlock(int[] blocks, int blocksUsed) {
		return blocks.length - blocksUsed == 1;
	}

	private int possibleSquaresLeft(Square[] squares, int squaresUsed) {
		return squares.length - squaresUsed;
	}

	private boolean blockCanBeUsedHere(int blockLength, Square[] squares, int squaresUsed) {
		if (possibleSquaresLeft(squares, squaresUsed) < blockLength)
			return false;
		if (squaresUsed + blockLength < squares.length
				&& squares[squaresUsed + blockLength].getState() == SquareState.BLACK)
			return false;
		for (int i = squaresUsed; i < squaresUsed + blockLength ; i++) {
			if (squares[i].getState() == SquareState.WHITE)
				return false;
		}
		return true;
	}

	public int getPossibilities() {
		return calculatePossibilities();
	}

	@Override
	public String toString(){
		return "Line " + id + ": possibilities " + getPossibilities() + ", blocks: " + blocksToString() +  " squares: " + squaresToString();
	}
	public String blocksToString(){
		String string = "";
		for(int b:blocks){
			string = string + b + ",";
		}
		return string;
	}
	public String squaresToString(){
		String string = "";
		for(Square s:squares){
			string = string + s + ",";
		}
		return string;
	}
	
	
	//line with fewest possibilities is the smallest
	@Override
	public int compareTo(Line line) {
		int possibilitiesDiff = this.getPossibilities()
				- line.getPossibilities();
		if (possibilitiesDiff == 0) {
			return (int) Math.signum(this.getId() - line.getId());
		}
		return (int) Math.signum(possibilitiesDiff);
	}

	public int[] getBlocks() {
		return blocks;
	}

	public void setBlocks(int[] blocks) {
		this.blocks = blocks;
	}

	public Square[] getSquares() {
		return squares;
	}

	public void setSqures(Square[] squares) {
		this.squares = squares;
	}

	public int getId() {
		return id;
	}

	public void setPossibilities(int possibilities) {
		this.possibilities = possibilities;
	}

	public boolean solveLine() {
		System.out.println("solveLine: Line id: " + id + ", Blocks.length= " + blocks.length);
		if(getPossibilities()!=1) return false;
		int[] blocksPlacement = new int[blocks.length];
		solveLine(0,0,blocksPlacement);
		setLineFromBlockIndex(blocksPlacement);
		return true;
		
	}
	
	private void setLineFromBlockIndex(int[] blocksIndex) {
		int squaresUsed = 0;
		int blocksUsed = 0;
		while(squaresUsed<squares.length){
			if(blocksUsed<blocks.length && blocksIndex[blocksUsed]==squaresUsed){
				for(int i = 0;i<blocks[blocksUsed];i++){
					squares[squaresUsed++].setState(SquareState.BLACK);
				}
				blocksUsed++;
			}else{
				squares[squaresUsed++].setState(SquareState.WHITE);
			}
		}
		
	}

	public boolean solveLine(int blocksUsed, int squaresUsed, int[] blockPlacement){
		if (blocks.length - blocksUsed == 0){
			if(1==calculateForZero(blocksUsed, squaresUsed)){
				return true;
			}
			else{
				return false;
			}
		}	

		
		if (squaresUsed < squares.length && squares[squaresUsed].getState() == SquareState.BLACK) {
			if (blockCanBeUsedHere(blocks[blocksUsed], squares, squaresUsed)) {
				blockPlacement[blocksUsed] = squaresUsed;
				if(solveLine(blocksUsed + 1,squaresUsed + blocks[blocksUsed] + 1,blockPlacement)){
					
					return true;				
			} else {
				return false;
			}
			}
		} else {
			if (blockCanBeUsedHere(blocks[blocksUsed], squares, squaresUsed)) {
				blockPlacement[blocksUsed] = squaresUsed;
				if(solveLine(blocksUsed + 1,squaresUsed + blocks[blocksUsed] + 1,blockPlacement)){
					
					return true;
			}
				}
			if (squaresUsed < squares.length) {
				if(solveLine(blocksUsed,squaresUsed + 1,blockPlacement)){
					
					return true;
					}
			}
		

	}
		return false;
	}
	
	private void printArray(int[] x){
		for(int i : x){
			System.out.print(i + ",");			
		}
		System.out.println();
	}
	private void printArray(boolean[] x){
		for(boolean i : x){
			System.out.print(i + ",");			
		}
		System.out.println();
	}
	
	private void setPartialSolution(int[] blocksIndex, boolean[] mask) {
		int blocksUsed = 0;
		
		for(int i = 0;i<blocksIndex.length;i++){
			if(!mask[i]){
				if(blocksIndex[i]!=0) {
					
					squares[blocksIndex[i]-1].setState(SquareState.WHITE);
				}
				
				for(int j = blocksIndex[i];j<blocks[blocksUsed]+blocksIndex[i];j++){
					
					squares[j].setState(SquareState.BLACK);
				}				
				if(blocksIndex[i]+blocks[blocksUsed]!=squares.length) {
					
					squares[blocksIndex[i]+blocks[blocksUsed]].setState(SquareState.WHITE);
				}
				blocksUsed++;
			}
			else{
				blocksUsed++;
			}
		}
		
		System.out.println(this);
		
	}
	
	public void partialSolveLine(){
		if(this.getPossibilities()==1){
			this.solveLine();
			return;
		}
		int[][] allSolutions = new int[possibilities][blocks.length];
		for(int i = 0;i<possibilities;i++){
			allSolutions[i] = new int[]{-1};
		}
		int[] blockPlacement = new int[blocks.length];
		getAllSolutions(0,0,blockPlacement,allSolutions);
		
		int[] intersection = getIntersection(allSolutions);
		if(intersection.length>0){
			boolean[] mask = getMask(allSolutions, intersection);
			setPartialSolution(allSolutions[0],mask);
		}
		
				
	}
	
	private boolean[] getMask(int[][] allSolutions, int[] intersection) {
		
		int[] solution = allSolutions[1];
		
		boolean[] mask = new boolean[solution.length];
		
		int interIndex = 0;
		
		for(int i = 0;i<solution.length;i++){
			if(interIndex<intersection.length&& solution[i]==intersection[interIndex]){
				interIndex++;
			}else{
				mask[i] = true;				
			}
		}
		
		return mask;
	}



	private int[] deepCopy(int[] x){
		if(x==null) return null;
		int[] y = new int[x.length];
		for(int i = 0;i<y.length;i++){
			y[i] = x[i];
		}
		return y;
	}
	
	private void addToTail(int[] x, int[][] y){
		for(int i = 0;i<y.length;i++){
			if(y[i][0]==-1){
				y[i] = x;
				return;
			}
		}
		
	}
	
	public boolean findMoreWhiteSquares(){
		int minBlockSize = getMinimumBlockSize();
		if(minBlockSize>2){
			return whiteIfBlockDoesNotFit(minBlockSize);			 
		}
		return false;
	}
	
	
	
	private boolean whiteIfBlockDoesNotFit(int minBlockSize) {
		if(id==7){
		
		int count = 0;
		for(int i = 0;i<squares.length-minBlockSize;i++){
			if(squares[i].getState()==SquareState.UNDECIDED){
				count++;
			}
			else if(squares[i].getState()==SquareState.WHITE){
				if(count<minBlockSize){
					for(int j = i;j>=i-count;j--){
						squares[j].setState(SquareState.WHITE);
					}
					count = 0;
				}
			}
			else{
				
			}
		}
		
		}
		return true;
		
	}



	private int getMinimumBlockSize() {
		int min = 10000;
		for(int i = 0;i<blocks.length;i++){
			min = Math.min(min, blocks[i]);
		}
		return min;
	}



	private int[] getIntersection(int[][] allSolutions){
		
		Set<Integer> intersection = new TreeSet<Integer>();
		boolean addToIntersection = true;
		for(int i = 0;i<allSolutions[0].length;i++){
			addToIntersection = true;
			int index = allSolutions[0][i];
			for(int j = 1;j<allSolutions.length;j++){
				if(index!=allSolutions[j][i]){
					addToIntersection = false;
				}
			}
			if(addToIntersection){
				intersection.add(index);
			}
			
		}
		
		
		intersection.remove(-1);
		
		return toArray(intersection);
		
	}
	
	private int indexOf(int[] arr, int x){
		for(int i = 0;i<arr.length;i++){
			if(arr[i]==x) return i;
		}
		return -1;
	}
	
	private List<Integer> toList(int[] x){
		List<Integer> intList = new ArrayList<Integer>();
	    for (int index = 0; index < x.length; index++)
	    {
	        intList.add(x[index]);
	    }
	    return intList;
	}
	
	private int[] toArray(Set<Integer> set){
		int[] arr = new int[set.size()];
		int index = 0;
		for(Integer x : set){
			arr[index++] = x.intValue();
		}
		return arr;
	}
	
	public void getAllSolutions(int blocksUsed, int squaresUsed, int[] blockPlacement, int[][] allSolutions){
		if (blocks.length - blocksUsed == 0){
			if(1==calculateForZero(blocksUsed, squaresUsed)){
				addToTail(blockPlacement,allSolutions);
				return;
			}
			
		}	

		
		if (squaresUsed < squares.length && squares[squaresUsed].getState() == SquareState.BLACK) {
			if (blocksUsed<blocks.length && blockCanBeUsedHere(blocks[blocksUsed], squares, squaresUsed)) {
				blockPlacement[blocksUsed] = squaresUsed;
				getAllSolutions(blocksUsed + 1,squaresUsed + blocks[blocksUsed] + 1,deepCopy(blockPlacement),allSolutions);		
			}
		} else {
			if (squaresUsed < squares.length) {
				getAllSolutions(blocksUsed,squaresUsed + 1,deepCopy(blockPlacement),allSolutions);					
			}
			if (blocksUsed<blocks.length && blockCanBeUsedHere(blocks[blocksUsed], squares, squaresUsed)) {
				blockPlacement[blocksUsed] = squaresUsed;
				getAllSolutions(blocksUsed + 1,squaresUsed + blocks[blocksUsed] + 1,deepCopy(blockPlacement),allSolutions);
				}
			

	}
		return;
	}
	
	public static void main(String[] args){
		
	}
}
