import java.util.ArrayList;

import javax.swing.text.BoxView;


public class Board {

	ArrayList<BoardPointBlob> p1lines = new ArrayList<BoardPointBlob>();
	ArrayList<BoardPointBlob> p2lines = new ArrayList<BoardPointBlob>();
	BoardPoint [][] spaces = new BoardPoint[11][11];

	public Board() {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				spaces[i][j] = new BoardPoint(i, j);
			}
		}
	}
	
	public String toString() {
		String output = "";
		for (int i = 0; i < 12; i++) {
				if (i > 0 && i < 12
						)
					output += i;
					if (i < 10)
				for (int x = 0; x < 13 - i; x++) {
					output += " ";
				}
					else for (int x = 0; x < 12 - i; x++) {
						output += " ";
					} 
				for (int j = 0; j < 13; j++) {
					if (i == 0)
						output += 'O';
					else if (j == 0 && i < 12|| j == 12 && i < 12)
						output += 'X';
					else if (i < 12)
						output += spaces[i-1][j-1].toString();
					if (j < 12) output += " ";
					else if (i < 12) output += "\n";
				}
		}
		output += "   O O O O O O O O O O O O O\n";
		output += "   A B C D E F G H I J K";
		return output;
	}

	void setSpace(int row, int column, int currentPlayer) {
		spaces[row][column] = new BoardPoint(row, column, currentPlayer);
		if (currentPlayer == 1)
		addtoLines(spaces[row][column], p1lines);
		else addtoLines(spaces[row][column], p2lines);
	}
	
	private void addtoLines(BoardPoint boardPoint,
			ArrayList<BoardPointBlob> PlayerLines) {
	if (boardPoint.column > 0)
		if (spaces[boardPoint.row][boardPoint.column - 1].line != null && boardPoint.player ==
				spaces[boardPoint.row][boardPoint.column - 1].player) {
			if (boardPoint.line == null) {
			boardPoint.line = spaces[boardPoint.row][boardPoint.column - 1].line;
			spaces[boardPoint.row][boardPoint.column - 1].line.addPoint(boardPoint);
		}
		else combinelines(boardPoint.line, spaces[boardPoint.row][boardPoint.column - 1].line, PlayerLines);
		}
	if (boardPoint.row > 0)
		if (spaces[boardPoint.row - 1][boardPoint.column].line != null && boardPoint.player ==
				spaces[boardPoint.row - 1][boardPoint.column].player) {
			if (boardPoint.line == null) {
			boardPoint.line = spaces[boardPoint.row-1][boardPoint.column].line;
			spaces[boardPoint.row-1][boardPoint.column].line.addPoint(boardPoint);
			}
			else combinelines(boardPoint.line, spaces[boardPoint.row - 1][boardPoint.column].line, PlayerLines);
		}
	if (boardPoint.column < 10 && boardPoint.row < 10)
		if (spaces[boardPoint.row + 1][boardPoint.column + 1].line != null && boardPoint.player ==
				spaces[boardPoint.row + 1][boardPoint.column + 1].player) {
			if (boardPoint.line == null) {
			boardPoint.line = spaces[boardPoint.row + 1][boardPoint.column + 1].line;
			spaces[boardPoint.row + 1][boardPoint.column + 1].line.addPoint(boardPoint);
			}
			else combinelines(boardPoint.line, spaces[boardPoint.row + 1][boardPoint.column + 1].line, PlayerLines);
		}
	if (boardPoint.column < 10)
		if (spaces[boardPoint.row][boardPoint.column + 1].line != null && boardPoint.player ==
				spaces[boardPoint.row][boardPoint.column + 1].player) {
			if (boardPoint.line == null) {
			boardPoint.line = spaces[boardPoint.row][boardPoint.column + 1].line;
			spaces[boardPoint.row][boardPoint.column + 1].line.addPoint(boardPoint);
		}
		else combinelines(boardPoint.line, spaces[boardPoint.row][boardPoint.column + 1].line, PlayerLines);
		}
	if (boardPoint.column > 0)
		if (spaces[boardPoint.row][boardPoint.column - 1].line != null && boardPoint.player ==
				spaces[boardPoint.row][boardPoint.column - 1].player) {
			if (boardPoint.line == null) {
			boardPoint.line = spaces[boardPoint.row][boardPoint.column - 1].line;
			spaces[boardPoint.row][boardPoint.column - 1].line.addPoint(boardPoint);
			}
			else combinelines(boardPoint.line, spaces[boardPoint.row][boardPoint.column - 1].line, PlayerLines);
		}
	if (boardPoint.column > 0 && boardPoint.row > 0)
		if (spaces[boardPoint.row - 1][boardPoint.column - 1].line != null && boardPoint.player ==
		spaces[boardPoint.row - 1][boardPoint.column - 1].player) {
			if (boardPoint.line == null) {
			boardPoint.line = spaces[boardPoint.row - 1][boardPoint.column - 1].line;
			spaces[boardPoint.row - 1][boardPoint.column - 1].line.addPoint(boardPoint);
		}
		else combinelines(boardPoint.line, spaces[boardPoint.row - 1][boardPoint.column - 1].line, PlayerLines);
		}
		if (boardPoint.line == null) {
			boardPoint.line = new BoardPointBlob();
			boardPoint.line.addPoint(boardPoint);
			PlayerLines.add(boardPoint.line);
		}
	}

	private void combinelines(BoardPointBlob line, BoardPointBlob line2, ArrayList<BoardPointBlob> PlayerLines) {
		line.points.addAll(line2.points);
		line2 = line;
		for (BoardPoint each : line.points) {
			each.line = line;
		}
		simplifyLines(PlayerLines);
	}
	
	private void simplifyLines(ArrayList<BoardPointBlob> playerLines) {
		for (BoardPointBlob line : playerLines) {
			line.simplify();
		}
	}

	boolean isSpaceOpen (int row, int column) {
		return (spaces[row][column].player == 0);
	}

	public boolean checkwin(int currentPlayer1) {
		if (currentPlayer1 == 1)
		for (BoardPointBlob each : p1lines) { 
			if (each.win(currentPlayer1))
				return true;
		}
		if (currentPlayer1 == 2)
			for (BoardPointBlob each : p2lines) { 
				if (each.win(currentPlayer1))
					return true;
			}
		return false;
	}
}
