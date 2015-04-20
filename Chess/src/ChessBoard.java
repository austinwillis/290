import java.util.HashSet;

public class ChessBoard implements Cloneable{

	HashSet<Piece> pieces = new HashSet<>();

	public ChessBoard() {
		pieces.add(new Rook(0, 0, 2));
		pieces.add(new Rook(7, 0, 2));
		pieces.add(new Knight(1, 0, 2));
		pieces.add(new Knight(6, 0, 2));
		pieces.add(new Bishop(2, 0, 2));
		pieces.add(new Bishop(5, 0, 2));
		pieces.add(new King(4, 0, 2));
		pieces.add(new Queen(3, 0, 2));
		for (int i = 0; i < 8; i++) {
			pieces.add(new Pawn(i, 6, 1));
		}
		pieces.add(new Rook(0, 7, 1));
		pieces.add(new Rook(7, 7, 1));
		pieces.add(new Knight(1, 7, 1));
		pieces.add(new Knight(6, 7, 1));
		pieces.add(new Bishop(2, 7, 1));
		pieces.add(new Bishop(5, 7, 1));
		pieces.add(new King(3, 7, 1));
		pieces.add(new Queen(4, 7, 1));
		for (int i = 0; i < 8; i++) {
			pieces.add(new Pawn(i, 6, 1));
		}
	}
	
	public ChessBoard(HashSet<Piece> spaces2) {
		pieces = new HashSet<>();
		pieces.addAll(spaces2);
	}

	public ChessBoard clone() {
		return new ChessBoard(pieces);
	}

	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (j == 0)
					output.append(8 - i + "  ");
				output.append(this.printPiece(i, j));
				if (j < 7)
					output.append("  ");
				else
					output.append("\n");
			}
		}

		output.append("   A  B  C  D  E  F  G  H");
		return output.toString();

	}

	private String printPiece(int i, int j) {
		for (Piece each : pieces) {
			if (each.row == i && each.column == j)
				return each.toString();
		}
		return ".";
	}

	public boolean move(int player, Move m) {
		HashSet<Move> moves = new HashSet<Move>();
		moves.addAll(cancelcheck(player));
		if (hasmove(moves, m)) {
			this.performmove(m);
			return true;
		} else
			return false;

	}

	public void performmove(Move m) {
		if (m.castle) {

		} else {
			if (this.pieceat(m.outputrow, m.outputcolumn) != null)
				pieces.remove(this.pieceat(m.outputrow,  m.outputcolumn));
			this.pieceat(m.inputcolumn, m.inputrow).setNewLocation(m);
			this.pieceat(m.inputcolumn, m.inputrow).setmoved();
		}
	}

	private boolean hasmove(HashSet<Move> moves, Move m) {
		for (Move each : moves) {
			if (m.equals(each)) {
				return true;
			}
		}
		return false;
	}

	public HashSet<Move> generatemoves(int player) {
		HashSet<Move> moves = new HashSet<Move>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.pieceat(j, i).getcolor() == player & this.pieceat(j, i).Movable()) {
					moves.addAll(this.pieceat(j, i).addmoves(this));
				}
			}
		}
		return moves;
	}
	
	public HashSet<Move> cancelcheck(int player) {
		HashSet<Move> moves = new HashSet<Move>();
		moves.addAll(this.generatemoves(player));
		int p = changeplayer(player);
		HashSet<Move> newset = new HashSet<>();
		for (Move each : moves) {
			ChessBoard test = this.clone();
			Move testmove = each.clone();
			test.performmove(testmove);
			if (test.check(p)) {
				
			} else
				newset.add(each);
		}
		return newset;
	}
	
	private int changeplayer(int player) {
		if (player == 1)
			return 2;
		else
			return 1;
}

	public boolean checkwin(int currentPlayer) {
		if (check(currentPlayer) & cancelcheck(changeplayer(currentPlayer)).size() == 0)
			return true;
		else return false;
	}

	public boolean check(int player) {
		HashSet<Move> mvs = this.generatemoves(player);
		for (Move each : mvs)
			if (this.pieceat(each.outputcolumn, each.outputrow).isking())
				return true;
		return false;
	}

	public Piece pieceat(int column, int i) {
		for (Piece each : pieces) {
			if (each.row == i && each.column == column) {
				return each;
			}
		}
		return null;
	}

}
