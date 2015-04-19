import java.util.HashSet;

public class Queen extends Piece {

	public Queen(int i, int j, int k) {
		super(i, j, k);
	}

	public String toString() {
		if (color == 2) {
			return "Q";
		} else
			return "q";
	}

	public HashSet<Move> addmoves(ChessBoard chessBoard) {
		HashSet<Move> moves = new HashSet<>();
		int newrow = row;
		int newcolumn = column;
		while (newrow < 7 && newcolumn < 7) {
			newrow++;
			newcolumn++;
			if (chessBoard.spaces[newrow][newcolumn].color != this.color) {
				moves.add(new Move(column, row, newcolumn, newrow));
			}
			if (chessBoard.spaces[newrow][newcolumn].color != 0)
				break;
		}
		newrow = row;
		newcolumn = column;
		while (newrow > 0 && newcolumn < 7) {
			newrow --;
			newcolumn++;
			if (chessBoard.spaces[newrow][newcolumn].color != this.color) {
				moves.add(new Move(column, row, newcolumn, newrow));
			}
			if (chessBoard.spaces[newrow][newcolumn].color != 0)
				break;
		}
		newrow = row;
		newcolumn = column;
		while (newrow > 0 && newcolumn > 0) {
			newrow --;
			newcolumn--;
			if (chessBoard.spaces[newrow][newcolumn].color != this.color) {
				moves.add(new Move(column, row, newcolumn, newrow));
			}
			if (chessBoard.spaces[newrow][newcolumn].color != 0)
				break;
		}
		newrow = row;
		newcolumn = column;
		while (newrow < 7 && newcolumn > 0) {
			newrow ++;
			newcolumn--;
			if (chessBoard.spaces[newrow][newcolumn].color != this.color) {
				moves.add(new Move(column, row, newcolumn, newrow));
			}
			if (chessBoard.spaces[newrow][newcolumn].color != 0)
				break;
		}
		newrow = row;
		newcolumn = column;
		while (newrow < 7) {
			newrow ++;
			if (chessBoard.spaces[newrow][newcolumn].color != this.color) {
				moves.add(new Move(column, row, newcolumn, newrow));
			}
			if (chessBoard.spaces[newrow][newcolumn].color != 0)
				break;
		}
		newrow = row;
		while (newrow > 0) {
			newrow --;
			if (chessBoard.spaces[newrow][newcolumn].color != this.color) {
				moves.add(new Move(column, row, newcolumn, newrow));
			}
			if (chessBoard.spaces[newrow][newcolumn].color != 0)
				break;
		}
		newrow = row;
		newcolumn = column;
		while (newcolumn > 0) {
			newcolumn--;
			if (chessBoard.spaces[newrow][newcolumn].color != this.color) {
				moves.add(new Move(column, row, newcolumn, newrow));
			}
			if (chessBoard.spaces[newrow][newcolumn].color != 0)
				break;
		}
		newcolumn = column;
		while (newcolumn < 7) {
			newcolumn++;
			if (chessBoard.spaces[newrow][newcolumn].color != this.color) {
				moves.add(new Move(column, row, newcolumn, newrow));
			}
			if (chessBoard.spaces[newrow][newcolumn].color != 0)
				break;
		}
		return moves;
	}
}
