public class Move {

	public Location startLoc;
	public Location endLoc;
	boolean castle;

	public Move(Location s, Location e) {
		startLoc = s;
		endLoc = e;
	}

	public Move(Location s, Location e, boolean c) {
		startLoc = s;
		endLoc = e;
		castle = c;
	}

	public String toString() {
		return startLoc.toString() + "-" + endLoc.toString();
	}

	boolean equals(Move m) {
		return (this.toString().equals(m.toString()));
	}

}
