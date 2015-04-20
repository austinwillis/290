import java.util.HashSet;

public class King extends Piece {

	public int row;
	public int column;
	public int color;
	public boolean movable;
	public boolean moved;
	
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
		if (color == 0) {
			
		}
		HashSet<Move> moves = new HashSet<Move>();
		if (row > 0)
			if (chessBoard.pieceat(row - 1, column).getcolor() != this.color)
				moves.add(new Move(column, row, column, row - 1));
		if (row > 0 && column < 7)
			if (chessBoard.pieceat(row - 1, column + 1).getcolor() != this.color)
				moves.add(new Move(column, row, column + 1, row - 1));
		if (row > 0 && column > 0)
			if (chessBoard.pieceat(row - 1, column - 1).getcolor() != this.color)
				moves.add(new Move(column, row, column - 1, row - 1));
		if (row < 7 && column < 7)
			if (chessBoard.pieceat(row + 1, column + 1).getcolor() != this.color)
				moves.add(new Move(column, row, column + 1, row + 1));
		if (row < 7 && column > 0)
			if (chessBoard.pieceat(row + 1, column - 1).getcolor() != this.color)
				moves.add(new Move(column, row, column - 1, row + 1));
		if (row < 7)
			if (chessBoard.pieceat(row + 1, column).getcolor() != this.color)
				moves.add(new Move(column, row, column, row + 1));
		if (this.color == 1) {
			if (!this.moved & !chessBoard.pieceat(0, 0).hasmoved())
					if (chessBoard.pieceat(0, 1).getcolor() == 0
					& chessBoard.pieceat(0, 2).getcolor() == 0)
				moves.add(new Move(column, row, 0, 0, true));
			if (!this.moved & !chessBoard.pieceat(0, 7).hasmoved())
					if (chessBoard.pieceat(0, 4).getcolor() == 0
					& chessBoard.pieceat(0, 5).getcolor() == 0
					& chessBoard.pieceat(0, 6).getcolor() == 0)
				moves.add(new Move(column, row, 0, 7, true));
		}
		if (this.color == 2) {
			if (!this.moved & !chessBoard.pieceat(7, 0).hasmoved())
					if (chessBoard.pieceat(7, 1).getcolor() == 0
					& chessBoard.pieceat(7, 2).getcolor() == 0
					& chessBoard.pieceat(7, 3).getcolor() == 0)
				moves.add(new Move(column, row, 7, 0, true));
			if (!this.moved & !chessBoard.pieceat(7, 7).hasmoved())
					if (chessBoard.pieceat(7, 5).getcolor() == 0
					& chessBoard.pieceat(7, 6).getcolor() == 0)
				moves.add(new Move(column, row, 7, 7, true));
		}
		return moves;
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
	public boolean hasmoved() {
		return moved;
	}

	@Override
	public boolean Movable() {
		return movable;
	}
}
