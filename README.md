# Final-Project\
import java.util.*;
import java.awt.*;
import java.io.*;
public class CheckersGame {
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(640, 640);
		Graphics g = panel.getGraphics();
		CheckersBoard game = new CheckersBoard();
		printBoard(g, game);
		while (!gameOver(game)) {
		    getNextMove(panel, game);
		    printBoard(g, game);
		}
		System.out.println("The winner is " + winnerIs(game));
	}
	
	public static void printBoard(Graphics g, CheckersBoard game) {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(i%2 == j%2){
					g.setColor(Color.BLACK);
					g.fillRect(i*80, j*80, 80, 80);
				}
				else{
					g.setColor(Color.WHITE);
					g.fillRect(i*80, j*80, 80, 80);
				}
			}
		}
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(game.board[i][j] == 1){
					g.setColor(Color.RED);
					g.fillOval(i*80 + 10, j*80+ 10, 60, 60);
				}else if(game.board[i][j] == 2){
					g.setColor(Color.BLUE);
					g.fillOval(i*80 + 10, j*80+ 10, 60, 60);
				}
			}
		}
	}
	
	public static void getNextMove(DrawingPanel panel, CheckersBoard game){
		boolean moved = false;
		while (!moved) {
			panel.setClick();
			int startX = panel.getClickX();
			int startY = panel.getClickY();
			while(startX == -1){   
				startX = panel.getClickX();
				startY = panel.getClickY();
			}
			panel.setClick();
			int endX = panel.getClickX();
			int endY = panel.getClickY();
			while(endX == -1){
				endX = panel.getClickX();
				endY = panel.getClickY();
			}
			panel.setClick();
			startX = startX/80;
			startY = startY/80;
			endX = endX/80;
			endY = endY/80;
			if (validMove(startX, startY, endX, endY, game)) {
				executeMove(startX, startY, endX, endY, game);
				moved = true;
			}else
				System.out.println("That was an invalid move, try again.");
		}
		if (game.whosemove == true)
			game.whosemove = false;
		else
			game.whosemove = true;
	 }
	 
	 public static boolean validMove(int xfrom, int yfrom, int xto, int yto, CheckersBoard game){
		int check;
		if(game.whosemove)
			check = 1;
		else
			check = 2;
		if (xfrom < 0 || xfrom > 7 || yfrom < 0 || yfrom > 7 ||
			xto < 0 || xto > 7 || yto < 0 || yto > 7) 
			return false;
		else if (game.board[xfrom][yfrom] == check && game.board[xto][yto] == 0) {
			if (Math.abs(xfrom-xto)==1) {
				if ((game.whosemove == true) && (yto - yfrom == 1))
				    return true;
				else if ((game.whosemove == false) && (yto - yfrom == -1))
				    return true;
			    }
			    else if (Math.abs(xfrom-xto)==2) {
				if (game.whosemove == true && (yto - yfrom == 2) && 
				    game.board[(xfrom+xto)/2][(yfrom+yto)/2] == 2)
				    return true;
				else if (game.whosemove == false && (yto - yfrom == -2) && 
				    game.board[(xfrom+xto)/2][(yfrom+yto)/2] == 1)
				    return true;
			    }
			}
			return false;
	 }
	 
	 public static void executeMove(int xfrom, int yfrom, int xto, int yto, CheckersBoard game) {
		 int check;
			if(game.whosemove)
				check = 1;
			else
				check = 2;
		game.board[xfrom][yfrom] = 0;
		game.board[xto][yto] = check;
		if (Math.abs(xto - xfrom) == 2) {
			game.board[(xfrom+xto)/2][(yfrom+yto)/2] = 0;
			if (game.whosemove == true)
				game.redcheckers--;
			else
			    game.blackcheckers--;
		}
	 }
	 public static boolean gameOver(CheckersBoard game) {
			return (game.redcheckers == 0 || game.blackcheckers == 0);
		    }

		    // Returns color of the winner.
	 public static String winnerIs(CheckersBoard game) {
		if (game.blackcheckers == 0)
			return "blue";
		else
			return "red";
		}
}









import java.util.*;
import java.io.*;

public class CheckersBoard {
	
	public int[][] board; 
	public int redcheckers; 
	public int blackcheckers; 
	public boolean whosemove; 

	public CheckersBoard() {
		
		board = new int[8][8];
	    redcheckers = 12;
	    blackcheckers = 12;
	    whosemove = true;
	    
	    for (int i = 0; i < 8; i++)
	    	for (int j = 0; j < 8; j++)
	    		board[i][j] = 0;
	    
	    for (int i = 1; i < 8; i+=2){
	    	board[i][1] = 1;
	    	board[i][5] = 2;
	    	board[i][7] = 2;
	    }
	    
	    for (int i = 0; i < 8; i+=2) {
	    	board[i][0] = 1;
	    	board[i][2] = 1;
	    	board[i][6] = 2;
	    }
	}
}
