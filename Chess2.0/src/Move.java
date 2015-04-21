public class Move {

	public Location startLoc;
	public Location endLoc;

	public Move(Location s, Location e) {
		startLoc = s;
		endLoc = e;
	}

	public String toString() {
		return startLoc.toString() + "-" + endLoc.toString();
	}

	boolean equals(Move m) {
		return (this.toString().equals(m.toString()));
	}

}
