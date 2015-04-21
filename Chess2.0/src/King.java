import java.util.HashSet;

public class King extends Piece {

	public King(int i, int j) {
		super(i, j);
	}

	public String toString() {
		return "k";
	}

	public boolean isking() {
		return true;
	}

	@Override
	public HashSet<Move> generatemoves(ChessBoard board, int player) {
		HashSet<Move> moves = new HashSet<>();
		return moves;
	}


}
