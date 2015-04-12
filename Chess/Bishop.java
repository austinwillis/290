import java.util.ArrayList;


public class Bishop extends Piece {

	public Bishop(int i, int j, int k) {
		super(i, j, k);
	}

	public String toString() {
		if (color == 2) {
			return "B";
		}
		else return "b";
	}
	
	public ArrayList<Move> addmoves(ChessBoard chessBoard) {
		return new ArrayList<Move>();
	}
	
	
	
}
