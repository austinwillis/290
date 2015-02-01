import static org.junit.Assert.*;

import org.junit.Test;


public class testgame {

	@Test
	public void test() {
		Player p1 = new Player();
		p1.setCurrentRoom(new Room("StartingRoom"));
		assertEquals("StartingRoom", p1.getCurrentRoom().getRoomName());
		assertEquals("shortdescription", p1.getCurrentRoom().getShortdes());
		assertEquals("longdescription", p1.getCurrentRoom().getLongdes());
		assertEquals("lookdescription", p1.getCurrentRoom().getLookdes());
		assertEquals("name", p1.getCurrentRoom().getItems().get(0).getItemName());
		assertEquals("description", p1.getCurrentRoom().getItems().get(0).getDescription());
		assertEquals("required", p1.getCurrentRoom().getItems().get(0).getRequired());
		assertEquals("name", p1.getCurrentRoom().getActions().get(0).getActionName());
		assertEquals("description", p1.getCurrentRoom().getActions().get(0).getDescription());
		assertEquals("requires", p1.getCurrentRoom().getActions().get(0).getRequires());
		assertEquals("performs", p1.getCurrentRoom().getActions().get(0).getPerforms());
		p1.play();
	}

}
