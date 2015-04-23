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
		ChessLocation l = null;
		int i = 1;
		while (this.L.row + i < 9) {
			l = new ChessLocation(this.L.row + i, this.L.column);
			if (!board.pieceat(l) || board.otherpieceat(l, player)) {
				moves.add(new Move(this.L, l));
			}
			if (board.otherpieceat(l, player) || board.pieceat(l)) {
				i = 9;
			}
			i++;
		}
		i = 1;
		while (this.L.column + i < 9) {
			l = new ChessLocation(this.L.row, this.L.column + i);
			if (!board.pieceat(l) || board.otherpieceat(l, player)) {
				moves.add(new Move(this.L, l));
			}
			if (board.otherpieceat(l, player) || board.pieceat(l)) {
				i = 9;
			}
			i++;
		}
		i = 1;
		while (this.L.row - i > 0) {
			l = new ChessLocation(this.L.row - i, this.L.column);
			if (!board.pieceat(l) || board.otherpieceat(l, player)) {
				moves.add(new Move(this.L, l));
			}
			if (board.otherpieceat(l, player) || board.pieceat(l)) {
				i = 9;
			}
			i++;
		}
		i = 1;
		while (this.L.column - i > 0) {
			l = new ChessLocation(this.L.row, this.L.column - i);
			if (!board.pieceat(l) || board.otherpieceat(l, player)) {
				moves.add(new Move(this.L, l));
			}
			if (board.otherpieceat(l, player) || board.pieceat(l)) {
				i = 9;
			}
			i++;
		}
		return moves;
	}

	@Override
	public Rook clone() {
		{
			return new Rook(L.row, L.column);
		}
	}

}
