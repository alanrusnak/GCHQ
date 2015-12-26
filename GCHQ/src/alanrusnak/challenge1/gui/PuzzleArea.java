package alanrusnak.challenge1.gui;

import java.awt.*;
import javax.swing.*;

import alanrusnak.challenge1.solver.Board;
import alanrusnak.challenge1.solver.Square;
import alanrusnak.challenge1.solver.SquareState;

public class PuzzleArea extends JPanel{

	private Board board;

	public PuzzleArea(Board board){
		this.board = board;
	}
	
	public Dimension getPreferredSize() {
        return new Dimension(600,600);
    }
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);    
        Square[][] squares = board.getSquares();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,600,600);        
        g.setColor(Color.BLACK);
        
        
        for(int i = 0;i<squares.length;i++){
        	for(int j = 0;j<squares[0].length;j++){
        		switch (squares[i][j].getState()){
        		case BLACK:
        			g.setColor(Color.BLACK);
        			g.fillRect(50+j*20,50+i*20,20,20);
        			break;
        		case UNDECIDED:
        			g.setColor(new Color(230,230,230));
        			g.fillRect(50+j*20,50+i*20,20,20);
        			break;
        		case WHITE:
        			g.setColor(Color.WHITE);
        			//g.fillRect(51+j*20,549-i*20,69+j*20,529-i*20);
        			break;
        			
        		}
            }
        }
        
        g.setColor(Color.BLACK);
        for(int i = 0;i<squares.length+1;i++){
        	g.drawLine(50,50+i*20,550,50+i*20);
        }
        for(int i = 0;i<squares[0].length+1;i++){
        	g.drawLine(50+i*20,50,50+i*20,550);
        }
        
    }  
	
}
