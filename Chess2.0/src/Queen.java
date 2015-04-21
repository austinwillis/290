import java.util.HashSet;

public class Queen extends Piece {

	public Queen(int i, int j) {
		super(i, j);
	}

	public String toString() {
		return "q";
	}

	@Override
	public HashSet<Move> generatemoves(ChessBoard board, int player) {
		HashSet<Move> moves = new HashSet<>();
		return moves;
	}

}
