import java.util.HashSet;

public class Game {

	public ChessBoard board;
	int player;
	boolean win;

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	HashSet<Move> moves;

	public Game() {
		board = new ChessBoard();
		player = 1;
		win = false;
	}

	public boolean rungame(String s) {
		Move m;
		ChessBoard testboard;
		testboard = board.clone();
		moves = board.generatemoves(player);
		moves = testboard.removebadmove(moves, player);
		m = parseinput(s);
		if (m != null && hasmove(m)) {
			board.performmove(m, player);
			board.checkpawns(player);
		} else {
			return false;
		}
		player = changeplayer(player);
		return true;
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
			Move m = new Move(new ChessLocation(inputrow, inputcolumn),
					new ChessLocation(outputrow, outputcolumn));
			return m;
		}
		return null;
	}
}
