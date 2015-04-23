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
		Location l = null;
		int i = 1;
		while (this.L.row + i < 9 && this.L.column + i < 9) {
			l = new Location(this.L.row + i, this.L.column + i);
			if (!board.pieceat(l) || board.otherpieceat(l, player)) {
				moves.add(new Move(this.L, l));
			}
			if (board.otherpieceat(l, player) || board.pieceat(l)) {
				i = 9;
			}
			i++;
		}
		i = 1;
		while (this.L.row - i > 0 && this.L.column + i < 9) {
			l = new Location(this.L.row - i, this.L.column + i);
			if (!board.pieceat(l) || board.otherpieceat(l, player)) {
				moves.add(new Move(this.L, l));
			}
			if (board.otherpieceat(l, player) || board.pieceat(l)) {
				i = 9;
			}
			i++;
		}
		i = 1;
		while (this.L.row - i > 0 && this.L.column - i > 0) {
			l = new Location(this.L.row - i, this.L.column - i);
			if (!board.pieceat(l) || board.otherpieceat(l, player)) {
				moves.add(new Move(this.L, l));
			}
			if (board.otherpieceat(l, player) || board.pieceat(l)) {
				i = 9;
			}
			i++;
		}
		i = 1;
		while (this.L.row + i < 9 && this.L.column - i > 0) {
			l = new Location(this.L.row + i, this.L.column - i);
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
	public Bishop clone() {
		{
			return new Bishop(L.row, L.column);
		}
	}
}
