import java.util.ArrayList;


public class King extends Piece {

	public King(int i, int j, int k) {
		super(i, j, k);
	}

	public String toString() {
		if (color == 2) {
			return "K";
		}
		else return "k";
	}
	
	public ArrayList<Move> addmoves(ChessBoard chessBoard) {
		return new ArrayList<Move>();
	}
	
	
	
}
