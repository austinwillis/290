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
		Player2pieces.add(new King(8, 5));
		Player2pieces.add(new Queen(8, 4));
		for (int i = 1; i < 9; i++) {
			Player2pieces.add(new Pawn(7, i));
		}
	}

	public ChessBoard(HashSet<Piece> player1, HashSet<Piece> player2) {
		Player2pieces = new HashSet<>();
		Player1pieces = new HashSet<>();
		for (Piece each : player1) {
			Player1pieces.add(each.clone());
		}
		for (Piece each : player2) {
			Player2pieces.add(each.clone());
		}
	}

	public ChessBoard(ChessBoard board) {
		Player2pieces = new HashSet<>();
		Player1pieces = new HashSet<>();
		for (Piece each : board.Player1pieces) {
			Player1pieces.add(each.clone());
		}
		for (Piece each : board.Player2pieces) {
			Player1pieces.add(each.clone());
		}
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
				moves.addAll(each.generatemoves(this, player));
			}
		} else {
			for (Piece each : Player2pieces) {
				moves.addAll(each.generatemoves(this, player));
			}
		}
		return moves;

	}

	public HashSet<Move> removebadmove(HashSet<Move> moves, int player) {
		HashSet<Move> newmoves = new HashSet<>();
		for (Move each : moves)
			if (testmove(each, player))
				newmoves.add(each);
		return newmoves;
	}

	private boolean testmove(Move each, int player) {
		this.performmove(each, player);
		return !this.playerincheck(player);
	}

	public HashSet<Move> cancelcheck(int player) {
		return new HashSet<Move>();
	}

	public void performmove(Move m, int player) {
		if (m.castle) {
			if (m.endLoc.column - m.startLoc.column == 2) {
				this.performmove(new Move(m.startLoc, m.endLoc), player);
				this.performmove(new Move(new Location(m.startLoc.row,
						m.endLoc.column + 3), new Location(m.startLoc.row,
						m.endLoc.column + 1)), player);
			} else {
				if (m.endLoc.column - m.startLoc.column == -2) {
					this.performmove(new Move(m.startLoc, m.endLoc), player);
					this.performmove(new Move(new Location(m.startLoc.row,
							m.endLoc.column - 3), new Location(m.startLoc.row,
							m.endLoc.column - 1)), player);

				}
			}
		} else {
			if (player == 1) {
				if (player2pieceat(m.endLoc))
					removep2loc(m.endLoc);
				for (Piece each : Player1pieces) {
					if (each.L.toString().equals(m.startLoc.toString())) {
						each.setNewLocation(m.endLoc);
						each.setmoved();
					}
				}
			}
			if (player == 2) {
				if (player1pieceat(m.endLoc))
					removep1loc(m.endLoc);
				for (Piece each : Player2pieces) {
					if (each.L.toString().equals(m.startLoc.toString())) {
						each.setNewLocation(m.endLoc);
						each.setmoved();
					}
				}
			}
		}
	}

	private void removep1loc(Location endLoc) {
		for (java.util.Iterator<Piece> i = Player1pieces.iterator(); i
				.hasNext();) {
			Piece element = i.next();
			if (element.L.equals(endLoc)) {
				i.remove();
			}
		}
	}

	private void removep2loc(Location endLoc) {
		for (java.util.Iterator<Piece> i = Player2pieces.iterator(); i
				.hasNext();) {
			Piece element = i.next();
			if (element.L.toString().equals(endLoc.toString())) {
				i.remove();
			}
		}
	}

	public boolean checkwin(int player) {
		return (playerincheck(player) && generatemoves(player).size() == 0);
	}

	public boolean pieceat(Location location) {
		for (Piece each : Player1pieces) {
			if (each.L.toString().equals(location.toString()))
				return true;
		}
		for (Piece each : Player2pieces) {
			if (each.L.toString().equals(location.toString()))
				return true;
		}
		return false;
	}

	public boolean player2pieceat(Location location) {
		for (Piece each : Player2pieces) {
			if (each.L.toString().equals(location.toString()))
				return true;
		}
		return false;
	}

	public boolean player1pieceat(Location location) {
		for (Piece each : Player1pieces) {
			if (each.L.toString().equals(location.toString()))
				return true;
		}
		return false;
	}

	public boolean otherpieceat(Location location, int player) {
		if (player == 1)
			return player2pieceat(location);
		else
			return player1pieceat(location);
	}

	public boolean playerincheck(int player) {
		int p = changeplayer(player);
		HashSet<Move> moves = this.generatemoves(p);
		for (Move each : moves)
			if (this.otherpieceat(each.endLoc, p) && this.kingat(each.endLoc))
				return true;
		return false;
	}

	private boolean kingat(Location endLoc) {
		for (Piece each : Player1pieces) {
			if (each.L.toString().equals(endLoc.toString()) && each.isking())
				return true;
		}
		for (Piece each : Player2pieces) {
			if (each.L.toString().equals(endLoc.toString()) && each.isking())
				return true;
		}
		return false;
	}

	private int changeplayer(int player) {
		if (player == 2)
			return 1;
		else
			return 2;
	}

	public void checkpawns(int player) {
		for (Piece each : Player1pieces) {
			if (each.checkPawn())
				setQueen(each, player);
		}
		for (Piece each : Player2pieces) {
			if (each.checkPawn())
				setQueen(each, player);
		}
	}

	private void setQueen(Piece each, int player) {
		if (player == 1) {
			for (Piece e : Player1pieces) {
				if (e.L.toString().equals(each.L.toString()))
					Player1pieces.add(new Queen(each.L));
				Player1pieces.remove(each);
			}
		} else {
			for (Piece e : Player2pieces) {
				if (e.L.toString().equals(each.L.toString()))
					Player2pieces.add(new Queen(each.L));
				Player2pieces.remove(each);
			}
		}
	}

	public boolean movedpieceat(Location location) {
		for (Piece each : Player1pieces)
			if (each.L.toString().equals(location.toString()) && each.moved)
				return true;
		for (Piece each : Player2pieces)
			if (each.L.toString().equals(location.toString()) && each.moved)
				return true;
		return false;
	}

}
