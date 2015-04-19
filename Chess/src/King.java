import java.util.HashSet;

public class King extends Piece {

	public King(int i, int j, int k) {
		super(i, j, k);
	}

	public String toString() {
		if (color == 2) {
			return "K";
		} else
			return "k";
	}
	
	public boolean isking() {
		return true;
	}

	public HashSet<Move> addmoves(ChessBoard chessBoard) {
		HashSet<Move> moves = new HashSet<Move>();
		if (row > 0)
			if (chessBoard.spaces[row - 1][column].color != this.color)
				moves.add(new Move(column, row, column, row - 1));
		if (row > 0 && column < 7)
			if (chessBoard.spaces[row - 1][column + 1].color != this.color)
				moves.add(new Move(column, row, column + 1, row - 1));
		if (row > 0 && column > 0)
			if (chessBoard.spaces[row - 1][column - 1].color != this.color)
				moves.add(new Move(column, row, column - 1, row - 1));
		if (row < 7 && column < 7)
			if (chessBoard.spaces[row + 1][column + 1].color != this.color)
				moves.add(new Move(column, row, column + 1, row + 1));
		if (row < 7 && column > 0)
			if (chessBoard.spaces[row + 1][column - 1].color != this.color)
				moves.add(new Move(column, row, column - 1, row + 1));
		if (row < 7)
			if (chessBoard.spaces[row + 1][column].color != this.color)
				moves.add(new Move(column, row, column, row + 1));
		if (this.color == 1) {
			if (!this.moved & !chessBoard.spaces[0][0].moved)
					if (chessBoard.spaces[0][1].color == 0
					& chessBoard.spaces[0][2].color == 0)
				moves.add(new Move(column, row, 0, 0, true));
			if (!this.moved & !chessBoard.spaces[0][7].moved)
					if (chessBoard.spaces[0][4].color == 0
					& chessBoard.spaces[0][5].color == 0
					& chessBoard.spaces[0][6].color == 0)
				moves.add(new Move(column, row, 0, 7, true));
		}
		if (this.color == 2) {
			if (!this.moved & !chessBoard.spaces[7][0].moved)
					if (chessBoard.spaces[7][1].color == 0
					& chessBoard.spaces[7][2].color == 0
					& chessBoard.spaces[7][3].color == 0)
				moves.add(new Move(column, row, 7, 0, true));
			if (!this.moved & !chessBoard.spaces[7][7].moved)
					if (chessBoard.spaces[7][5].color == 0
					& chessBoard.spaces[7][6].color == 0)
				moves.add(new Move(column, row, 7, 7, true));
		}
		return moves;
	}
}
