import java.util.Scanner;

public class Game { 


	public static void main(String[] args) {
		Board board = new Board();
		int currentPlayer = 0;
		String s;
		Scanner in = new Scanner(System.in);
		boolean win = false;
		while (!win) {
			currentPlayer++;
			if(currentPlayer==3)
				currentPlayer = 1;
			System.out.println(board);
		
		boolean fail = false;
		int row = 0, column = 0;
		char rowchar;;
		fail = true;
		while (fail) {
			System.out.print("Player " + currentPlayer + "'s turn:");
				 s = in.next();
				 rowchar = s.charAt(0);
					Character.toUpperCase(rowchar);
					row = rowchar - 97;
					try {
						column = Integer.parseInt(s.substring(1, s.length())) - 1;
						} catch (NumberFormatException nfe) {
						  column = -1;
						}
					if (row < 11 && row > -1 && column < 11 && column > -1 && board.isSpaceOpen(column, row))
						fail = false;
					else System.out.println("That space is taken or is not in the board.");
		}
			 board.setSpace(column, row, currentPlayer);
			 if (checkwin(board, currentPlayer)) {
				 System.out.println(board);
				 System.out.println("Player " + currentPlayer + " wins!");
				 win = true;
			 }
			 
	}
		in.close();
	}
		private static boolean checkwin(Board board2, int currentPlayer1) {
			return board2.checkwin(currentPlayer1);
	}
	
}
