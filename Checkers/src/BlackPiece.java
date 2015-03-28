import java.util.ArrayList;


public class BlackPiece extends Piece {

	public BlackPiece() {
		color = 2;
		king = false;
	}

	public BlackPiece(int i, int j) {
		this();
		column = i;
		row = j;
	}

	public String toString() {
		if (king)
			return "B";
		else return "b";
	}
	
	public ArrayList<Move> addmoves(CheckerBoard checkerBoard, ArrayList<Move> moves) {
		return moves;
	}
	
	
}
