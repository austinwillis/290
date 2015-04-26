import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		System.out.println("Welcome to Checkers.");
		System.out.println("Example move: a4-b5");
		CheckerBoard board = new CheckerBoard();
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
			if(parseinput(currentPlayer, s, inputrow, inputcolumn, outputrow, outputcolumn, board, in, false))
				inputfail = false;
			else {
				System.out.println("Not a legal move. Try again: ");
			}
			s = new String();
			}
			win = board.checkwin(currentPlayer);
			if (win)
				System.out.println("Player " + currentPlayer + " wins!");
			currentPlayer = (currentPlayer + 1);
			if (currentPlayer %2 == 0)
				currentPlayer = 2;
			else currentPlayer = 1;
		}
		in.close();
}

	private static boolean parseinput(int currentPlayer, String s, int inputrow, int inputcolumn,
			int outputrow, int outputcolumn, CheckerBoard board, Scanner in, boolean second) {
		String[] chars = s.split("-");
		for (int i = 0; i < chars.length; i++)
		if (chars.length != 2) {
			return false;
		}
		else {
			String input = chars[0];
			char inputrowchar = input.charAt(0);
			inputrowchar = Character.toLowerCase(inputrowchar);
			inputcolumn = (inputrowchar - 97);
			
			try {
				inputrow = 9 - Integer.parseInt(chars[0].substring(1, input.length())) - 1;
				} catch (NumberFormatException nfe) {
				  inputrow = -1;
				}
			
			input = chars[1];
			inputrowchar = input.charAt(0);
			inputrowchar = Character.toLowerCase(inputrowchar);
			outputcolumn = (inputrowchar - 97);
			
			try {
				outputrow = 9 - Integer.parseInt(chars[1].substring(1, input.length())) - 1;
				} catch (NumberFormatException nfe) {
				  outputrow = -1;
				}
		}
		if (inputrow < 8 && inputrow > -1 &&
				inputcolumn < 8 && inputcolumn > -1 &&
				outputrow < 8 && outputrow > -1 &&
				outputcolumn < 8 && outputcolumn > -1) {
			boolean jump;
		if (outputrow > inputrow + 1 || outputrow < inputrow - 1)
			jump = true;
		else jump = false;
		Move m = new Move(inputcolumn, inputrow, outputcolumn, outputrow, jump);
		if (board.move(currentPlayer, m, second)) {
			if (m.jump && board.secondjump(m))
				moveagain(currentPlayer, s, inputrow, inputcolumn, outputrow, outputcolumn, board, in);
			return true;
		}
		}
		return false;
	}

	private static void moveagain(int currentPlayer, String s, int inputrow, int inputcolumn, int outputrow, int outputcolumn, CheckerBoard board, Scanner in) {
		System.out.print("Another jump available, go again: ");
		boolean inputfail = true; 
		while (inputfail) {
			s = in.nextLine();
			if(parseinput(currentPlayer, s, inputrow, inputcolumn, outputrow, outputcolumn, board, in, true))
				inputfail = false;
			else {
				System.out.println("Not a legal move. Try agiain: ");
			}
		}
	}
}
