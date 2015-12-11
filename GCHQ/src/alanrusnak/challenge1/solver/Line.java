package alanrusnak.challenge1.solver;

public class Line implements Comparable<Line>{

	private final int id;
	private int[] blocks;
	private Square[] squares;
	public Line(int id, int[] blocks, Square[] squares) {
		super();
		this.id = id;
		this.blocks = blocks;
		this.squares = squares;
	}

	private int possibilities;
	
	public int calculatePossibilities(){
		
	}
	
	public int getPossibilities(){
		
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
