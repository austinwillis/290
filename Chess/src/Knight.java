import java.util.ArrayList;


public class Knight extends Piece {

	public Knight(int i, int j, int k) {
		super(i, j, k);
	}
	
	public String toString() {
		if (color == 2) {
			return "N";
		}
		else return "n";
	}
	
	public ArrayList<Move> addmoves(ChessBoard chessBoard) {
		return new ArrayList<Move>();
	}
	
	

}
