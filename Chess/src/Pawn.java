import java.util.HashSet;

public class Pawn extends Piece {

	
	public Pawn(int i, int j, int player) {
		super(i, j, player);
	}

	public int row;
	public int column;
	public int color;
	public boolean movable;
	public boolean moved;
	

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
				if (chessBoard.pieceat(column, row - 1).getcolor() == 0)
					moves.add(new Move(column, row, column, row - 1));
		if (row > 1)
			if (chessBoard.pieceat(row - 2, column).getcolor() == 0
					& chessBoard.pieceat(row - 2, column).getcolor() == 0
					& !this.moved) {
				moves.add(new Move(column, row, column, row - 2));
			}
		if (row > 0 & column < 7)
			if (chessBoard.pieceat(row - 1, column + 1).getcolor() != 0
					& chessBoard.pieceat(row - 1, column + 1).getcolor() != this.color)
				moves.add(new Move(column, row, column + 1, row - 1));
		if (row > 0 & column > 0)
			if (chessBoard.pieceat(row - 1, column - 1).getcolor() != 0
					& chessBoard.pieceat(row - 1, column - 1).getcolor() != this.color)
				moves.add(new Move(column, row, column - 1, row - 1));
		if (this.color == 2)
			if (row < 7)
				if (chessBoard.pieceat(row + 1, column).getcolor() == 0)
					moves.add(new Move(column, row, column, row + 1));
		if (row < 6)
			if (chessBoard.pieceat(row + 2, column).getcolor() == 0
					& chessBoard.pieceat(row + 1, column).getcolor() == 0
					& !this.moved) {
				moves.add(new Move(column, row, column, row + 2));
			}
		if (row < 7 & column < 7)
			if (chessBoard.pieceat(row + 1, column + 1).getcolor() == 1)
				moves.add(new Move(column, row, column + 1, row + 1));
		if (row < 7 & column > 0)
			if (chessBoard.pieceat(row + 1, column - 1).getcolor() == 1)
				moves.add(new Move(column, row, column - 1, row + 1));
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
