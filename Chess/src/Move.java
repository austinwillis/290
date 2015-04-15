
public class Move {

	protected int inputcolumn;
	protected int inputrow;
	protected int outputcolumn;
	protected int outputrow;
	
	public Move(int x, int y, int z, int r) {
		this.inputcolumn = x;
		this.inputrow = y;
		this.outputcolumn = z;
		this.outputrow = r;
	}

	boolean equals(Move x) {
		return (this.inputcolumn == x.inputcolumn &&
				this.inputrow == x.inputrow &&
				this.outputcolumn == x.outputcolumn &&
				this.outputrow == x.outputrow);
	}
	
	public String toString() {
		char inputchar;
		char outputchar;
		inputchar = (char) (inputcolumn + 97);
		outputchar = (char) (outputcolumn + 97);
		String output = new String();
		output += inputchar;
		output += inputrow + 1;
		output += "-";
		output += outputchar;
		output += outputrow + 1;
		return output;
	}
}
