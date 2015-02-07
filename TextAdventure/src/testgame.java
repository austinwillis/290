import static org.junit.Assert.*;

import org.junit.Test;


public class testgame {

	@Test
	public void test() {
		Player p1 = new Player();
		p1.setCurrentRoom(new Room("StartingRoom"));
		assertEquals("Cupboard", p1.getCurrentRoom().getRoomName());
		assertEquals("You need to get out of this cupboard and toast yourself.", p1.getCurrentRoom().getShortdes());
		assertEquals("That door looks too heavy for a bagel.~You may have to wait for someone to open the door.", p1.getCurrentRoom().getLongdes());
		assertEquals("You're in the cupboard. The door is closed and you need to get out.~Maybe we should wait on it to open.", p1.getCurrentRoom().getLookdes());
		assertEquals(0 , p1.getCurrentRoom().getItems().size());
		assertEquals("wait", p1.getCurrentRoom().getActions().get(0).getActionName());
		assertEquals("Someone came and opened the door! This is your chance to get out.\nYou rolled yourself out of the cupboard and onto the counter below.\n", p1.getCurrentRoom().getActions().get(0).getDescription());
		assertEquals("NA", p1.getCurrentRoom().getActions().get(0).getRequires());
		assertEquals("Room2", p1.getCurrentRoom().getActions().get(0).getPerforms());
		assertEquals("Someone came and opened the door! This is your chance to get out.\nYou rolled yourself out of the cupboard and onto the counter below.\n~Counter Top\nYou can see the toaster on the other half of the room.~You should be there in no time.", p1.play("wait"));
		assertEquals("I don't know what you meant.", p1.play("something"));
		assertEquals("~Counter Top", p1.getCurrentRoom().getRoomName());
		p1.setCurrentRoom(new Room("Sink"));
		assertEquals("chopstick", p1.getCurrentRoom().getItems().get(0).getItemName());
		assertEquals("chopstick", p1.getCurrentRoom().getActions().get(1).getRequires());	
	}
}
