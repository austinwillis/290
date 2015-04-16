import java.util.ArrayList;


public class Piece {

		protected int row;
		protected int column;
		protected int color;
		boolean moved;
		
		public Piece() {
			color = 0;
		}
		
		public Piece(int i, int j) {
			color = 0;
			column = i;
			row = j;
		}
		
		public Piece(int j, int i, int player) {
			column = i;
			row = j;
			color = player;
			moved = false;
		}
		
		int getcolor() {
			return color;
		}
		
		
		public String toString() {
			return ".";
		}

		public ArrayList<Move> addmoves(ChessBoard chessBoard) {
			return null;
		}

		public void setmoved() {
			moved = true;
			
		}

}
