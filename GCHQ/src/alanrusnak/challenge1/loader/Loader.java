package alanrusnak.challenge1.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import alanrusnak.challenge1.solver.Board;
import alanrusnak.challenge1.solver.Line;
import alanrusnak.challenge1.solver.Square;
import alanrusnak.challenge1.solver.SquareState;

public class Loader {
	BufferedReader reader;
	
	//C:\Users\Alan\git\GCHQRepo\GCHQ\board.txt
	public Board loadBoard(String filename){
		Board board = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
			int[] widthAndHeight = loadWidthAndHeight(filename);
			int width = widthAndHeight[0];
			int height = widthAndHeight[1];
			
			Line[] horizontal = loadHorizontal(filename,height);
			Line[] vertical = loadVertical(filename,width);
			
			Square[][] squares = loadSquares(filename,height,width);
			setLineSquares(horizontal,vertical,squares);
			
			board = new Board(width, height, horizontal, vertical);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}		
		
		
		
		return board;
	}
	
	public int[] loadWidthAndHeight(String filename) throws IOException{
		    String line = reader.readLine();
		    String[] lineSplit = line.split(",");
		    int[] dim = new int[2];
		    dim[0] = Integer.parseInt(lineSplit[0]);
		    dim[1] = Integer.parseInt(lineSplit[1]);
		    
		    return dim;
		
	}
	
	
	
	public Line[] loadHorizontal(String filename,int height) throws IOException{
		Line[] horizontal = new Line[height];
		
		String line;
		line = reader.readLine();
	    
		for(int id = 0;id<height;id++){
			line = reader.readLine();
			horizontal[id] = new Line(id, StringArrToIntArr(line.split(",")));
	        	
		}
		
		return horizontal;
	}
	
	public int[] StringArrToIntArr(String[] string){
		int[] arr = new int[string.length];
		for(int i = 0;i<string.length;i++){
			arr[i] = Integer.parseInt(string[i]);
		}
		return arr;
	}
	
	public Line[] loadVertical(String filename, int width) throws IOException{
		Line[] vertical = new Line[width];
		
		String line;
		line = reader.readLine();
	    
		for(int id = width;id<width+width;id++){
			line = reader.readLine();
			vertical[id] = new Line(id, StringArrToIntArr(line.split(",")));
	        	
		}
		
		return vertical;
	}
	
	public Square[][] loadSquares(String filename, int width, int height) throws IOException{
		Square[][] squares = new Square[height][width];
		
				
		String line;
		line = reader.readLine();
	    
		for(int i = 0;i<height;i++){
			line = reader.readLine().replaceAll(" ","");
			for(int j = 0; j<width;j++ ){
				
				squares[i][j] = new Square(Integer.parseInt(""+line.charAt(j))==1? SquareState.BLACK : SquareState.UNDECIDED);
				
				
			}
	        	
		}
		
		return squares;
		
	}
	
	public void setLineSquares(Line[] horizontal, Line[] vertical, Square[][] squares){
		for(int i = 0;i<horizontal.length;i++){
			for(int j=0;j<vertical.length;j++){
				horizontal[i].getSquares()[j] = squares[i][j];
			}
		}
		for(int i = 0;i<vertical.length;i++){
			for(int j=0;j<horizontal.length;j++){
				vertical[i].getSquares()[j] = squares[j][i];
			}
		}
		
		
	}
	
	
}
