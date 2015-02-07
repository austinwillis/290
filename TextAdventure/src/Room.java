import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Room {
	private String RoomName;
	private String shortdes;
	private String longdes;
	private String lookdes;
	private ArrayList<Item> items;
	private ArrayList<Action> actions;
	private ArrayList<String> exits;
	
	public Room(String string) {
		this.actions = new ArrayList<Action>();
		this.items = new ArrayList<Item>();
		this.exits = new ArrayList<String>();
	    File file = new File(string + ".txt");

	    try {

	        Scanner sc = new Scanner(file);
	        this.readroomfile(sc);
	        sc.close();
	    }
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	        System.exit(1);
	    }
	}

	public ArrayList<String> getExits() {
		return exits;
	}

	public void setExits(ArrayList<String> exits) {
		this.exits = exits;
	}

	private void readroomfile(Scanner sc) {
		String buffer;
		this.RoomName = sc.nextLine();
		this.shortdes = sc.nextLine();
		this.longdes = sc.nextLine();
		this.lookdes = sc.nextLine();
		while(sc.hasNext()) {
			buffer = new String();
			buffer = sc.nextLine();
			parsestrings(buffer);
		}
	}

	public String getLookdes() {
		return lookdes;
	}

	public void setLookdes(String lookdes) {
		this.lookdes = lookdes;
	}

	private void parsestrings(String buffer) {
		String[] tokens = buffer.split("[|]");
		if (tokens[0].equals("item")) {
			makeitem(tokens);
		}
		if(tokens[0].equals("action")) {
			makeaction(tokens);
		}
		if(tokens[0].equals("exit")) {
			makeroom(tokens);
		}
	}

	private void makeroom(String[] tokens) {
		this.exits.add(tokens[1]);
	}

	private void makeaction(String[] tokens) {
		this.actions.add(new Action(tokens[1], tokens[2], tokens[3], tokens[4]));
	}

	private void makeitem(String[] tokens) {
		this.items.add(new Item(tokens[1], tokens[2], tokens[3]));
	}

	public String getRoomName() {
		return RoomName;
	}

	public void setRoomName(String roomName) {
		RoomName = roomName;
	}

	public String getShortdes() {
		return shortdes;
	}

	public void setShortdes(String shortdes) {
		this.shortdes = shortdes;
	}

	public String getLongdes() {
		return longdes;
	}

	public void setLongdes(String longdes) {
		this.longdes = longdes;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public ArrayList<Action> getActions() {
		return actions;
	}

	public void setActions(ArrayList<Action> actions) {
		this.actions = actions;
	}

	public boolean hasexit(String input) {
		for (String each : this.exits) {
			if (each.equals(input)) {
				return true;
			}
		}
		return false;
	}

	public void addexit(String temp) {
		this.exits.add(temp);
	}

	public boolean isaction(String input) {
		for (Action each : this.actions) {
			if (each.getActionName().equalsIgnoreCase(input)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasitem(String string) {
		for (Item each : this.items) {
			if (each.getItemName().equalsIgnoreCase(string)) {
				return true;
			}
		}
		return false;
	}
}
