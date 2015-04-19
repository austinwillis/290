import java.util.HashSet;

public class ChessBoard implements Cloneable{

	Piece[][] spaces = new Piece[8][8];

	public ChessBoard() {
		spaces[0][0] = new Rook(0, 0, 2);
		spaces[0][7] = new Rook(7, 0, 2);
		spaces[0][1] = new Knight(1, 0, 2);
		spaces[0][6] = new Knight(6, 0, 2);
		spaces[0][2] = new Bishop(2, 0, 2);
		spaces[0][5] = new Bishop(5, 0, 2);
		spaces[0][4] = new King(4, 0, 2);
		spaces[0][3] = new Queen(3, 0, 2);
		for (int i = 0; i < 8; i++) {
			spaces[1][i] = new Pawn(i, 1, 2);
		}
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				spaces[i][j] = new Piece(j, i);
			}
		}
		spaces[7][0] = new Rook(0, 7, 1);
		spaces[7][7] = new Rook(7, 7, 1);
		spaces[7][1] = new Knight(1, 7, 1);
		spaces[7][6] = new Knight(6, 7, 1);
		spaces[7][2] = new Bishop(2, 7, 1);
		spaces[7][5] = new Bishop(5, 7, 1);
		spaces[7][4] = new King(3, 7, 1);
		spaces[7][3] = new Queen(4, 7, 1);
		for (int i = 0; i < 8; i++) {
			spaces[6][i] = new Pawn(i, 6, 1);
		}
	}
	
	public ChessBoard(Piece[][] spaces2) {
		for (int i = 0; i < 8; i++)
			for (int j =0; j < 8; j++)
				this.spaces[i][j] = spaces2[i][j];
	}

	public ChessBoard clone() {
		ChessBoard board = new ChessBoard(this.spaces);
		return board;
	}

	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (j == 0)
					output.append(i + 1 + "  ");
				output.append(spaces[i][j].toString());
				if (j < 7)
					output.append("  ");
				else
					output.append("\n");
			}
		}

		output.append("   A  B  C  D  E  F  G  H");
		return output.toString();

	}

	public boolean move(int player, Move m) {
		HashSet<Move> moves = new HashSet<Move>();
		moves.addAll(cancelcheck(player));
		if (hasmove(moves, m)) {
			this.performmove(m);
			System.out.println(this);
			return true;
		} else
			return false;

	}

	public void performmove(Move m) {
		if (m.castle) {

		} else {
			this.spaces[m.outputrow][m.outputcolumn] = this.spaces[m.inputrow][m.inputcolumn];
			this.spaces[m.outputrow][m.outputcolumn].setmoved();
			this.spaces[m.outputrow][m.outputcolumn].setNewLocation(m);
			this.spaces[m.inputrow][m.inputcolumn] = new Piece();
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
				if (this.spaces[i][j].color == player & this.spaces[i][j].color != 0) {
					moves.addAll(spaces[i][j].addmoves(this));
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
			test.performmove(each);
			if (test.check(p)) {
				
			} else
				newset.add(each);
		}
		return newset;
	}
	
	private int changeplayer(int player) {
		if (player % 2 == 0)
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
			if (spaces[each.outputrow][each.outputcolumn].color != player 
			& spaces[each.outputrow][each.outputcolumn].color != 0 & spaces[each.outputrow][each.outputcolumn].isking())
				return true;
		return false;
	}

}
