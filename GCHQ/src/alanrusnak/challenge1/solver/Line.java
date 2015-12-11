package alanrusnak.challenge1.solver;

public class Line implements Comparable<Line>{

	private final int id;
	private int[] blocks;
	private Square[] squares;
	private int possibilities;
	
	public Line(int id, int[] blocks, Square[] squares) {
		super();
		this.id = id;
		this.blocks = blocks;
		this.squares = squares;
	}

	public int calculatePossibilities(){
		return calculatePossibilities(0,0);
	}
	
	private int calculatePossibilities(int blocksUsed, int squaresUsed){
		if(blocks.length-blocksUsed==0) return calculateForZero(blocksUsed,squaresUsed);
		if(blocks.length-blocksUsed==1) return calculateForOne(blocksUsed,squaresUsed);
		
		int ifBlockUsed = 0;
		int ifBlockNotUsed = 0;
		
		if(blockCanBeUsedHere(blocks[blocksUsed], squares, squaresUsed)){
			ifBlockUsed = calculatePossibilities(blocksUsed+1, squaresUsed+blocks[blocksUsed]+1);			
		}
		ifBlockNotUsed = calculatePossibilities(blocksUsed,squaresUsed+1);
		
		return ifBlockUsed + ifBlockNotUsed;
		
	}
	
	

	private int calculateForOne(int blocksUsed, int squaresUsed) {
		if(blockCanBeUsedHere(blocks[blocksUsed], squares, squaresUsed)) return 1;
		return 0;
	}

	private int calculateForZero(int blocksUsed, int squaresUsed) {
		if(squares.length>=squaresUsed)	return 1;
		return 0;
	}

	
	private boolean isNoSquaresLeft(Square[] squares,int squaresUsed){
		return squares.length-squaresUsed==0;
	}
	
	private boolean isNoBlocksLeft(int[] blocks, int blocksUsed){
		return blocks.length-blocksUsed==0;
	}
	
	private boolean isLastBlock(int[] blocks, int blocksUsed){
		return blocks.length-blocksUsed==1;
	}
	
	private int possibleSquaresLeft(Square[] squares, int squaresUsed){
		return squares.length-squaresUsed;
	}
	
	private boolean blockCanBeUsedHere(int blockLength, Square[] squares, int squaresUsed) {
		if(possibleSquaresLeft(squares,squaresUsed)<blockLength) return false;
		if(squares[squaresUsed+blockLength]==Square.BLACK) return false;
		for(int i = squaresUsed;i<squaresUsed+blockLength-1;i++){
			if(squares[i]==Square.WHITE) return false;
		}
		return true;
	}

	
	public int getPossibilities(){
		return possibilities;
	}
	
	@Override
	public int compareTo(Line line) {
		int possibilitiesDiff = this.getPossibilities() - line.getPossibilities();
		if(possibilitiesDiff==0){
			return this.getId() - line.getId();
		}		
		return possibilitiesDiff;
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
	
	
	
}
