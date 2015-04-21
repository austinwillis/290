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
		Location l = null;
		if (this.L.row + 1 < 9 && this.L.column + 1 < 9) {
			l = new Location(this.L.row + 1, this.L.column + 1);
			if (!board.pieceat(l) || board.otherpieceat(l, player)) {
				moves.add(new Move(this.L, l));
			}
		}
		if (this.L.row - 1 > 0 && this.L.column + 1 < 9) {
			l = new Location(this.L.row - 1, this.L.column + 1);
			if (!board.pieceat(l) || board.otherpieceat(l, player)) {
				moves.add(new Move(this.L, l));
			}
		}
		if (this.L.row - 1 > 0 && this.L.column - 1 > 0) {
			l = new Location(this.L.row - 1, this.L.column - 1);
			if (!board.pieceat(l) || board.otherpieceat(l, player)) {
				moves.add(new Move(this.L, l));
			}
		}
		if (this.L.row + 1 < 9 && this.L.column - 1 > 0) {
			l = new Location(this.L.row + 1, this.L.column - 1);
			if (!board.pieceat(l) || board.otherpieceat(l, player)) {
				moves.add(new Move(this.L, l));
			}
		}
		if (this.L.row + 1 < 9) {
			l = new Location(this.L.row + 1, this.L.column);
			if (!board.pieceat(l) || board.otherpieceat(l, player)) {
				moves.add(new Move(this.L, l));
			}
		}
		if (this.L.column + 1 < 9) {
			l = new Location(this.L.row, this.L.column + 1);
			if (!board.pieceat(l) || board.otherpieceat(l, player)) {
				moves.add(new Move(this.L, l));
			}
		}
		if (this.L.row - 1 > 0) {
			l = new Location(this.L.row - 1, this.L.column);
			if (!board.pieceat(l) || board.otherpieceat(l, player)) {
				moves.add(new Move(this.L, l));
			}
		}
		if (this.L.column - 1 > 0) {
			l = new Location(this.L.row, this.L.column - 1);
			if (!board.pieceat(l) || board.otherpieceat(l, player)) {
				moves.add(new Move(this.L, l));
			}
		}
		if (!this.moved
				&& board.pieceat(new Location(this.L.row, this.L.column + 3))
				&& !board.pieceat(new Location(this.L.row, this.L.column + 2))
				&& !board.pieceat(new Location(this.L.row, this.L.column + 1))
				&& !board.movedpieceat(new Location(this.L.row,
						this.L.column + 2)))
			moves.add(new Move(this.L, new Location(this.L.row,
					this.L.column + 2), true));
		if (!this.moved
				&& board.pieceat(new Location(this.L.row, this.L.column - 4))
				&& !board.pieceat(new Location(this.L.row, this.L.column - 3))
				&& !board.pieceat(new Location(this.L.row, this.L.column - 2))
				&& !board.pieceat(new Location(this.L.row, this.L.column - 1))
				&& !board.movedpieceat(new Location(this.L.row,
						this.L.column - 4)))
			moves.add(new Move(this.L, new Location(this.L.row,
					this.L.column - 2), true));
		return moves;
	}

	@Override
	public King clone() {
		{
			return new King(L.row, L.column);
		}
	}

}
