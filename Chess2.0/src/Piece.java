import java.util.HashSet;

abstract class Piece implements Cloneable {

	public Location L;
	public boolean moved;

	public Piece(int i, int j) {
		L = new Location(i, j);
		moved = false;
	}

	public Piece(Location l) {
		this(l.row, l.column);
	}

	boolean equals(Piece P) {
		return (this.L.toString().equals(L.toString()));
	}

	public boolean isking() {
		return false;
	}

	public abstract String toString();

	public void setmoved() {
		moved = true;
	}

	public void setNewLocation(Location L) {
		this.L = L;
	}

	public boolean hasmoved() {
		return moved;
	}

	public Object getlocation() {
		// TODO Auto-generated method stub
		return L;
	}

	abstract public Piece clone();

	public abstract HashSet<Move> generatemoves(ChessBoard board, int player);

	public boolean checkPawn() {
		return false;
	}

}
