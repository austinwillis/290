import java.io.StringWriter;
import java.util.ArrayList;
import java.util.stream.Stream;


public class ChessBoard {

Piece [][] spaces = new Piece[8][8];
	
	public ChessBoard() {
		spaces[0][0] = new Rook(0, 0, 2);
		spaces[0][7] = new Rook(7, 0, 2);
		spaces[0][1] = new Knight(1, 0, 2);
		spaces[0][6] = new Knight(6, 0, 2);
		spaces[0][2] = new Bishop(2, 0, 2);
		spaces[0][5] = new Bishop(5, 0, 2);
		spaces[0][3] = new King(3, 0, 2);
		spaces[0][4] = new Queen(4, 0, 2);
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
		spaces[7][3] = new King(4, 7, 1);
		spaces[7][4] = new Queen(3, 7, 1);
		for (int i = 0; i < 8; i++) {
			spaces[6][i] = new Pawn(i, 6, 1);
		}
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
					else output.append("\n");
				}
		}
		
		output.append("   A  B  C  D  E  F  G  H");
		return output.toString();

	
}


	public boolean move(int player, Move m) {
		ArrayList<Move> moves = new ArrayList<Move>(); 
		this.generatemoves(player);
		if (hasmove(moves, m)) {
		System.out.println("");
		System.out.println(this);
		return true;
		}
		else return false;
		
	}


	private boolean hasmove(ArrayList<Move> moves, Move m) {
		for (Move each: moves) {
			if (m.equals(each)) {
				return true;
			}
		}
		return false;
	}


	private ArrayList<Move> generatemoves(int player) {
		ArrayList<Move> moves = new ArrayList<Move>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.spaces[i][j].color == player) {
					moves.addAll(spaces[i][j].addmoves(this));
				}
			}
		}
		return moves;
		
	}


	public boolean checkwin(int currentPlayer) {
		boolean win = false;
		return win;
	}

	
}
