package alanrusnak.challenge1.solver;

public class Square {
	private final int id;
	private State state;
	
		
	public Square(int id, State state) {
		super();
		this.id = id;
		this.state = state;
	}
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
		
	
}
