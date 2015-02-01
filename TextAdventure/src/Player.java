import java.util.ArrayList;
import java.util.Scanner;


public class Player {
	private Room currentRoom;
	private ArrayList<Item> items;
	boolean GameOver;
	
	Player() {
		this.currentRoom = new Room("StartingRoom");
		this.items = new ArrayList<Item>();
		this.GameOver = false;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	void play() {
		while(!this.GameOver) {
			Scanner in = new Scanner(System.in);
			String input = in.nextLine();
			parseinput(input);
		}
	}

	private void parseinput(String input) {
		if (input.equalsIgnoreCase("stop")) {
			this.GameOver = true;
		}
	}
}
