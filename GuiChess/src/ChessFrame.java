import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ChessFrame {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChessFrame window = new ChessFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChessFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 990, 757);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 810, 661);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(33, 0, 97, 84);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(32, 81, 97, 84);
		panel.add(btnNewButton_1);
		
		JButton button = new JButton("New button");
		button.setBounds(32, 245, 97, 84);
		panel.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(32, 163, 97, 84);
		panel.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(32, 328, 97, 84);
		panel.add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(32, 411, 97, 84);
		panel.add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(32, 494, 97, 84);
		panel.add(button_4);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(32, 577, 97, 84);
		panel.add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.setBounds(128, 0, 97, 84);
		panel.add(button_6);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(128, 81, 97, 84);
		panel.add(button_7);
		
		JButton button_8 = new JButton("New button");
		button_8.setBounds(128, 163, 97, 84);
		panel.add(button_8);
		
		JButton button_9 = new JButton("New button");
		button_9.setBounds(128, 245, 97, 84);
		panel.add(button_9);
		
		JButton button_10 = new JButton("New button");
		button_10.setBounds(128, 328, 97, 84);
		panel.add(button_10);
		
		JButton button_11 = new JButton("New button");
		button_11.setBounds(128, 411, 97, 84);
		panel.add(button_11);
		
		JButton button_12 = new JButton("New button");
		button_12.setBounds(128, 494, 97, 84);
		panel.add(button_12);
		
		JButton button_13 = new JButton("New button");
		button_13.setBounds(128, 577, 97, 84);
		panel.add(button_13);
		
		JButton button_14 = new JButton("New button");
		button_14.setBounds(222, 577, 97, 84);
		panel.add(button_14);
		
		JButton button_15 = new JButton("New button");
		button_15.setBounds(319, 577, 97, 84);
		panel.add(button_15);
		
		JButton button_16 = new JButton("New button");
		button_16.setBounds(416, 577, 97, 84);
		panel.add(button_16);
		
		JButton button_17 = new JButton("New button");
		button_17.setBounds(514, 577, 97, 84);
		panel.add(button_17);
		
		JButton button_18 = new JButton("New button");
		button_18.setBounds(612, 577, 97, 84);
		panel.add(button_18);
		
		JButton button_19 = new JButton("New button");
		button_19.setBounds(710, 577, 97, 84);
		panel.add(button_19);
		
		JButton button_20 = new JButton("New button");
		button_20.setBounds(222, 494, 97, 84);
		panel.add(button_20);
		
		JButton button_21 = new JButton("New button");
		button_21.setBounds(319, 494, 97, 84);
		panel.add(button_21);
		
		JButton button_22 = new JButton("New button");
		button_22.setBounds(416, 494, 97, 84);
		panel.add(button_22);
		
		JButton button_23 = new JButton("New button");
		button_23.setBounds(514, 494, 97, 84);
		panel.add(button_23);
		
		JButton button_24 = new JButton("New button");
		button_24.setBounds(612, 494, 97, 84);
		panel.add(button_24);
		
		JButton button_25 = new JButton("New button");
		button_25.setBounds(710, 494, 97, 84);
		panel.add(button_25);
		
		JButton button_26 = new JButton("New button");
		button_26.setBounds(222, 411, 97, 84);
		panel.add(button_26);
		
		JButton button_27 = new JButton("New button");
		button_27.setBounds(319, 411, 97, 84);
		panel.add(button_27);
		
		JButton button_28 = new JButton("New button");
		button_28.setBounds(416, 411, 97, 84);
		panel.add(button_28);
		
		JButton button_29 = new JButton("New button");
		button_29.setBounds(514, 411, 97, 84);
		panel.add(button_29);
		
		JButton button_30 = new JButton("New button");
		button_30.setBounds(612, 411, 97, 84);
		panel.add(button_30);
		
		JButton button_31 = new JButton("New button");
		button_31.setBounds(710, 411, 97, 84);
		panel.add(button_31);
		
		JButton button_32 = new JButton("New button");
		button_32.setBounds(222, 328, 97, 84);
		panel.add(button_32);
		
		JButton button_33 = new JButton("New button");
		button_33.setBounds(222, 245, 97, 84);
		panel.add(button_33);
		
		JButton button_34 = new JButton("New button");
		button_34.setBounds(222, 163, 97, 84);
		panel.add(button_34);
		
		JButton button_35 = new JButton("New button");
		button_35.setBounds(222, 81, 97, 84);
		panel.add(button_35);
		
		JButton button_36 = new JButton("New button");
		button_36.setBounds(222, 0, 97, 84);
		panel.add(button_36);
		
		JButton button_37 = new JButton("New button");
		button_37.setBounds(319, 0, 97, 84);
		panel.add(button_37);
		
		JButton button_38 = new JButton("New button");
		button_38.setBounds(319, 81, 97, 84);
		panel.add(button_38);
		
		JButton button_39 = new JButton("New button");
		button_39.setBounds(319, 163, 97, 84);
		panel.add(button_39);
		
		JButton button_40 = new JButton("New button");
		button_40.setBounds(319, 245, 97, 84);
		panel.add(button_40);
		
		JButton button_41 = new JButton("New button");
		button_41.setBounds(319, 328, 97, 84);
		panel.add(button_41);
		
		JButton button_42 = new JButton("New button");
		button_42.setBounds(416, 328, 97, 84);
		panel.add(button_42);
		
		JButton button_43 = new JButton("New button");
		button_43.setBounds(514, 328, 97, 84);
		panel.add(button_43);
		
		JButton button_44 = new JButton("New button");
		button_44.setBounds(612, 328, 97, 84);
		panel.add(button_44);
		
		JButton button_45 = new JButton("New button");
		button_45.setBounds(710, 328, 97, 84);
		panel.add(button_45);
		
		JButton button_46 = new JButton("New button");
		button_46.setBounds(416, 245, 97, 84);
		panel.add(button_46);
		
		JButton button_47 = new JButton("New button");
		button_47.setBounds(514, 245, 97, 84);
		panel.add(button_47);
		
		JButton button_48 = new JButton("New button");
		button_48.setBounds(612, 245, 97, 84);
		panel.add(button_48);
		
		JButton button_49 = new JButton("New button");
		button_49.setBounds(710, 245, 97, 84);
		panel.add(button_49);
		
		JButton button_50 = new JButton("New button");
		button_50.setBounds(416, 163, 97, 84);
		panel.add(button_50);
		
		JButton button_51 = new JButton("New button");
		button_51.setBounds(514, 163, 97, 84);
		panel.add(button_51);
		
		JButton button_52 = new JButton("New button");
		button_52.setBounds(612, 163, 97, 84);
		panel.add(button_52);
		
		JButton button_53 = new JButton("New button");
		button_53.setBounds(710, 163, 97, 84);
		panel.add(button_53);
		
		JButton button_54 = new JButton("New button");
		button_54.setBounds(710, 81, 97, 84);
		panel.add(button_54);
		
		JButton button_55 = new JButton("New button");
		button_55.setBounds(612, 81, 97, 84);
		panel.add(button_55);
		
		JButton button_56 = new JButton("New button");
		button_56.setBounds(514, 81, 97, 84);
		panel.add(button_56);
		
		JButton button_57 = new JButton("New button");
		button_57.setBounds(416, 81, 97, 84);
		panel.add(button_57);
		
		JButton button_58 = new JButton("New button");
		button_58.setBounds(416, 0, 97, 84);
		panel.add(button_58);
		
		JButton button_59 = new JButton("New button");
		button_59.setBounds(514, 0, 97, 84);
		panel.add(button_59);
		
		JButton button_60 = new JButton("New button");
		button_60.setBounds(612, 0, 97, 84);
		panel.add(button_60);
		
		JButton button_61 = new JButton("New button");
		button_61.setBounds(710, 0, 97, 84);
		panel.add(button_61);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(831, 46, 129, 601);
		frame.getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setBounds(831, 11, 129, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
