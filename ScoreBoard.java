import java.awt.*; 
import javax.swing.*;
public class ScoreBoard extends JPanel {
	private int wins;
	private int losses;
	private JPanel board;
	private JFrame frame;
	private JLabel score;
	public ScoreBoard(int w, int l) {
		wins=w;
		losses=l;
		board= new JPanel();		
		frame= new JFrame("Score Board");
		frame.setSize(250,75);
		score= new JLabel();
		score.setFont(new Font("Comic Sans MS",0,24));
		score.setText("Wins: "+wins+"     Losses: "+losses);
		score.setVisible(true);
		board.add(score); 
		board.setVisible(true);
		frame.add(board);
		frame.setVisible(true);
	}
	
}


