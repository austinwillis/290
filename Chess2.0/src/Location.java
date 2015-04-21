public class Location {

	int row;
	int column;

	public Location(int r, int c) {
		row = r;
		column = c;
	}

	boolean equals(Location P) {
		return (this.toString().equals(P.toString()));
	}

	public String toString() {
		StringBuffer output = new StringBuffer();
		char r = (char) (column + 96);
		output.append(r);
		output.append(row);
		return output.toString();
	}

}
