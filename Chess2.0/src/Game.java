import java.util.HashSet;
import java.util.Scanner;

public class Game {

	public static void main(String args[]) {
		Game g = new Game();
		g.rungame();
	}

	public ChessBoard board;
	private int player;
	HashSet<Move> moves;

	public void rungame() {
		board = new ChessBoard();
		player = 1;
		boolean win = false;
		boolean input = false;
		String s = null;
		Scanner in = new Scanner(System.in);
		Move m;
		while (!win) {
			moves = board.generatemoves(player);
			while (!input) {
				System.out.println(board);
				System.out.print("Player " + player + "'s turn: ");
				s = in.nextLine();
				if (s.equals("help")) {
					for (Move each : moves)
						System.out.println(each);
				}
				m = parseinput(s);
				System.out.println(m);
				if (m != null && hasmove(m)) {
					input = true;
					board.performmove(m, player);
				} else {
					System.out.println("Not a legal move, try again.");
				}
			}
			input = false;
			if (board.checkwin(player)) {
				System.out.println("Checkmate!");
				System.out.println("Player " + player + " wins!");
				win = true;
			}
			player = changeplayer(player);
		}
		in.close();
	}

	private boolean hasmove(Move m) {
		for (Move each : moves) {
			if (each.equals(m))
				return true;
		}
		return false;
	}

	private int changeplayer(int p) {
		if (p == 2)
			return 1;
		else
			return 2;
	}

	private Move parseinput(String s) {
		int inputcolumn = 0;
		int inputrow = 0;
		int outputcolumn = 0;
		int outputrow = 0;
		String[] chars = s.split("-");
		for (int i = 0; i < chars.length; i++)
			if (chars.length != 2) {
				return null;
			} else {
				String input = chars[0];
				char inputrowchar = input.charAt(0);
				inputrowchar = Character.toLowerCase(inputrowchar);
				inputcolumn = inputrowchar - 96;

				try {
					inputrow = Integer.parseInt(chars[0].substring(1,
							input.length()));
				} catch (NumberFormatException nfe) {
					inputrow = -1;
				}

				input = chars[1];
				inputrowchar = input.charAt(0);
				inputrowchar = Character.toLowerCase(inputrowchar);
				outputcolumn = inputrowchar - 96;

				try {
					outputrow = Integer.parseInt(chars[1].substring(1,
							input.length()));
				} catch (NumberFormatException nfe) {
					outputrow = -1;
				}
			}
		if (inputrow < 9 && inputrow > 0 && inputcolumn < 9 && inputcolumn > 0
				&& outputrow < 9 && outputrow > 0 && outputcolumn < 9
				&& outputcolumn > 0) {
			Move m = new Move(new Location(inputrow, inputcolumn),
					new Location(outputrow, outputcolumn));
			return m;
		}
		return null;
	}
}
