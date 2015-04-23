import java.util.HashSet;

public class Pawn extends Piece {

	public Pawn(int i, int j) {
		super(i, j);
	}

	public String toString() {
		return "p";
	}

	@Override
	public HashSet<Move> generatemoves(ChessBoard board, int player) {
		HashSet<Move> moves = new HashSet<>();
		if (player == 1) {
			if (L.row < 8) {
				if (!board.pieceat(new ChessLocation(this.L.row + 1,
						this.L.column)))
					moves.add(new Move(this.L, new ChessLocation(
							this.L.row + 1, this.L.column)));
			}
			if (L.row < 7) {
				if (!board.pieceat(new ChessLocation(this.L.row + 1,
						this.L.column))
						&& !board.pieceat(new ChessLocation(this.L.row + 2,
								this.L.column)))
					moves.add(new Move(this.L, new ChessLocation(
							this.L.row + 2, this.L.column)));
			}
			if (L.row < 8 && L.column < 8)
				if (board.otherpieceat(new ChessLocation(this.L.row + 1,
						this.L.column + 1), player))
					moves.add(new Move(this.L, new ChessLocation(
							this.L.row + 1, this.L.column + 1)));
			if (L.row < 8 && L.column > 1)
				if (board.otherpieceat(new ChessLocation(this.L.row + 1,
						this.L.column - 1), player))
					moves.add(new Move(this.L, new ChessLocation(
							this.L.row + 1, this.L.column - 1)));
		} else {
			if (L.row > 1) {
				if (!board.pieceat(new ChessLocation(this.L.row - 1,
						this.L.column)))
					moves.add(new Move(this.L, new ChessLocation(
							this.L.row - 1, this.L.column)));
			}
			if (L.row > 2) {
				if (!board.pieceat(new ChessLocation(this.L.row - 1,
						this.L.column))
						&& !board.pieceat(new ChessLocation(this.L.row - 2,
								this.L.column)))
					moves.add(new Move(this.L, new ChessLocation(
							this.L.row - 2, this.L.column)));
			}
			if (L.row > 1 && L.column < 8)
				if (board.otherpieceat(new ChessLocation(this.L.row - 1,
						this.L.column + 1), player))
					moves.add(new Move(this.L, new ChessLocation(
							this.L.row - 1, this.L.column + 1)));
			if (L.row > 1 && L.column > 1)
				if (board.otherpieceat(new ChessLocation(this.L.row - 1,
						this.L.column - 1), player))
					moves.add(new Move(this.L, new ChessLocation(
							this.L.row - 1, this.L.column - 1)));
		}
		return moves;
	}

	@Override
	public Pawn clone() {
		{
			return new Pawn(L.row, L.column);
		}
	}

	public boolean checkPawn() {
		if (L.row == 1 || L.row == 8)
			return true;
		return false;
	}
}
