import java.util.HashSet;

public class Bishop extends Piece {

	public Bishop(int i, int j, int k) {
		super(i, j, k);
	}

	public String toString() {
		if (color == 2) {
			return "B";
		} else
			return "b";
	}

	public HashSet<Move> addmoves(ChessBoard chessBoard) {
		HashSet<Move> moves = new HashSet<>();
		int newrow = row;
		int newcolumn = column;
		while (newrow < 7 && newcolumn < 7) {
			newrow ++;
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
		return moves;
	}

}
