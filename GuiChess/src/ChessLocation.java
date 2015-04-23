public class ChessLocation {

	int row;
	int column;

	public ChessLocation(int r, int c) {
		row = r;
		column = c;
	}

	public String toString() {
		StringBuffer output = new StringBuffer();
		char r = (char) (column + 96);
		output.append(r);
		output.append(row);
		return output.toString();
	}

}
