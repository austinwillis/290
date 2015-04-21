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
				if (!board.pieceat(new Location(this.L.row + 1, this.L.column)))
					moves.add(new Move(this.L, new Location(this.L.row + 1,
							this.L.column)));
			}
			if (L.row < 7) {
				if (!board.pieceat(new Location(this.L.row + 1, this.L.column))
						&& !board.pieceat(new Location(this.L.row + 2,
								this.L.column)))
					moves.add(new Move(this.L, new Location(this.L.row + 2,
							this.L.column)));
			}
			if (L.row < 8 && L.column < 8)
				if (board.player2pieceat(new Location(this.L.row + 1,
						this.L.column + 1)))
					moves.add(new Move(this.L, new Location(this.L.row + 1,
							this.L.column + 1)));
			if (L.row < 8 && L.column > 1)
				if (board.player2pieceat(new Location(this.L.row + 1,
						this.L.column - 1)))
					moves.add(new Move(this.L, new Location(this.L.row + 1,
							this.L.column - 1)));
		} else {
			if (L.row > 1) {
				if (!board.pieceat(new Location(this.L.row - 1, this.L.column)))
					moves.add(new Move(this.L, new Location(this.L.row - 1,
							this.L.column)));
			}
			if (L.row > 2) {
				if (!board.pieceat(new Location(this.L.row - 1, this.L.column))
						&& !board.pieceat(new Location(this.L.row - 2,
								this.L.column)))
					moves.add(new Move(this.L, new Location(this.L.row - 2,
							this.L.column)));
			}
			if (L.row > 1 && L.column < 8)
				if (board.player1pieceat(new Location(this.L.row - 1,
						this.L.column + 1)))
					moves.add(new Move(this.L, new Location(this.L.row - 1,
							this.L.column + 1)));
			if (L.row > 1 && L.column > 1)
				if (board.player1pieceat(new Location(this.L.row - 1,
						this.L.column - 1)))
					moves.add(new Move(this.L, new Location(this.L.row - 1,
							this.L.column - 1)));
		}
		return moves;
	}
}
