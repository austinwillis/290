import java.util.HashSet;

public class Rook extends Piece {
	
	public int row;
	public int column;
	public int color;
	public boolean movable;
	public boolean moved;
	
	public Rook(int j, int i, int j2) {
		column = j;
		row = i;
		color = j2;
		movable = true;
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
			if (chessBoard.spaces[newrow][newcolumn].getcolor() != this.color) {
				moves.add(new Move(column, row, newcolumn, newrow));
			}
			if (chessBoard.spaces[newrow][newcolumn].getcolor() != 0)
				break;
		}
		newrow = row;
		while (newrow > 0) {
			newrow --;
			if (chessBoard.spaces[newrow][newcolumn].getcolor() != this.color) {
				moves.add(new Move(column, row, newcolumn, newrow));
			}
			if (chessBoard.spaces[newrow][newcolumn].getcolor() != 0)
				break;
		}
		newrow = row;
		newcolumn = column;
		while (newcolumn > 0) {
			newcolumn--;
			if (chessBoard.spaces[newrow][newcolumn].getcolor() != this.color) {
				moves.add(new Move(column, row, newcolumn, newrow));
			}
			if (chessBoard.spaces[newrow][newcolumn].getcolor() != 0)
				break;
		}
		newcolumn = column;
		while (newcolumn < 7) {
			newcolumn++;
			if (chessBoard.spaces[newrow][newcolumn].getcolor() != this.color) {
				moves.add(new Move(column, row, newcolumn, newrow));
			}
			if (chessBoard.spaces[newrow][newcolumn].getcolor() != 0)
				break;
		}
		return moves;
	}

	@Override
	public boolean isking() {
		return false;
	}

	@Override
	public int getcolor() {
		return color;
	}

	@Override
	public void setmoved() {
		moved = true;
	}

	@Override
	public void setNewLocation(Move m) {
		row = m.outputrow;
		column = m.outputcolumn;
	}
	
	@Override
	public boolean hasmoved() {
		return moved;
	}
	
	@Override
	public boolean Movable() {
		return movable;
	}

}
