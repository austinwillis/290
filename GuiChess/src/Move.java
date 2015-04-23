public class Move {

	public ChessLocation startLoc;
	public ChessLocation endLoc;
	boolean castle;

	public Move(ChessLocation s, ChessLocation e) {
		startLoc = s;
		endLoc = e;
	}

	public Move(ChessLocation s, ChessLocation e, boolean c) {
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
