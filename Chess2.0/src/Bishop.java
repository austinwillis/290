import java.util.HashSet;

public class Bishop extends Piece {

	public Bishop(int i, int j) {
		super(i, j);
	}

	public String toString() {
		return "b";
	}

	@Override
	public HashSet<Move> generatemoves(ChessBoard board, int player) {
		HashSet<Move> moves = new HashSet<>();
		return moves;
	}

}
