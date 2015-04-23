import java.util.HashSet;

public class Knight extends Piece {

	public Knight(int i, int j) {
		super(i, j);
	}

	@Override
	public String toString() {
		return "n";
	}

	@Override
	public HashSet<Move> generatemoves(ChessBoard board, int player) {
		HashSet<Move> moves = new HashSet<>();
		if (this.L.row > 2 && this.L.column < 8)
			if (!board.pieceat(new ChessLocation(this.L.row - 2, this.L.column + 1))
					|| board.otherpieceat(new ChessLocation(this.L.row - 2,
							this.L.column + 1), player))
				moves.add(new Move(this.L, new ChessLocation(this.L.row - 2,
						this.L.column + 1)));
		if (this.L.row > 1 && this.L.column < 7)
			if (!board.pieceat(new ChessLocation(this.L.row - 1, this.L.column + 2))
					|| board.otherpieceat(new ChessLocation(this.L.row - 1,
							this.L.column + 2), player))
				moves.add(new Move(this.L, new ChessLocation(this.L.row - 1,
						this.L.column + 2)));
		if (this.L.row < 8 && this.L.column < 7)
			if (!board.pieceat(new ChessLocation(this.L.row + 1, this.L.column + 2))
					|| board.otherpieceat(new ChessLocation(this.L.row + 1,
							this.L.column + 2), player))
				moves.add(new Move(this.L, new ChessLocation(this.L.row + 1,
						this.L.column + 2)));
		if (this.L.row < 7 && this.L.column < 8)
			if (!board.pieceat(new ChessLocation(this.L.row + 2, this.L.column + 1))
					|| board.otherpieceat(new ChessLocation(this.L.row + 2,
							this.L.column + 1), player))
				moves.add(new Move(this.L, new ChessLocation(this.L.row + 2,
						this.L.column + 1)));
		if (this.L.row < 7 && this.L.column > 1)
			if (!board.pieceat(new ChessLocation(this.L.row + 2, this.L.column - 1))
					|| board.otherpieceat(new ChessLocation(this.L.row + 2,
							this.L.column - 1), player))
				moves.add(new Move(this.L, new ChessLocation(this.L.row + 2,
						this.L.column - 1)));
		if (this.L.row < 8 && this.L.column > 2)
			if (!board.pieceat(new ChessLocation(this.L.row + 1, this.L.column - 2))
					|| board.otherpieceat(new ChessLocation(this.L.row + 1,
							this.L.column - 2), player))
				moves.add(new Move(this.L, new ChessLocation(this.L.row + 1,
						this.L.column - 2)));
		if (this.L.row > 1 && this.L.column > 2)
			if (!board.pieceat(new ChessLocation(this.L.row - 1, this.L.column - 2))
					|| board.otherpieceat(new ChessLocation(this.L.row - 1,
							this.L.column - 2), player))
				moves.add(new Move(this.L, new ChessLocation(this.L.row - 1,
						this.L.column - 2)));
		if (this.L.row > 2 && this.L.column > 1)
			if (!board.pieceat(new ChessLocation(this.L.row - 2, this.L.column - 1))
					|| board.otherpieceat(new ChessLocation(this.L.row - 2,
							this.L.column - 1), player))
				moves.add(new Move(this.L, new ChessLocation(this.L.row - 2,
						this.L.column - 1)));
		return moves;
	}

	@Override
	public Knight clone() {
		{
			return new Knight(L.row, L.column);
		}
	}

}