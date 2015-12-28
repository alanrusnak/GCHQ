package alanrusnak.challenge1.solver;

import java.util.Iterator;
import java.util.TreeSet;

import alanrusnak.challenge1.loader.Loader;

public class Solver {

	private TreeSet<Line> queue;	
	
	
	public boolean solve(Board board){
		queue = new TreeSet<Line>();
		int partialRuns = 0;
		Line[] horizontal = board.getHorizontalLines();
		Line[] vertical = board.getVerticalLines();
		
		for(Line l : horizontal){
			queue.add(l);
		}
		for(Line l : vertical){
			queue.add(l);
		}
		
		while(!queue.isEmpty()){
			TreeSet<Line> tempqueue = new TreeSet<Line>();
			for(Line l : queue){
				tempqueue.add(l);
			}
			queue = new TreeSet<Line>(tempqueue);
			
			
			for(Line l : queue){
				System.out.println(l);
			}
			boolean notRunPartial = solveFullLines(queue);
			boolean runPartial = !notRunPartial;
			if(runPartial){
				solvePartialLines(queue);
				partialRuns++;
				if(partialRuns==20){
					//findMoreWhiteSquares(queue);
					//return false;
				}
				if(partialRuns==30){
					return false;
				}
				
			}
			
		
				
	}
		return true;
	}
	
	private void solvePartialLines(TreeSet<Line> queue) {
		System.out.println("Partial solver running. Lines: " + queue.size());
			Iterator<Line> it = queue.iterator();
			//for(int i = 0;i<30;i++){
			while(it.hasNext()){
				Line next = it.next();
				System.out.println("Partial solve: "+ next);
				next.partialSolveLine();
				System.out.println("After solve: "+ next);
			}
				
		
	}
	
	private void findMoreWhiteSquares(TreeSet<Line> queue) {
		Iterator<Line> it = queue.iterator();
		//for(int i = 0;i<30;i++){
		while(it.hasNext()){
			Line next = it.next();
			next.findMoreWhiteSquares();
		}
			
	
}

	private boolean solveFullLines(TreeSet<Line> queue){
		System.out.println("Full solver running. Lines: " + queue.size());
		if(queue.first().getPossibilities()==1){	
			Iterator<Line> it = queue.iterator();
			
			//for(int i = 0;i<30;i++){
			while(it.hasNext()){
				if(queue.first().getPossibilities()==1){
					Line next = queue.pollFirst();
					System.out.println("Full solve: "+ next);
					next.solveLine();
					if(queue.isEmpty()){
						return true;
					}
				}else{
					return true;
				}
			}
			return true;			
		}
		return false;
	}
	
	public static void main(String[] args){
		Solver solver = new Solver();
		Board board = (new Loader()).loadBoard("board.txt");
		
		System.out.println("Solved: " + solver.solve(board));
	}
	
}
