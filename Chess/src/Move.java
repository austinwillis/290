public class Move implements Cloneable {

	protected int inputcolumn;
	protected int inputrow;
	protected int outputcolumn;
	protected int outputrow;
	protected boolean castle;

	public Move(int x, int y, int z, int r) {
		this.inputcolumn = x;
		this.inputrow = y;
		this.outputcolumn = z;
		this.outputrow = r;
		this.castle = false;	
	}
	
	public Move clone() {
		return new Move(this);
	}

	public Move(int column, int row, int i, int j, boolean b) {
		this(column, row, i, j);
		this.castle = true;
	}

	public Move(Move move) {
		this.inputcolumn = move.inputcolumn;
		this.outputcolumn = move.outputcolumn;
		this.inputrow = move.inputrow;
		this.outputrow = move.outputrow;
		this.castle = move.castle;
	}
	boolean equals(Move x) {
		return (this.inputcolumn == x.inputcolumn
				&& this.inputrow == x.inputrow
				&& this.outputcolumn == x.outputcolumn && this.outputrow == x.outputrow);
	}

	public String toString() {
		char inputchar;
		char outputchar;
		inputchar = (char) (inputcolumn + 97);
		outputchar = (char) (outputcolumn + 97);
		String output = new String();
		output += inputchar;
		output += 8 - inputrow;
		output += "-";
		output += outputchar;
		output += 8 - outputrow;
		return output;
	}
}
