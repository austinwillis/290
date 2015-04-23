import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChessButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChessLocation loc;

	public ChessButton(String name, ChessLocation l) {
		super(name);
		this.setLocation(l);
	}

	public void setLocation(ChessLocation l) {
		this.loc = l;
	}

	public ChessLocation getLoc() {
		return this.loc;
	}

	public void setChessicon(String string) {
		if (string.equals("nothing"))
			this.setIcon(null);
		if (string.equals("B"))
			try {
				Image img = ImageIO.read(getClass().getResource("BBishop.png"));
				this.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		if (string.equals("b"))
			try {
				Image img = ImageIO.read(getClass().getResource("WBishop.png"));
				this.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		if (string.equals("K"))
			try {
				Image img = ImageIO.read(getClass().getResource("BKing.png"));
				this.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		if (string.equals("k"))
			try {
				Image img = ImageIO.read(getClass().getResource("WKing.png"));
				this.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		if (string.equals("N"))
			try {
				Image img = ImageIO.read(getClass().getResource("BKnight.png"));
				this.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		if (string.equals("n"))
			try {
				Image img = ImageIO.read(getClass().getResource("WKnight.png"));
				this.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		if (string.equals("P"))
			try {
				Image img = ImageIO.read(getClass().getResource("BPawn.png"));
				this.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		if (string.equals("p"))
			try {
				Image img = ImageIO.read(getClass().getResource("WPawn.png"));
				this.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		if (string.equals("Q"))
			try {
				Image img = ImageIO.read(getClass().getResource("BQueen.png"));
				this.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		if (string.equals("q"))
			try {
				Image img = ImageIO.read(getClass().getResource("WQueen.png"));
				this.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		if (string.equals("R"))
			try {
				Image img = ImageIO.read(getClass().getResource("BRook.png"));
				this.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		if (string.equals("r"))
			try {
				Image img = ImageIO.read(getClass().getResource("WRook.png"));
				this.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
	}

}
