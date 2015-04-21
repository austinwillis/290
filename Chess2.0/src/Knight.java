import java.util.HashSet;

public class Knight extends Piece {

	public Knight(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "n";
	}

	@Override
	public HashSet<Move> generatemoves(ChessBoard board, int player) {
		HashSet<Move> moves = new HashSet<>();
		return moves;
	}

}
