import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		System.out.println("Welcome to Chess.");
		System.out.println("Example move: a4-b5");
		ChessBoard board = new ChessBoard();
		System.out.println(board);
		int currentPlayer = 1;
		String s = null;
		Scanner in = new Scanner(System.in);
		int inputrow = 0, inputcolumn = 0, outputrow = 0, outputcolumn = 0;

		boolean win = false;
		while (!win) {
			System.out.print("Player " + currentPlayer + "'s turn:");
			boolean inputfail = true;
			while (inputfail) {
				s = in.nextLine();
				if (s.equals("help")) {
					for (Move each : board.cancelcheck(currentPlayer)) {
						System.out.println(each);
					}
				} else {
				if (parseinput(currentPlayer, s, inputrow, inputcolumn,
						outputrow, outputcolumn, board, in)) {
					inputfail = false;
				}
				else {
					for (Move each : board.cancelcheck(currentPlayer)) {
						System.out.println(each);
					}
					System.out.println("Not a legal move. Try agiain: ");
				}
				s = new String();
				}
			}
			currentPlayer = (currentPlayer + 1);
			currentPlayer = changeplayer(currentPlayer);
			
			win = board.checkwin(currentPlayer);
			if (board.check(currentPlayer))
				System.out.println("Check!");
			if (win) {
				System.out.println("Player " + currentPlayer + " wins!");
				System.out.println("Player " + currentPlayer + " wins!");
				break;
			}
		}
		in.close();
	}

	private static boolean parseinput(int currentPlayer, String s,
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
					inputrow = Integer.parseInt(chars[0].substring(1,
							input.length())) - 1;
				} catch (NumberFormatException nfe) {
					inputrow = -1;
				}

				input = chars[1];
				inputrowchar = input.charAt(0);
				inputrowchar = Character.toLowerCase(inputrowchar);
				outputcolumn = inputrowchar - 97;

				try {
					outputrow = Integer.parseInt(chars[1].substring(1,
							input.length())) - 1;
				} catch (NumberFormatException nfe) {
					outputrow = -1;
				}
			}
		if (inputrow < 8 && inputrow > -1 && inputcolumn < 8
				&& inputcolumn > -1 && outputrow < 8 && outputrow > -1
				&& outputcolumn < 8 && outputcolumn > -1) {
			Move m = new Move(inputcolumn, inputrow, outputcolumn, outputrow);
			if (board.move(currentPlayer, m)) {
				return true;
			}
		}
		return false;
	}
	
	public static int changeplayer(int p) {
		if (p % 2 == 0)
			return 2;
		else
			return 1;
	}
}
