import java.util.ArrayList;


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
	
	String play(String input) {
			return parseinput(input);
	}

	private String parseinput(String input) {
		if (this.GameOver) {
			if (input.equalsIgnoreCase("y")) {
				return "END";
			}
			else if (input.equalsIgnoreCase("n")) {
				this.GameOver = false;
				return "Keep Playing.";
			}
			else return "Enter Y or N";
		}
		else {
		if (input.equalsIgnoreCase("stop")) {
			this.GameOver = true;
			return "Are you sure you want to quit? (Y/N)";
		}
		if (input.equalsIgnoreCase("look")) {
			return this.currentRoom.getLookdes();
		}
		if (input.equalsIgnoreCase("help")) {
			return "\n" + this.currentRoom.getRoomName() + "\n" + this.currentRoom.getLongdes() 
					+ "\n\n" + "Enter commands to explore the game.\nCommands you can use are go to, get, use, look, help, "
							+ "\nand other actions available to certain rooms. \n\n"
							+ "If you wish to quit the game you can do so with the command stop.";
		}
		else checkactions(input);
		return longparse(input);
		}
	}

	private void checkactions(String input) {
		// TODO Auto-generated method stub
		
	}

	private String longparse(String input) {
		String[] tokens = input.split("[ ]");
		if (tokens.length < 2) {
			return "I don't know what you meant.";
		}
		if (tokens.length > 2) {
			if (tokens[0].equalsIgnoreCase("go") && tokens[1].equalsIgnoreCase("to")) {
				if (this.getCurrentRoom().hasexit(tokens[2])) {
					Room temp = this.getCurrentRoom();
					this.setCurrentRoom(new Room(tokens[2]));
					this.getCurrentRoom().addexit(temp);
					return this.currentRoom.getRoomName() + "\n" + this.getCurrentRoom().getShortdes();
				}
			}
		}
		return "I don't know what you meant.";
	}

}
