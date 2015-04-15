import java.util.ArrayList;


public class Queen extends Piece {

	public Queen(int i, int j, int k) {
		super(i, j, k);
	}
	
	public String toString() {
		if (color == 2) {
			return "Q";
		}
		else return "q";
	}
	
	public ArrayList<Move> addmoves(ChessBoard chessBoard) {
		return new ArrayList<Move>();
	}
	
	

}
