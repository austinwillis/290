import java.util.HashSet;

public class Queen extends Piece {

	public Queen(int i, int j) {
		super(i, j);
	}

	public Queen(Location l) {
		super(l);
	}

	public String toString() {
		return "q";
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
		i = 1;
		while (this.L.row + i < 9) {
			l = new Location(this.L.row + i, this.L.column);
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
			l = new Location(this.L.row, this.L.column + i);
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
			l = new Location(this.L.row - i, this.L.column);
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
			l = new Location(this.L.row, this.L.column - i);
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
	public Queen clone() {
		{
			return new Queen(L.row, L.column);
		}
	}

}
