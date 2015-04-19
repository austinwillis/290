import java.util.HashSet;

public class Knight extends Piece {

	public Knight(int i, int j, int k) {
		super(i, j, k);
	}

	public String toString() {
		if (color == 2) {
			return "N";
		} else
			return "n";
	}

	public HashSet<Move> addmoves(ChessBoard chessBoard) {
		HashSet<Move> moves = new HashSet<Move>();
		if (row > 1 && column < 7)
			if (chessBoard.spaces[row-2][column+1].color != this.color)
				moves.add(new Move(column, row, column+1, row-2));
		if (row > 0 && column < 6)
			if (chessBoard.spaces[row-1][column+2].color != this.color)
				moves.add(new Move(column, row, column+2, row-1));
		if (row < 7 && column < 6)
			if (chessBoard.spaces[row+1][column+2].color != this.color)
				moves.add(new Move(column, row, column+2, row+1));
		if (row < 6 && column < 7)
			if (chessBoard.spaces[row+2][column+1].color != this.color)
				moves.add(new Move(column, row, column+1, row+2));
		if (row < 6 && column > 0)
			if (chessBoard.spaces[row+2][column-1].color != this.color)
				moves.add(new Move(column, row, column-1, row+2));
		if (row < 7 && column > 1)
			if (chessBoard.spaces[row+1][column-2].color != this.color)
				moves.add(new Move(column, row, column-2, row+1));
		if (row > 0 && column > 1)
			if (chessBoard.spaces[row-1][column-2].color != this.color)
				moves.add(new Move(row, column, row-1, column-2));
		if (row > 1 && column > 0)
			if (chessBoard.spaces[row-2][column-1].color != this.color)
				moves.add(new Move(row, column, row-2, column-1));
		return moves;

	}

}
