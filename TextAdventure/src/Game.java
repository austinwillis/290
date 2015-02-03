import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Game implements ActionListener {
	private static JTextArea A = new JTextArea("Welcome to my game.\n", 15, 40);
	private JTextField T = new JTextField(30);
	private JFrame frame = new JFrame("Text Adventure");
	
	static Player player;
	
	public Game() {
		A.setEditable(false);
		frame.add(A);
		frame.add(new JLabel("Commands :"));
		T.setEditable(true);
		frame.add(T);
		
		T.addActionListener(this);
		
		
		frame.setLayout(new FlowLayout());
		frame.setSize(500, 325);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Game();
		player = new Player();
		A.append(player.getCurrentRoom().getRoomName() + "\n" + player.getCurrentRoom().getShortdes() + "\n");
	}
	

	public void actionPerformed(ActionEvent arg0) {
		String input = T.getText();
		Room temp = player.getCurrentRoom();
		String output = player.play(input);
		A.append(output + "\n");
		if (output.equals("END")) {
			System.exit(0);
		}
		T.setText("");
	}
 }


