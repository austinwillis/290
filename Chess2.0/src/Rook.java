import java.util.HashSet;

public class Rook extends Piece {

	public Rook(int i, int j) {
		super(i, j);
	}

	public String toString() {
		return "r";
	}

	@Override
	public HashSet<Move> generatemoves(ChessBoard board, int player) {
		HashSet<Move> moves = new HashSet<>();
		return moves;
	}

}
