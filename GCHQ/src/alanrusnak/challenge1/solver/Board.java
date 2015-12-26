package alanrusnak.challenge1.solver;



public class Board {

	private int width,height;
	private Line[] horizontalLines;
	private Line[] verticalLines;
	private Square[][] squares;
	
	
	public Board(){
		super();
	}
	
	public Board(int width, int height, Line[] horizontalLines,	Line[] verticalLines,Square[][] squares) {
		super();
		this.width = width;
		this.height = height;
		this.horizontalLines = horizontalLines;
		this.verticalLines = verticalLines;
		this.squares = squares;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Line[] getHorizontalLines() {
		return horizontalLines;
	}

	public void setHorizontalLines(Line[] horizontalLines) {
		this.horizontalLines = horizontalLines;
	}

	public Line[] getVerticalLines() {
		return verticalLines;
	}

	public void setVerticalLines(Line[] verticalLines) {
		this.verticalLines = verticalLines;
	}

	public Square[][] getSquares() {
		return squares;
	}
	
	
	
	
	
	
	
	
}
