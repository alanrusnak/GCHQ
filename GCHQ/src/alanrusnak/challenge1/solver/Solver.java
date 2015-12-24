package alanrusnak.challenge1.solver;

import java.util.TreeSet;

public class Solver {

	private TreeSet<Line> queue;
	
	
	
	public boolean solve(Board board){
		queue = new TreeSet<Line>();
		
		Line[] horizontal = board.getHorizontalLines();
		Line[] vertical = board.getVerticalLines();
		
		for(Line l : horizontal){
			queue.add(l);
		}
		for(Line l : vertical){
			queue.add(l);
		}
		
		while(!queue.isEmpty()){
			if(queue.first().getPossibilities()==1){
				Line next = queue.pollFirst();
				next.solveLine();
			}else{
				//Recalculate possibilities for all and see if anything has changed
				//if not then need to search!
			}
			
		}
		
		
	}
	
}
