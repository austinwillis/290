import static org.junit.Assert.*;

import org.junit.Test;


public class HexGameTest {

	@Test
	public void test() {
		Board game = new Board();
		assertEquals(game.checkwin(2), false);
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				
				game.setSpace(j, i, 2);
		}
		}
		assertEquals(true, game.checkwin(2));
		Board game2 = new Board();
		for (int i = 0; i < 3; i++)
			game2.setSpace(i, 1, 2);
		for (int i = 2; i < 5; i++)
			game2.setSpace(i, 2, 2);
		for (int i = 5; i < 7; i++)
			game2.setSpace(i, 3, 2);
		for (int i = 7; i < 11; i++)
			game2.setSpace(i, 4, 2);
		assertEquals(true, game2.checkwin(2));
		Board game3 = new Board();
		for (int i = 0; i < 11; i++)
			game3.setSpace(1, i, 1);
		assertEquals(true, game3.checkwin(1));
	}
	
}
