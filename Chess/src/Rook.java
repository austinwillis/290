import java.util.HashSet;

public class Rook extends Piece {

	public Rook(int j, int i, int j2) {
		super(j, i, j2);
	}

	public String toString() {
		if (color == 2) {
			return "R";
		} else
			return "r";
	}

	public HashSet<Move> addmoves(ChessBoard chessBoard) {
		HashSet<Move> moves = new HashSet<>();
		int newrow = row;
		int newcolumn = column;
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
