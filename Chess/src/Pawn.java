import java.util.HashSet;

public class Pawn extends Piece {

	public Pawn(int i, int j, int player) {
		column = i;
		row = j;
		color = player;
	}

	public String toString() {
		if (color == 2) {
			return "P";
		} else
			return "p";
	}

	public HashSet<Move> addmoves(ChessBoard chessBoard) {
		HashSet<Move> moves = new HashSet<Move>();
		if (this.color == 1)
			if (row > 0)
				if (chessBoard.spaces[row - 1][column].color == 0)
					moves.add(new Move(column, row, column, row - 1));
		if (row > 1)
			if (chessBoard.spaces[row - 2][column].color == 0
					&& chessBoard.spaces[row - 2][column].color == 0
					&& !this.moved) {
				moves.add(new Move(column, row, column, row - 2));
			}
		if (row > 0 && column < 7)
			if (chessBoard.spaces[row - 1][column + 1].color != 0
					&& chessBoard.spaces[row - 1][column + 1].color != this.color)
				moves.add(new Move(column, row, column + 1, row - 1));
		if (row > 0 && column > 0)
			if (chessBoard.spaces[row - 1][column - 1].color != 0
					&& chessBoard.spaces[row - 1][column - 1].color != this.color)
				moves.add(new Move(column, row, column - 1, row - 1));
		if (this.color == 2)
			if (row < 7)
				if (chessBoard.spaces[row + 1][column].color == 0)
					moves.add(new Move(column, row, column, row + 1));
		if (row < 6)
			if (chessBoard.spaces[row + 2][column].color == 0
					&& chessBoard.spaces[row + 1][column].color == 0
					&& !this.moved) {
				moves.add(new Move(column, row, column, row + 2));
			}
		if (row < 7 && column < 7)
			if (chessBoard.spaces[row + 1][column + 1].color == 1)
				moves.add(new Move(column, row, column + 1, row + 1));
		if (row < 7 && column > 0)
			if (chessBoard.spaces[row + 1][column - 1].color == 1)
				moves.add(new Move(column, row, column - 1, row + 1));
		return moves;
	}

}
