import java.util.HashSet;

abstract class Piece {
	
	public int row;
	public int column;
	public int color;
	public boolean moved;
	
	public Piece(int i, int j, int player) {
		column = i;
		row = j;
		color = player;
	}
	
	public abstract boolean isking();

	abstract int getcolor();

	public abstract String toString();

	abstract HashSet<Move> addmoves(ChessBoard chessBoard);

	public void setmoved() {
		moved = true;
	}

	public void setNewLocation(Move m) {
		row = m.outputrow;
		column = m.outputcolumn;
	}
	
	public abstract boolean hasmoved();
	
	public abstract boolean Movable();

}
