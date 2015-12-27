package alanrusnak.challenge1.solver;

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
			if (blockCanBeUsedHere(blocks[blocksUsed], squares, squaresUsed)) {
				ifBlockUsed = calculatePossibilities(blocksUsed + 1,
						squaresUsed + blocks[blocksUsed] + 1);
			} else {
				return 0;
			}
		} else {
			if (blockCanBeUsedHere(blocks[blocksUsed], squares, squaresUsed)) {
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
			if(blocksIndex[blocksUsed]==squaresUsed){
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
		System.out.println("solveLine: Line id: " + id + ", Blocks.length= " + blocks.length + ", blocksUsed: " + blocksUsed + ", squaresused: " + squaresUsed + ", squares.length: " + squares.length);
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
					System.out.println("Hello");
					return true;
					}
			}
		

	}
		return false;
	}
}
