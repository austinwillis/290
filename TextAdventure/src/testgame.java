import static org.junit.Assert.*;

import org.junit.Test;


public class testgame {

	@Test
	public void test() {
		Room start = new Room("StartingRoom");
		assertEquals("StartingRoom", start.getRoomName());
		assertEquals("shortdescription", start.getShortdes());
		assertEquals("longdescription", start.getLongdes());
		assertEquals("lookdescription", start.getLookdes());
		assertEquals("name", start.getItems().get(0).getItemName());
	}

}
