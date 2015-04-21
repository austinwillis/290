import java.util.HashSet;

abstract class Piece {

	public Location L;
	public boolean moved;

	public Piece(int i, int j) {
		L = new Location(i, j);
		moved = false;
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

	public abstract HashSet<Move> generatemoves(ChessBoard board, int player);

}
