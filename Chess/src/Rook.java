import java.util.ArrayList;


public class Rook extends Piece {

	public Rook(int j, int i, int j2) {
		super(j, i, j2);
	}
	
	public String toString() {
		if (color == 2) {
			return "R";
		}
		else return "r";
	}
	
	public ArrayList<Move> addmoves(ChessBoard chessBoard) {
		return new ArrayList<Move>();
	}
	
	


}
