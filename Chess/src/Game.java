import java.util.Scanner;

public class Game {

	private ChessBoard board;
	
	private Game() {
		board = new ChessBoard();
	}
	
	public static void main(String args[])  {
		Game g = new Game();
		g.rungame();
	}
	
	private void rungame() {
		System.out.println("Welcome to Chess.");
		System.out.println("Example move: a4-b5");
		int currentPlayer = 1;
		String s = null;
		ChessBoard boardstate = new ChessBoard();
		Scanner in = new Scanner(System.in);
		int inputrow = 0, inputcolumn = 0, outputrow = 0, outputcolumn = 0;

		boolean win = false;
		while (!win) {
			boardstate = board;
			boolean inputfail = true;
			while (inputfail) {
				System.out.println(board);
				System.out.print("Player " + currentPlayer + "'s turn:");
				s = in.nextLine();
				if (s.equals("help")) {
					for (Move each : boardstate.cancelcheck(currentPlayer)) {
						System.out.println(each);
					}
				} else {
				if (parseinput(currentPlayer, s, inputrow, inputcolumn,
						outputrow, outputcolumn, boardstate, in)) {
					inputfail = false;
					board = boardstate;
				}
				else {
					for (Move each : boardstate.cancelcheck(currentPlayer)) {
						System.out.println(each);
					}
					System.out.println("Not a legal move. Try again: ");
				}
				s = new String();
				}
			}
			currentPlayer = changeplayer(currentPlayer);
			
			win = board.checkwin(currentPlayer);
			if (board.check(currentPlayer))
				System.out.println("Check!");
			if (win) {
				System.out.println("Player " + currentPlayer + " wins!");
				System.out.println("Player " + currentPlayer + " wins!");
				win = true;
			}
		}
		in.close();
	}

	private boolean parseinput(int currentPlayer, String s,
			int inputrow, int inputcolumn, int outputrow, int outputcolumn,
			ChessBoard board, Scanner in) {
		String[] chars = s.split("-");
		for (int i = 0; i < chars.length; i++)
			if (chars.length != 2) {
				return false;
			} else {
				String input = chars[0];
				char inputrowchar = input.charAt(0);
				inputrowchar = Character.toLowerCase(inputrowchar);
				inputcolumn = inputrowchar - 97;

				try {
					inputrow = 8 - Integer.parseInt(chars[0].substring(1,
							input.length()));
				} catch (NumberFormatException nfe) {
					inputrow = -1;
				}

				input = chars[1];
				inputrowchar = input.charAt(0);
				inputrowchar = Character.toLowerCase(inputrowchar);
				outputcolumn = inputrowchar - 97;

				try {
					outputrow = 8 - Integer.parseInt(chars[1].substring(1,
							input.length()));
				} catch (NumberFormatException nfe) {
					outputrow = -1;
				}
			}
		if (inputrow < 8 && inputrow > -1 && inputcolumn < 8
				&& inputcolumn > -1 && outputrow < 8 && outputrow > -1
				&& outputcolumn < 8 && outputcolumn > -1) {
			Move m = new Move(inputcolumn, inputrow, outputcolumn, outputrow);
			System.out.println(m);
			if (board.move(currentPlayer, m)) {
				return true;
			}
		}
		return false;
	}
	
	public int changeplayer(int p) {
		if (p == 1)
			return 2;
		else
			return 1;
	}
}
