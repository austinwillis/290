import static org.junit.Assert.*;

import org.junit.Test;


public class testgame {

	@Test
	public void test() {
		Player p1 = new Player();
		p1.setCurrentRoom(new Room("StartingRoom"));
		assertEquals("StartingRoom", p1.getCurrentRoom().getRoomName());
		assertEquals("The game has started.", p1.getCurrentRoom().getShortdes());
		assertEquals("This is the start of the game.", p1.getCurrentRoom().getLongdes());
		assertEquals("Try going to Room2.", p1.getCurrentRoom().getLookdes());
		assertEquals("name", p1.getCurrentRoom().getItems().get(0).getItemName());
		assertEquals("description", p1.getCurrentRoom().getItems().get(0).getDescription());
		assertEquals("required", p1.getCurrentRoom().getItems().get(0).getRequired());
		assertEquals("name", p1.getCurrentRoom().getActions().get(0).getActionName());
		assertEquals("description", p1.getCurrentRoom().getActions().get(0).getDescription());
		assertEquals("requires", p1.getCurrentRoom().getActions().get(0).getRequires());
		assertEquals("performs", p1.getCurrentRoom().getActions().get(0).getPerforms());
		assertEquals("Try going to Room2.", p1.play("look"));
		assertEquals("Room2\nThis is the second room.", p1.play("go to Room2"));
		assertEquals("Room2", p1.getCurrentRoom().getRoomName());
		
	}

}
