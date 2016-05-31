import java.awt.*;  
import javax.swing.*;
public class ScoreBoard extends JPanel {
	private int redWins;
	private int redLosses;
	private int blackWins;
	private int blackLosses;
	private JPanel board;
	private JFrame frame;
	private JLabel score;
	public ScoreBoard(int rw, int rl,int bw,int bl) {
		redWins=rw;
		redLosses=rl;
		blackWins=bw;
		blackLosses=bl;
		board= new JPanel();		
		frame= new JFrame("Score Board");
		frame.setSize(750,75);
		score= new JLabel();
		score.setFont(new Font("Comic Sans MS",0,24));
		score.setText("Red Wins: "+redWins+"     Red Losses: "
		+redLosses+"   Black Wins: "+blackWins
		+"    Black Losses: "+blackLosses);
		score.setVisible(true);
		board.add(score); 
		board.setVisible(true);
		frame.add(board);
		frame.setVisible(true);
	}
	
}


