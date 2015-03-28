import java.util.ArrayList;


public class Piece {

		protected int row;
		protected int column;
		protected int color;
		protected boolean king;
		
		public Piece() {
			color = 0;
			king = false;
		}
		
		public Piece(int i, int j) {
			color = 0;
			king = false;
			column = i;
			row = j;
		}
		
		int getcolor() {
			return color;
		}
		
		boolean isking() {
			return king;
		}
		
		public String toString() {
			return ".";
		}

		public void setKing() {
			king = true;
		}

		public ArrayList<Move> addmoves(CheckerBoard checkerBoard) {
			ArrayList<Move> moves = new ArrayList<>();
			if (this.color == 0) {
				return moves;
			}
			else if (this.color == 1 || this.king) {
				if (this.column > 0 && this.row > 0 && checkerBoard.spaces[this.row-1][this.column-1].color == 0)
					moves.add(new Move(this.column, this.row, this.column-1, this.row-1, false));
				if (this.column < 7 && this.row > 0 && checkerBoard.spaces[this.row-1][this.column+1].color == 0)
					moves.add(new Move(this.column, this.row, this.column+1, this.row-1, false));
				if (this.column > 1 && this.row > 1 && !(checkerBoard.spaces[this.row-1][this.column-1].color == this.color) && !(checkerBoard.spaces[this.row-1][this.column-1].color == 0) && checkerBoard.spaces[this.row-2][this.column-2].color == 0)
					moves.add(new Move(this.column, this.row, this.column-2, this.row-2, true));
				if (this.column < 6 && this.row > 1 && !(checkerBoard.spaces[this.row-1][this.column+1].color == this.color) && !(checkerBoard.spaces[this.row-1][this.column+1].color == 0) && checkerBoard.spaces[this.row-2][this.column+2].color == 0)
					moves.add(new Move(this.column, this.row, this.column+2, this.row-2, true));
			}
			else if (this.color == 2 || this.king) {
				if (this.column < 7 && this.row < 7 && checkerBoard.spaces[this.row+1][this.column+1].color == 0)
					moves.add(new Move(this.column, this.row, this.column+1, this.row+1, false));
				if (this.column > 0 && this.row < 7 && checkerBoard.spaces[this.row+1][this.column-1].color == 0)
					moves.add(new Move(this.column, this.row, this.column-1, this.row+1, false));
				if (this.column > 1 && this.row < 6 && !(checkerBoard.spaces[this.row+1][this.column-1].color == this.color) && !(checkerBoard.spaces[this.row+1][this.column-1].color == 0) && checkerBoard.spaces[this.row+2][this.column-2].color == 0)
					moves.add(new Move(this.column, this.row, this.column-2, this.row+2, true));
				if (this.column < 6 && this.row < 6 && !(checkerBoard.spaces[this.row+1][this.column+1].color == this.color) && !(checkerBoard.spaces[this.row+1][this.column+1].color == 0) && checkerBoard.spaces[this.row+2][this.column+2].color == 0)
					moves.add(new Move(this.column, this.row, this.column+2, this.row+2, true));
			
			}
			return moves;
		}

		public void checkking() {
			if (this.color == 1) {
				if (this.row == 0)
					this.setKing();
			}
			else
				if (this.row == 7)
					this.setKing();
		}
}
