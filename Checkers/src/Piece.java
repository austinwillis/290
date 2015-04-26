import java.util.ArrayList;


public class Piece {
	
		private static final int BOARDSIZE = 8;
		protected int row;
		protected int column;
		protected int color;
		protected boolean king;
		
		public Piece(int outputcolumn, int outputrow, int i, boolean k) {
			this(outputcolumn, outputrow, i);
			king = k;
		}
		
		public Piece(int i, int j, int k) {
			color = k;
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
			Character output = null;
			if (color == 0)
				output = '.';
			if (color == 1)
				output = 'x';
			if (color == 2)
				output = 'o';
			if (king)
				output = Character.toUpperCase(output);
			return new String() + output;
		}

		public void setKing() {
			king = true;
		}

		public ArrayList<Move> addmoves(CheckerBoard checkerBoard) {
			ArrayList<Move> moves = new ArrayList<>();
			if (this.color == 0) {
				return moves;
			}
			if (king || color == 1) {
				if (this.column > 0 && this.row > 0 && checkerBoard.spaces[this.row-1][this.column-1].color == 0)
					moves.add(new Move(this.column, this.row, this.column-1, this.row-1, false));
				if (this.column < BOARDSIZE - 1 && this.row > 0 && checkerBoard.spaces[this.row-1][this.column+1].color == 0)
					moves.add(new Move(this.column, this.row, this.column+1, this.row-1, false));
				if (this.column > 1 && this.row > 1 && !(checkerBoard.spaces[this.row-1][this.column-1].color == this.color) && !(checkerBoard.spaces[this.row-1][this.column-1].color == 0) && checkerBoard.spaces[this.row-2][this.column-2].color == 0)
					moves.add(new Move(this.column, this.row, this.column-2, this.row-2, true));
				if (this.column < BOARDSIZE - 2 && this.row > 1 && !(checkerBoard.spaces[this.row-1][this.column+1].color == this.color) && !(checkerBoard.spaces[this.row-1][this.column+1].color == 0) && checkerBoard.spaces[this.row-2][this.column+2].color == 0)
					moves.add(new Move(this.column, this.row, this.column+2, this.row-2, true));
			}
			if (king || color == 2) {
				if (this.column < BOARDSIZE - 1 && this.row < BOARDSIZE - 1 && checkerBoard.spaces[this.row+1][this.column+1].color == 0)
					moves.add(new Move(this.column, this.row, this.column+1, this.row+1, false));
				if (this.column > 0 && this.row < BOARDSIZE - 1 && checkerBoard.spaces[this.row+1][this.column-1].color == 0)
					moves.add(new Move(this.column, this.row, this.column-1, this.row+1, false));
				if (this.column > 1 && this.row < BOARDSIZE - 2 && !(checkerBoard.spaces[this.row+1][this.column-1].color == this.color) && !(checkerBoard.spaces[this.row+1][this.column-1].color == 0) && checkerBoard.spaces[this.row+2][this.column-2].color == 0)
					moves.add(new Move(this.column, this.row, this.column-2, this.row+2, true));
				if (this.column < BOARDSIZE - 2 && this.row < BOARDSIZE - 2 && !(checkerBoard.spaces[this.row+1][this.column+1].color == this.color) && !(checkerBoard.spaces[this.row+1][this.column+1].color == 0) && checkerBoard.spaces[this.row+2][this.column+2].color == 0)
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
				if (this.row == BOARDSIZE - 1)
					this.setKing();
		}
}
