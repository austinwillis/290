
public class BoardPoint {

	int row;
	int column;
	int player;
	boolean checked;
	BoardPointBlob line = null;
	
	public BoardPoint(int row, int column) {
		this.row = row;
		this.column = column;
		this.player = 0;
		checked = false;
		this.line = null;
	}
	
	public BoardPoint(int row2, int column2, int currentPlayer) {
		this(row2, column2);
		this.player = currentPlayer;
		checked = false;
		this.line = null;
	}

	public String toString() {
		switch (this.player) {
		case 0: return ".";
		case 1: return "X";
		case 2: return "O";
		}
		return null;
	}

}
