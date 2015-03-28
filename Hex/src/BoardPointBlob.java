import java.util.ArrayList;


public class BoardPointBlob {

	ArrayList<BoardPoint> points = new ArrayList<BoardPoint>();

	public void addPoint(BoardPoint boardPoint) {
		points.add(boardPoint);
	}

	public boolean win(int currentPlayer1) {
		boolean left = false, right = false;
		if (currentPlayer1 == 1) {
			for (BoardPoint each : points) {
				if (each.column == 0)
					left = true;
				if (each.column == 10)
					right = true;
			}
		}
		if (currentPlayer1 == 2) {
			for (BoardPoint each : points) {
				if (each.row == 0) {
					left = true;
				}
				if (each.row == 10) {
					right = true;
				}
			}
		}
		if (left && right)
			return true;
		else return false;
	}

	public void simplify() {
		BoardPointBlob newLine = new BoardPointBlob();
		for (BoardPoint each : this.points) {
			if (!newLine.hasPoint(each))
				newLine.addPoint(each);
		}
		this.points = newLine.points;
	}

	private boolean hasPoint(BoardPoint check) {
		for (BoardPoint each : this.points)
			if (each.equals(check))
				return true;
		return false;
	}
	
}
