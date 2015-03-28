public class RedPiece extends Piece {

	public RedPiece() {
		color = 1;
		king = false;
	}
	
	public RedPiece(int i, int j) {
		this();
		column = i;
		row = j;
	}

	public String toString() {
		if (king)
			return "R";
		else return "r";
	}
	
}
