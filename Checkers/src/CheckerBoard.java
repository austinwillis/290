import java.util.ArrayList;


public class CheckerBoard {
	
	private static final int BOARDSIZE = 8;
	Piece [][] spaces = new Piece[8][8];
	
	public CheckerBoard() {
		for (int i = 0; i < BOARDSIZE; i++) {
			for (int j = 0; j < BOARDSIZE; j++) {
				spaces[i][j] = new Piece(j, i, 0);
			}
		}
		for (int i = 0; i < BOARDSIZE; i++) {
			for (int j = 0; j < BOARDSIZE; j++) {
				if (i < 3) {
					if (j%2 != 0) {
						if (i%2 != 0)
							spaces[i][j] = new Piece(j, i, 2);
					}
					else
						if (i%2 == 0)
							spaces[i][j] = new Piece(j, i, 2);
				}
				if (i > 4) {
					if (j%2 == 0) {
						if (i%2 == 0)
							spaces[i][j] = new Piece(j, i, 1);
				}
					else
						if (i%2 != 0)
							spaces[i][j] = new Piece(j, i, 1);
			}
		}
	}
}
	
	
	public String toString() {
		String output = "";
		for (int i = 0; i < BOARDSIZE; i++) {
				for (int j = 0; j < BOARDSIZE; j++) {
					if (j == 0)
						output += 8 - i + "  ";
					output += spaces[i][j].toString();
					if (j < BOARDSIZE - 1)
						output += "  ";
					else output += "\n";
				}
		}
		
		output += "   A  B  C  D  E  F  G  H";
		return output;

	
}


	public boolean move(int player, Move m, boolean second) {
		ArrayList<Move> moves = new ArrayList<Move>();
		boolean k = spaces[m.inputrow][m.inputcolumn].isking();
		if (second) {
			moves = (spaces[m.inputrow][m.inputcolumn].addmoves(this));
			moves = checkjumps(moves);
		} else moves = this.generatemoves(player);
		if (hasmove(moves, m)) {
		if (m.jump) {
			if (player == 1)
				this.spaces[m.outputrow][m.outputcolumn] = new Piece(m.outputcolumn, m.outputrow, 1, k);
			else this.spaces[m.outputrow][m.outputcolumn] = new Piece(m.outputcolumn, m.outputrow, 2, k);
		this.spaces[m.inputrow][m.inputcolumn] = new Piece(m.inputcolumn, m.inputrow, 0);
		this.spaces[m.inputrow + (m.outputrow - m.inputrow) / 2][m.inputcolumn + (m.outputcolumn - m.inputcolumn) / 2] =
				new Piece(m.inputrow + (m.outputrow - m.inputrow) / 2, m.inputcolumn + (m.outputcolumn - m.inputcolumn) / 2, 0);
		} else { 
			if (player == 1)
				this.spaces[m.outputrow][m.outputcolumn] = new Piece(m.outputcolumn, m.outputrow, 1, k);
			else this.spaces[m.outputrow][m.outputcolumn] = new Piece(m.outputcolumn, m.outputrow, 2, k);
			this.spaces[m.inputrow][m.inputcolumn] = new Piece(m.inputcolumn, m.inputrow, 0);
		}
		this.spaces[m.outputrow][m.outputcolumn].checkking();
		System.out.println("");
		System.out.println(this);
		return true;
		}
		else return false;
		
	}


	private boolean hasmove(ArrayList<Move> moves, Move m) {
		moves = checkjumps(moves);
		for (Move each: moves) {
			if (m.equals(each)) {
				return true;
			}
		}
		return false;
	}


	private ArrayList<Move> checkjumps(ArrayList<Move> moves) {
		boolean jump = false;
		ArrayList<Move> newmoves = new ArrayList<Move>();
		for (Move each : moves)
			if (each.jump)
				jump = true;
		if (jump) {
			for (Move each : moves)
				if (each.jump)
					newmoves.add(each);
		}
		else newmoves = moves;
		return newmoves;
	}


	private ArrayList<Move> generatemoves(int player) {
		ArrayList<Move> moves = new ArrayList<Move>();
		for (int i = 0; i < BOARDSIZE; i++) {
			for (int j = 0; j < BOARDSIZE; j++) {
				if (this.spaces[i][j].color == player) {
					moves.addAll(spaces[i][j].addmoves(this));
				}
			}
		}
		return moves;
		
	}


	public boolean secondjump(Move m) {
		ArrayList<Move> moves = spaces[m.outputrow][m.outputcolumn].addmoves(this);
		for (Move each : moves)
			if (each.jump)
				return true;
		return false;
	}


	public boolean checkwin(int currentPlayer) {
		boolean win = true;
		for (int i = 0; i < BOARDSIZE; i++)
			for (int j = 0; j < BOARDSIZE; j++)
				if (spaces[i][j].color != 0 && spaces[i][j].color != currentPlayer)
					win = false;
		return win;
	}
}
