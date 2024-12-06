import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {
	public static void main(String[] args) {
		readRoomDesc();
		print (currentRoom);
	}

	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static Room currentRoom = World.buildWorld();
	public static HashMap<String, String> rooms = new HashMap<>();
	public static Scanner input = new Scanner(System.in);
	public static GameGUI gui = new GameGUI();
	
	public Item useItem(String nameOfItem) {
		for (Item itemName : inventory) {
			if (itemName.getName().equals(nameOfItem)) {
				return itemName;
			}
			else {
				return null;
			}
		}
		return null;
	}
	
	public static void readRoomDesc() {
		try {
			File RoomsFile = new File("Rooms.txt");
			Scanner input = new Scanner(RoomsFile);
			ArrayList<String> stringRoomFile = new ArrayList<String>();
			
			while(input.hasNextLine()) {
				if(input.hasNext("#") != true) {
					String line = input.nextLine();
					stringRoomFile.add(line);
				}
				else {
					input.nextLine();
				}
			}
			for (int s = 0; s < stringRoomFile.size(); s += 2) {
				String roomName = stringRoomFile.get(s);
				String roomDesc = stringRoomFile.get(s+1);
				rooms.put(roomName, roomDesc);
			}
			input.close();
		} catch (FileNotFoundException e) {
			Game.print("File not Found!");
		}
	}
	
	public static void print(Object text) {
		gui.setAppendText(text.toString()+"\n");
	}
	
	public static void processCommand(String command) {
		
		String[] parts = command.split(" ");
		
		switch (parts[0]) {
		case "e":
		case "w":
		case "n":
		case "s":
		case "u":
		case "d":
			Room nextRoom = currentRoom.getExit(command.charAt(0));
			if (nextRoom == null) {
				print("You Cannot Go That Way.");
			} else if (nextRoom.isLock()) {
				print("This Way is Locked! Find a way to Unlock it!");
			} else {
				currentRoom = nextRoom;
				print (currentRoom);
			}
			break;

		// Take Command
		case "take":
			Item thing = currentRoom.getItem(parts[1]);
			if (thing != null) {
				inventory.add(thing);
				currentRoom.removeItem(parts[1]);
				print("You Got a " + thing.getName() + "!");
			} else {
				print("There is Nothing to Take Here.");
			}
			break;

		// Look Command
		case "look":
			Item things = currentRoom.getItem(parts[1]);
			if (things != null) {
				print(things.getDescription());
			} else {
				for (Item itemName : inventory) {
					if (itemName.getName().equals(parts[1])) {
						print(itemName.getDescription());
					} else {
						print("There is No Such Item");
					}
				}
			}
			break;
			
		// Use Command
		case "use":
			for (Item itemName : inventory) {
				if (itemName.getName().equals(parts[1])) {
					itemName.use();
				} 
			}
			break;
			
		// Open Command
		case "open":
			Item thing3 = currentRoom.getItem(parts[1]);
			if (thing3 != null) {
				thing3.open();
			}

		// Inventory Command
		case "i":
			if (inventory.isEmpty()) {
				print("You Are Carrying Nothing");
			} else {
				print("What You Are Carrying: ");
				for (Item invItem : inventory) {
					print("- " + invItem.getName());
				}
			}
			break;
			
		// Talk Command
		case "talk":
			NPC person = currentRoom.getNPC(parts[1]);
			if (person != null) {
				person.talk();
			}
			break;
			
		// End
		case "x":
			print("Congrats you Win!...or did you?");
			break;
		default:
			print("I Dont Understand That");
		}
	}

	public static void runGame() {

		String command; // player's command
		do {
			print(currentRoom);
			System.out.print("Where do you want to go? ");
			command = input.nextLine();
			String[] parts = command.split(" ");

			switch (parts[0]) {
			case "e":
			case "w":
			case "n":
			case "s":
			case "u":
			case "d":
				Room nextRoom = currentRoom.getExit(command.charAt(0));
				if (nextRoom == null) {
					print("You Cannot Go That Way.");
				} else if (nextRoom.isLock()) {
					print("This Way is Locked! Find a way to Unlock it!");
				} else {
					currentRoom = nextRoom;
				}
				break;

			// Take Command
			case "take":
				Item thing = currentRoom.getItem(parts[1]);
				if (thing != null) {
					inventory.add(thing);
					currentRoom.removeItem(parts[1]);
					print("You Got a " + thing.getName() + "!");
				} else {
					print("There is Nothing to Take Here.");
				}
				break;

			// Look Command
			case "look":
				Item things = currentRoom.getItem(parts[1]);
				if (things != null) {
					print(things.getDescription());
				} else {
					for (Item itemName : inventory) {
						if (itemName.getName().equals(parts[1])) {
							print(itemName.getDescription());
						} else {
							print("There is No Such Item");
						}
					}
				}
				break;
				
			// Use Command
			case "use":
				for (Item itemName : inventory) {
					if (itemName.getName().equals(parts[1])) {
						itemName.use();
					} 
				}
				break;
				
			// Open Command
			case "open":
				Item thing3 = currentRoom.getItem(parts[1]);
				if (thing3 != null) {
					thing3.open();
				}

			// Inventory Command
			case "i":
				if (inventory.isEmpty()) {
					print("You Are Carrying Nothing");
				} else {
					print("What You Are Carrying: ");
					for (Item invItem : inventory) {
						print("- " + invItem.getName());
					}
				}
				break;
				
			// Talk Command
			case "talk":
				NPC person = currentRoom.getNPC(parts[1]);
				if (person != null) {
					person.talk();
				}
				break;
			case "x":
				print("Congrats you Win!...or did you?");
				break;
			default:
				print("I Dont Understand That");
			}

		} while (!command.equals("x"));

		input.close();
	}
}
