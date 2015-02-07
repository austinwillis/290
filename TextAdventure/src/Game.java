import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Game implements ActionListener {
	private static JTextArea A = new JTextArea("Welcome to I am bagel.\n\n"
			+ "You are bagel. You need to toast yourself.\n", 20, 50);
	private JTextField T = new JTextField(35);
	private JFrame frame = new JFrame("I am bagel");
	
	static Player player;
	
	public Game() {
		A.setEditable(false);
		frame.add(A);
		frame.add(new JLabel("Commands :"));
		T.setEditable(true);
		frame.add(T);
		
		T.addActionListener(this);
		
		
		frame.setLayout(new FlowLayout());
		frame.setSize(700, 525);
		frame.setVisible(true);
		
		JScrollPane scroll = new JScrollPane (A);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    
	    frame.add(scroll);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Game();
		player = new Player();
		A.append(player.getCurrentRoom().getRoomName() + "\n" + player.getCurrentRoom().getShortdes() + "\n");
	}
	

	public void actionPerformed(ActionEvent arg0) {
		String input = T.getText();
		String output = player.play(input);
		output = output.replace('~', '\n');
		A.append(output + "\n");
		A.setCaretPosition(A.getDocument().getLength());
		if (output.equals("END")) {
			System.exit(0);
		}
		T.setText("");
	}
 }


