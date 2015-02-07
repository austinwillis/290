import java.util.ArrayList;


public class Player {
	private Room currentRoom;
	private ArrayList<Item> items;
	boolean GameOver;
	boolean Lose;

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
		if (input.equalsIgnoreCase("i")) {
			if (this.items.size() < 1) {
				return "Your inventory is empty";
			}
			return "You have " + printinventory();
		}
		if (input.equalsIgnoreCase("stop")) {
			this.GameOver = true;
			return "Are you sure you want to quit? (Y/N)";
		}
		if (input.equalsIgnoreCase("look")) {
			return this.currentRoom.getLookdes();
		}
		if (input.equalsIgnoreCase("help")) {
			return "\n" + this.currentRoom.getRoomName() + "\n" + this.currentRoom.getLongdes() 
					+ "\n\n" + "Enter commands to explore the game.\nCommands you can use are "
							+ "\ngo to, get, use, look, help, get <item name>, i (inventory)"
							+ "\nand other actions available to certain rooms. \n\n"
							+ "If you wish to quit the game you can do so with the command stop.";
		}
		else if (checkactions(input)) {
			return performaction(input);
		}
		return longparse(input);
		}
	}

	private String printinventory() {
		String output = "";
		
		for (int i = 0; i < this.items.size(); i++) {
			if (i == 0) {
				output += items.get(i).getItemName();
			}
			else output += ", " + items.get(i).getItemName();
		}
		return output;
	}

	private boolean checkactions(String input) {
		return this.currentRoom.isaction(input);
	}

	private String performaction(String input) {
		Action action = null;
		for (Action each : this.getCurrentRoom().getActions()) {
			if (each.getActionName().equalsIgnoreCase(input)) {
				action = each;
			}
		}
		if (action != null) {
			if (action.getPerforms().equalsIgnoreCase("lose")) {
				this.GameOver = true;
				return action.getDescription() + "\nYou lost.\nWould you like to quit (Y/N)?";
			}
			if (action.getPerforms().equalsIgnoreCase("lose")) {
				this.currentRoom = new Room("StartingRoom");
				this.GameOver = true;
				return action.getDescription() + "\nYou won!\nWould you like to play again (Y/N)?";
			}
			if (action.getPerforms().equalsIgnoreCase("NA")) {
				return action.getDescription() + "\nYou won!\nWould you like to play again (Y/N)?";
			}
			if (this.hasitem(action.getRequires())) {
					this.setCurrentRoom(new Room(action.getPerforms()));
					return action.getDescription() + this.currentRoom.getRoomName() + "\n" 
					+ this.getCurrentRoom().getShortdes();
			}
			else return "You don't have the item needed for this action.";
		}
		return "This is not an action";
	}

	private boolean hasitem(String requires) {
		for (Item each : this.items) {
			if (each.getItemName().equalsIgnoreCase(requires)) {
				return true;
			}
		}
		return false;
	}

	private String longparse(String input) {
		String[] tokens = input.split("[ ]");
		if (tokens.length == 3) {
			if (tokens[0].equalsIgnoreCase("go") && tokens[1].equalsIgnoreCase("to")) {
				if (this.getCurrentRoom().hasexit(tokens[2])) {
					String temp = this.getCurrentRoom().getRoomName();
					this.setCurrentRoom(new Room(tokens[2]));
					this.getCurrentRoom().addexit(temp);
					return this.currentRoom.getRoomName() + "\n" + this.getCurrentRoom().getShortdes();
				}
			}
		}
		if (tokens.length == 2 && tokens[0].equalsIgnoreCase("get")) {
			if (this.getCurrentRoom().hasitem(tokens[1])) {
					return getitem(tokens[1]);
			}
			else return "That item isn't here.";
		}

		if (tokens.length == 2 && tokens[0].equalsIgnoreCase("drop")) {
			if (this.hasitem(tokens[1])) {
				for (Item each : this.items) {
					if (each.getItemName().equals(tokens[1])) {
						this.items.remove(each);
						return "You dropped " + tokens[1];
				}
					
			}
			}
		}
		return "I don't know what you meant.";
	}

	private String getitem(String string) {
		for (Item other : this.items) {
			if (other.getItemName().equals(string)) {
				return "You already have that.";
			}
		}
		for (Item each : this.getCurrentRoom().getItems()) {
			if (each.getItemName().equalsIgnoreCase(string)) {
				this.items.add(each);
				return "You got " + string + "\n" + each.getDescription();
			}
		}
		return "That item isn't here";
	}

}
