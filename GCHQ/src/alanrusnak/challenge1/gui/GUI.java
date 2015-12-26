package alanrusnak.challenge1.gui;

import java.awt.*;
import javax.swing.*;

import alanrusnak.challenge1.loader.Loader;
import alanrusnak.challenge1.solver.Board;

public class GUI {

	public void createGUI(String filename){
		JFrame frame = new JFrame();
		frame.setTitle("GCHQ Challenge 1 - Alan Rusnak");
		frame.setSize(700,700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		JPanel sideBar = getSideBar();
		
		
		PuzzleArea puzzleArea = new PuzzleArea(initializeBoard(filename));
		
		
		panel.add(puzzleArea,BorderLayout.CENTER);
		panel.add(sideBar,BorderLayout.EAST);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	public Board initializeBoard(String filename){
		Loader loader = new Loader();
		return loader.loadBoard(filename);
	}
	
	public JPanel getSideBar(){
		JPanel sideBar = new JPanel();
		JButton solveButton = new JButton("Solve");
		sideBar.add(solveButton);
		return sideBar;
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                (new GUI()).createGUI("board.txt"); 
            }
        });
	}
	
}
