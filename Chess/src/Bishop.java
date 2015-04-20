import java.util.HashSet;

public class Bishop extends Piece {

	public int row;
	public int column;
	public int color;
	public boolean moved;
	
	public Bishop(int i, int j, int k) {
		column = i;
		row = j;
		color = k;
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
			if (chessBoard.spaces[newrow][newcolumn].getcolor() != this.color) {
				moves.add(new Move(column, row, newcolumn, newrow));
			}
			if (chessBoard.spaces[newrow][newcolumn].getcolor() != 0)
				break;
		}
		newrow = row;
		newcolumn = column;
		while (newrow > 0 && newcolumn < 7) {
			newrow --;
			newcolumn++;
			if (chessBoard.spaces[newrow][newcolumn].getcolor() != this.color) {
				moves.add(new Move(column, row, newcolumn, newrow));
			}
			if (chessBoard.spaces[newrow][newcolumn].getcolor() != 0)
				break;
		}
		newrow = row;
		newcolumn = column;
		while (newrow > 0 && newcolumn > 0) {
			newrow --;
			newcolumn--;
			if (chessBoard.spaces[newrow][newcolumn].getcolor() != this.color) {
				moves.add(new Move(column, row, newcolumn, newrow));
			}
			if (chessBoard.spaces[newrow][newcolumn].getcolor() != 0)
				break;
		}
		newrow = row;
		newcolumn = column;
		while (newrow < 7 && newcolumn > 0) {
			newrow ++;
			newcolumn--;
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
