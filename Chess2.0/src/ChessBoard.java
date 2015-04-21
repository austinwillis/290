import java.util.HashSet;

public class ChessBoard implements Cloneable {

	HashSet<Piece> Player1pieces = new HashSet<>();
	HashSet<Piece> Player2pieces = new HashSet<>();

	public ChessBoard() {
		Player1pieces.add(new Rook(1, 1));
		Player1pieces.add(new Rook(1, 8));
		Player1pieces.add(new Knight(1, 2));
		Player1pieces.add(new Knight(1, 7));
		Player1pieces.add(new Bishop(1, 3));
		Player1pieces.add(new Bishop(1, 6));
		Player1pieces.add(new King(1, 5));
		Player1pieces.add(new Queen(1, 4));
		for (int i = 1; i < 9; i++) {
			Player1pieces.add(new Pawn(2, i));
		}
		Player2pieces.add(new Rook(8, 1));
		Player2pieces.add(new Rook(8, 8));
		Player2pieces.add(new Knight(8, 2));
		Player2pieces.add(new Knight(8, 7));
		Player2pieces.add(new Bishop(8, 3));
		Player2pieces.add(new Bishop(8, 6));
		Player2pieces.add(new King(8, 4));
		Player2pieces.add(new Queen(8, 5));
		for (int i = 1; i < 9; i++) {
			Player2pieces.add(new Pawn(7, i));
		}
	}

	public ChessBoard(HashSet<Piece> player1, HashSet<Piece> player2) {
		Player2pieces = new HashSet<>();
		Player1pieces = new HashSet<>();
		Player2pieces = player2;
		Player1pieces = player1;
	}

	public ChessBoard clone() {
		return new ChessBoard(Player1pieces, Player2pieces);
	}

	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("");
		for (int i = 8; i > 0; i--) {
			for (int j = 1; j < 9; j++) {
				if (j == 1)
					output.append(i + "  ");
				output.append(this.printPiece(new Location(i, j)));
				if (j < 8)
					output.append("  ");
				else
					output.append("\n");
			}
		}

		output.append("   A  B  C  D  E  F  G  H");
		return output.toString();

	}

	private String printPiece(Location L) {
		for (Piece each : Player1pieces) {
			if (each.getlocation().toString().equals(L.toString())) {
				return each.toString();
			}
		}
		for (Piece each : Player2pieces) {
			if (each.getlocation().toString().equals(L.toString())) {
				return each.toString().toUpperCase();
			}
		}
		return ".";
	}

	public HashSet<Move> generatemoves(int player) {
		HashSet<Move> moves = new HashSet<>();
		if (player == 1) {
			for (Piece each : Player1pieces) {
				moves.addAll(each.generatemoves(this,
						player));
			}
		}
		else {
			for (Piece each : Player2pieces) {
				moves.addAll(each.generatemoves(this,
						player));
			}
		}
		return moves;

	}

	public HashSet<Move> cancelcheck(int player) {
		return new HashSet<Move>();
	}

	public void performmove(Move m, int player) {
		if (player == 1) {
			if (player2pieceat(m.endLoc))
				removep2loc(m.endLoc);
		for (Piece each : Player1pieces) {
			if (each.L.equals(m.startLoc)) {
				each.setNewLocation(m.endLoc);
				each.setmoved();
			}
		}
		}
		if (player == 2) {
			if (player1pieceat(m.endLoc))
				removep1loc(m.endLoc);
		for (Piece each : Player2pieces) {
			if (each.L.equals(m.startLoc)) {
				each.setNewLocation(m.endLoc);
				each.setmoved();
			}
		}
		}
	}

	private void removep1loc(Location endLoc) {
		for (java.util.Iterator<Piece> i = Player1pieces.iterator(); i.hasNext();) {
		    Piece element = i.next();
		    if (element.L.equals(endLoc)) {
		        i.remove();
		    }
		}
	}

	private void removep2loc(Location endLoc) {
		for (java.util.Iterator<Piece> i = Player2pieces.iterator(); i.hasNext();) {
		    Piece element = i.next();
		    if (element.L.equals(endLoc)) {
		        i.remove();
		    }
		}
	}

	public boolean checkwin(int player) {
		return false;
	}

	public boolean pieceat(Location location) {
		for (Piece each : Player1pieces) {
			if (each.L.equals(location))
				return true;
		}
		for (Piece each : Player2pieces) {
			if (each.L.equals(location))
				return true;
		}
		return false;
	}

	public boolean player2pieceat(Location location) {
		for (Piece each : Player2pieces) {
			if (each.L.equals(location))
				return true;
		}
		return false;
	}

	public boolean player1pieceat(Location location) {
		for (Piece each : Player1pieces) {
			if (each.L.equals(location))
				return true;
		}
		return false;
	}

}
