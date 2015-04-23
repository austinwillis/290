import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.util.HashSet;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextPane;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessFrame implements ActionListener {

	private JFrame frame;
	boolean pressed;
	Color bg;
	boolean gameover;
	static Game g;
	ChessButton firstbuttonpress;
	ChessButton secondbuttonpress;
	ChessButton btnNewButton;
	ChessButton btnNewButton_1;
	ChessButton button;
	ChessButton button_1;
	ChessButton button_2;
	ChessButton button_3;
	ChessButton button_4;
	ChessButton button_5;
	ChessButton button_6;
	ChessButton button_7;
	ChessButton button_8;
	ChessButton button_9;
	ChessButton button_10;
	ChessButton button_11;
	ChessButton button_12;
	ChessButton button_13;
	ChessButton button_14;
	ChessButton button_15;
	ChessButton button_16;
	ChessButton button_17;
	ChessButton button_18;
	ChessButton button_19;
	ChessButton button_20;
	ChessButton button_21;
	ChessButton button_22;
	ChessButton button_23;
	ChessButton button_24;
	ChessButton button_25;
	ChessButton button_26;
	ChessButton button_27;
	ChessButton button_28;
	ChessButton button_29;
	ChessButton button_30;
	ChessButton button_31;
	ChessButton button_32;
	ChessButton button_33;
	ChessButton button_34;
	ChessButton button_35;
	ChessButton button_36;
	ChessButton button_37;
	ChessButton button_38;
	ChessButton button_39;
	ChessButton button_40;
	ChessButton button_41;
	ChessButton button_42;
	ChessButton button_43;
	ChessButton button_44;
	ChessButton button_45;
	ChessButton button_46;
	ChessButton button_47;
	ChessButton button_48;
	ChessButton button_49;
	ChessButton button_50;
	ChessButton button_51;
	ChessButton button_52;
	ChessButton button_53;
	ChessButton button_54;
	ChessButton button_55;
	ChessButton button_56;
	ChessButton button_57;
	ChessButton button_58;
	ChessButton button_59;
	ChessButton button_60;
	ChessButton button_61;
	static HashSet<ChessButton> buttons;
	JTextPane textPane;
	JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		g = new Game();
		buttons = new HashSet<>();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChessFrame window = new ChessFrame(buttons, g);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	private static void setbuttonimages(ChessBoard board,
			HashSet<ChessButton> buttons) {
		boolean set;
		for (ChessButton e : buttons) {
			set = false;
			for (Piece each : board.Player1pieces) {
				if (e.getLoc().toString().equals(each.L.toString())) {
					e.setChessicon(each.toString());
					set = true;
				}
			}
			for (Piece each : board.Player2pieces) {
				if (e.getLoc().toString().equals(each.L.toString())) {
					e.setChessicon(each.toString().toUpperCase());
					set = true;
				}
			}
			if (!set)
				e.setChessicon("nothing");
		}
	}

	/**
	 * Create the application.
	 */
	public ChessFrame(HashSet<ChessButton> buttons, Game g) {
		initialize(buttons, g);
		pressed = false;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(HashSet<ChessButton> buttons, Game g) {
		frame = new JFrame();
		frame.setBounds(100, 100, 990, 757);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 810, 661);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		btnNewButton = new ChessButton("", new ChessLocation(8, 1));
		btnNewButton.setBounds(33, 0, 97, 84);
		panel.add(btnNewButton);
		buttons.add(btnNewButton);

		btnNewButton_1 = new ChessButton("", new ChessLocation(7, 1));
		btnNewButton_1.setBounds(32, 81, 97, 84);
		panel.add(btnNewButton_1);
		buttons.add(btnNewButton_1);

		button = new ChessButton("", new ChessLocation(6, 1));
		button.setBounds(32, 245, 97, 84);
		panel.add(button);
		buttons.add(button);

		button_1 = new ChessButton("", new ChessLocation(5, 1));
		button_1.setBounds(32, 163, 97, 84);
		panel.add(button_1);
		buttons.add(button_1);

		button_2 = new ChessButton("", new ChessLocation(4, 1));
		button_2.setBounds(32, 328, 97, 84);
		panel.add(button_2);
		buttons.add(button_2);

		button_3 = new ChessButton("", new ChessLocation(3, 1));
		button_3.setBounds(32, 411, 97, 84);
		panel.add(button_3);
		buttons.add(button_3);

		button_4 = new ChessButton("", new ChessLocation(2, 1));
		button_4.setBounds(32, 494, 97, 84);
		panel.add(button_4);
		buttons.add(button_4);

		button_5 = new ChessButton("", new ChessLocation(1, 1));
		button_5.setBounds(32, 577, 97, 84);
		panel.add(button_5);
		buttons.add(button_5);

		button_6 = new ChessButton("", new ChessLocation(8, 2));
		button_6.setBounds(128, 0, 97, 84);
		panel.add(button_6);
		buttons.add(button_6);

		button_7 = new ChessButton("", new ChessLocation(7, 2));
		button_7.setBounds(128, 81, 97, 84);
		panel.add(button_7);
		buttons.add(button_7);

		button_8 = new ChessButton("", new ChessLocation(6, 2));
		button_8.setBounds(128, 163, 97, 84);
		panel.add(button_8);
		buttons.add(button_8);

		button_9 = new ChessButton("", new ChessLocation(5, 2));
		button_9.setBounds(128, 245, 97, 84);
		panel.add(button_9);
		buttons.add(button_9);

		button_10 = new ChessButton("", new ChessLocation(4, 2));
		button_10.setBounds(128, 328, 97, 84);
		panel.add(button_10);
		buttons.add(button_10);

		button_11 = new ChessButton("", new ChessLocation(3, 2));
		button_11.setBounds(128, 411, 97, 84);
		panel.add(button_11);
		buttons.add(button_11);

		button_12 = new ChessButton("", new ChessLocation(2, 2));
		button_12.setBounds(128, 494, 97, 84);
		panel.add(button_12);
		buttons.add(button_12);

		button_13 = new ChessButton("", new ChessLocation(1, 2));
		button_13.setBounds(128, 577, 97, 84);
		panel.add(button_13);
		buttons.add(button_13);

		button_14 = new ChessButton("", new ChessLocation(1, 3));
		button_14.setBounds(222, 577, 97, 84);
		panel.add(button_14);
		buttons.add(button_14);

		button_15 = new ChessButton("", new ChessLocation(1, 4));
		button_15.setBounds(319, 577, 97, 84);
		panel.add(button_15);
		buttons.add(button_15);

		button_16 = new ChessButton("", new ChessLocation(1, 5));
		button_16.setBounds(416, 577, 97, 84);
		panel.add(button_16);
		buttons.add(button_16);

		button_17 = new ChessButton("", new ChessLocation(1, 6));
		button_17.setBounds(514, 577, 97, 84);
		panel.add(button_17);
		buttons.add(button_17);

		button_18 = new ChessButton("", new ChessLocation(1, 7));
		button_18.setBounds(612, 577, 97, 84);
		panel.add(button_18);
		buttons.add(button_18);

		button_19 = new ChessButton("", new ChessLocation(1, 8));
		button_19.setBounds(710, 577, 97, 84);
		panel.add(button_19);
		buttons.add(button_19);

		button_20 = new ChessButton("", new ChessLocation(2, 3));
		button_20.setBounds(222, 494, 97, 84);
		panel.add(button_20);
		buttons.add(button_20);

		button_21 = new ChessButton("", new ChessLocation(2, 4));
		button_21.setBounds(319, 494, 97, 84);
		panel.add(button_21);
		buttons.add(button_21);

		button_22 = new ChessButton("", new ChessLocation(2, 5));
		button_22.setBounds(416, 494, 97, 84);
		panel.add(button_22);
		buttons.add(button_22);

		button_23 = new ChessButton("", new ChessLocation(2, 6));
		button_23.setBounds(514, 494, 97, 84);
		panel.add(button_23);
		buttons.add(button_23);

		button_24 = new ChessButton("", new ChessLocation(2, 7));
		button_24.setBounds(612, 494, 97, 84);
		panel.add(button_24);
		buttons.add(button_24);

		button_25 = new ChessButton("", new ChessLocation(2, 8));
		button_25.setBounds(710, 494, 97, 84);
		panel.add(button_25);
		buttons.add(button_25);

		button_26 = new ChessButton("", new ChessLocation(3, 3));
		button_26.setBounds(222, 411, 97, 84);
		panel.add(button_26);
		buttons.add(button_26);

		button_27 = new ChessButton("", new ChessLocation(3, 4));
		button_27.setBounds(319, 411, 97, 84);
		panel.add(button_27);
		buttons.add(button_27);

		button_28 = new ChessButton("", new ChessLocation(3, 5));
		button_28.setBounds(416, 411, 97, 84);
		panel.add(button_28);
		buttons.add(button_28);

		button_29 = new ChessButton("", new ChessLocation(3, 6));
		button_29.setBounds(514, 411, 97, 84);
		panel.add(button_29);
		buttons.add(button_29);

		button_30 = new ChessButton("", new ChessLocation(3, 7));
		button_30.setBounds(612, 411, 97, 84);
		panel.add(button_30);
		buttons.add(button_30);

		button_31 = new ChessButton("", new ChessLocation(3, 8));
		button_31.setBounds(710, 411, 97, 84);
		panel.add(button_31);
		buttons.add(button_31);

		button_32 = new ChessButton("", new ChessLocation(4, 3));
		button_32.setBounds(222, 328, 97, 84);
		panel.add(button_32);
		buttons.add(button_32);

		button_33 = new ChessButton("", new ChessLocation(5, 3));
		button_33.setBounds(222, 245, 97, 84);
		panel.add(button_33);
		buttons.add(button_33);

		button_34 = new ChessButton("", new ChessLocation(6, 3));
		button_34.setBounds(222, 163, 97, 84);
		panel.add(button_34);
		buttons.add(button_34);

		button_35 = new ChessButton("", new ChessLocation(7, 3));
		button_35.setBounds(222, 81, 97, 84);
		panel.add(button_35);
		buttons.add(button_35);

		button_36 = new ChessButton("", new ChessLocation(8, 3));
		button_36.setBounds(222, 0, 97, 84);
		panel.add(button_36);
		buttons.add(button_36);

		button_37 = new ChessButton("", new ChessLocation(8, 4));
		button_37.setBounds(319, 0, 97, 84);
		panel.add(button_37);
		buttons.add(button_37);

		button_38 = new ChessButton("", new ChessLocation(7, 4));
		button_38.setBounds(319, 81, 97, 84);
		panel.add(button_38);
		buttons.add(button_38);

		button_39 = new ChessButton("", new ChessLocation(6, 4));
		button_39.setBounds(319, 163, 97, 84);
		panel.add(button_39);
		buttons.add(button_39);

		button_40 = new ChessButton("", new ChessLocation(5, 4));
		button_40.setBounds(319, 245, 97, 84);
		panel.add(button_40);
		buttons.add(button_40);

		button_41 = new ChessButton("", new ChessLocation(4, 4));
		button_41.setBounds(319, 328, 97, 84);
		panel.add(button_41);
		buttons.add(button_41);

		button_42 = new ChessButton("", new ChessLocation(4, 5));
		button_42.setBounds(416, 328, 97, 84);
		panel.add(button_42);
		buttons.add(button_42);

		button_43 = new ChessButton("", new ChessLocation(4, 6));
		button_43.setBounds(514, 328, 97, 84);
		panel.add(button_43);
		buttons.add(button_43);

		button_44 = new ChessButton("", new ChessLocation(4, 7));
		button_44.setBounds(612, 328, 97, 84);
		panel.add(button_44);
		buttons.add(button_44);

		button_45 = new ChessButton("", new ChessLocation(4, 8));
		button_45.setBounds(710, 328, 97, 84);
		panel.add(button_45);
		buttons.add(button_45);

		button_46 = new ChessButton("", new ChessLocation(5, 5));
		button_46.setBounds(416, 245, 97, 84);
		panel.add(button_46);
		buttons.add(button_46);

		button_47 = new ChessButton("", new ChessLocation(5, 6));
		button_47.setBounds(514, 245, 97, 84);
		panel.add(button_47);
		buttons.add(button_47);

		button_48 = new ChessButton("", new ChessLocation(5, 7));
		button_48.setBounds(612, 245, 97, 84);
		panel.add(button_48);
		buttons.add(button_48);

		button_49 = new ChessButton("", new ChessLocation(5, 8));
		button_49.setBounds(710, 245, 97, 84);
		panel.add(button_49);
		buttons.add(button_49);

		button_50 = new ChessButton("", new ChessLocation(6, 5));
		button_50.setBounds(416, 163, 97, 84);
		panel.add(button_50);
		buttons.add(button_50);

		button_51 = new ChessButton("", new ChessLocation(6, 6));
		button_51.setBounds(514, 163, 97, 84);
		panel.add(button_51);
		buttons.add(button_51);

		button_52 = new ChessButton("", new ChessLocation(6, 7));
		button_52.setBounds(612, 163, 97, 84);
		panel.add(button_52);
		buttons.add(button_52);

		button_53 = new ChessButton("", new ChessLocation(6, 8));
		button_53.setBounds(710, 163, 97, 84);
		panel.add(button_53);
		buttons.add(button_53);

		button_54 = new ChessButton("", new ChessLocation(7, 8));
		button_54.setBounds(710, 81, 97, 84);
		panel.add(button_54);
		buttons.add(button_54);

		button_55 = new ChessButton("", new ChessLocation(7, 7));
		button_55.setBounds(612, 81, 97, 84);
		panel.add(button_55);
		buttons.add(button_55);

		button_56 = new ChessButton("", new ChessLocation(7, 6));
		button_56.setBounds(514, 81, 97, 84);
		panel.add(button_56);
		buttons.add(button_56);

		button_57 = new ChessButton("", new ChessLocation(7, 5));
		button_57.setBounds(416, 81, 97, 84);
		panel.add(button_57);
		buttons.add(button_57);

		button_58 = new ChessButton("", new ChessLocation(8, 5));
		button_58.setBounds(416, 0, 97, 84);
		panel.add(button_58);
		buttons.add(button_58);

		button_59 = new ChessButton("", new ChessLocation(8, 6));
		button_59.setBounds(514, 0, 97, 84);
		panel.add(button_59);
		buttons.add(button_59);

		button_60 = new ChessButton("", new ChessLocation(8, 7));
		button_60.setBounds(612, 0, 97, 84);
		panel.add(button_60);
		buttons.add(button_60);

		button_61 = new ChessButton("", new ChessLocation(8, 8));
		button_61.setBounds(710, 0, 97, 84);
		panel.add(button_61);
		buttons.add(button_61);

		setbuttonimages(g.board, buttons);

		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		button.addActionListener(this);
		button_1.addActionListener(this);
		button_2.addActionListener(this);
		button_3.addActionListener(this);
		button_4.addActionListener(this);
		button_5.addActionListener(this);
		button_6.addActionListener(this);
		button_7.addActionListener(this);
		button_8.addActionListener(this);
		button_9.addActionListener(this);
		button_10.addActionListener(this);
		button_11.addActionListener(this);
		button_12.addActionListener(this);
		button_13.addActionListener(this);
		button_14.addActionListener(this);
		button_15.addActionListener(this);
		button_16.addActionListener(this);
		button_17.addActionListener(this);
		button_18.addActionListener(this);
		button_19.addActionListener(this);
		button_20.addActionListener(this);
		button_21.addActionListener(this);
		button_22.addActionListener(this);
		button_23.addActionListener(this);
		button_24.addActionListener(this);
		button_25.addActionListener(this);
		button_26.addActionListener(this);
		button_27.addActionListener(this);
		button_28.addActionListener(this);
		button_29.addActionListener(this);
		button_30.addActionListener(this);
		button_31.addActionListener(this);
		button_32.addActionListener(this);
		button_33.addActionListener(this);
		button_34.addActionListener(this);
		button_35.addActionListener(this);
		button_36.addActionListener(this);
		button_37.addActionListener(this);
		button_38.addActionListener(this);
		button_39.addActionListener(this);
		button_40.addActionListener(this);
		button_41.addActionListener(this);
		button_42.addActionListener(this);
		button_43.addActionListener(this);
		button_44.addActionListener(this);
		button_45.addActionListener(this);
		button_46.addActionListener(this);
		button_47.addActionListener(this);
		button_48.addActionListener(this);
		button_49.addActionListener(this);
		button_50.addActionListener(this);
		button_51.addActionListener(this);
		button_52.addActionListener(this);
		button_53.addActionListener(this);
		button_54.addActionListener(this);
		button_55.addActionListener(this);
		button_56.addActionListener(this);
		button_57.addActionListener(this);
		button_58.addActionListener(this);
		button_59.addActionListener(this);
		button_60.addActionListener(this);
		button_61.addActionListener(this);

		JLabel label = new JLabel("8");
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label.setBounds(10, 17, 46, 53);
		panel.add(label);

		JLabel label_1 = new JLabel("7");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_1.setBounds(10, 99, 46, 53);
		panel.add(label_1);

		JLabel label_2 = new JLabel("6");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_2.setBounds(10, 181, 46, 53);
		panel.add(label_2);

		JLabel label_3 = new JLabel("5");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_3.setBounds(10, 258, 46, 53);
		panel.add(label_3);

		JLabel label_4 = new JLabel("4");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_4.setBounds(10, 340, 46, 53);
		panel.add(label_4);

		JLabel label_5 = new JLabel("3");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_5.setBounds(10, 430, 46, 53);
		panel.add(label_5);

		JLabel label_6 = new JLabel("2");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_6.setBounds(10, 513, 46, 53);
		panel.add(label_6);

		JLabel label_7 = new JLabel("1");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_7.setBounds(10, 597, 46, 53);
		panel.add(label_7);

		textArea = new JTextArea();
		textArea.setBounds(831, 46, 129, 601);
		frame.getContentPane().add(textArea);

		JLabel lblA = new JLabel("A");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblA.setBounds(73, 654, 46, 53);
		frame.getContentPane().add(lblA);

		JLabel lblB = new JLabel("B");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblB.setBounds(163, 654, 46, 53);
		frame.getContentPane().add(lblB);

		JLabel lblC = new JLabel("C");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblC.setBounds(261, 654, 46, 53);
		frame.getContentPane().add(lblC);

		JLabel lblD = new JLabel("D");
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblD.setBounds(353, 654, 46, 53);
		frame.getContentPane().add(lblD);

		JLabel lblE = new JLabel("E");
		lblE.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblE.setBounds(451, 654, 46, 53);
		frame.getContentPane().add(lblE);

		JLabel lblG = new JLabel("F");
		lblG.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblG.setBounds(554, 654, 46, 53);
		frame.getContentPane().add(lblG);

		JLabel lblG_1 = new JLabel("G");
		lblG_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblG_1.setBounds(649, 654, 46, 53);
		frame.getContentPane().add(lblG_1);

		JLabel lblH = new JLabel("H");
		lblH.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblH.setBounds(745, 654, 46, 53);
		frame.getContentPane().add(lblH);

		textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setForeground(SystemColor.desktop);
		textPane.setEditable(false);
		textPane.setBounds(831, 11, 129, 22);
		frame.getContentPane().add(textPane);
		textPane.setText("Player " + g.getPlayer() + "'s turn");
	}

	public void actionPerformed(ActionEvent ae) {
		if (gameover)
			System.exit(0);
		if (!pressed) {
			firstbuttonpress = (ChessButton) ae.getSource();
			bg = firstbuttonpress.getBackground();
			firstbuttonpress.setBackground(new Color(230, 230, 250));
			pressed = true;
		} else {
			firstbuttonpress.setBackground(bg);
			secondbuttonpress = (ChessButton) ae.getSource();
			pressed = false;
			if (update(firstbuttonpress.getLoc().toString() + "-"
					+ secondbuttonpress.getLoc().toString()))
				;
		}
	}

	private boolean update(String string) {
		if (g.rungame(string)) {
			textArea.append(string + "\n");
			ChessBoard testboard = g.board.clone();
			if (testboard.checkwin(g.player)) {
				textPane.setText("Player " + g.getPlayer() + " wins!");
				textArea.append("Click any space\nto end the game.");
				gameover = true;
			}
		} else
			return false;
		setbuttonimages(g.board, buttons);
		if (!gameover)
			textPane.setText("Player " + g.getPlayer() + "'s turn");
		return true;
	}

}
