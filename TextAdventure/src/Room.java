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
	
	public Room(String string) {
	    File file = new File(string);

	    try {

	        Scanner sc = new Scanner(file);
	        this.readroomfile(sc);
	        sc.close();
	    }
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
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
		String[] tokens = buffer.split("[,]");
		if (tokens[0].equals("item")) {
			makeitem(tokens);
		}
		if(tokens[0].equals("action")) {
			makeaction(tokens);
		}
	}

	private void makeaction(String[] tokens) {
		this.actions = new ArrayList<Action>();
		this.actions.add(new Action(tokens[1], tokens[2], tokens[3], tokens[4]));
	}

	private void makeitem(String[] tokens) {
		this.items = new ArrayList<Item>();
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
}
