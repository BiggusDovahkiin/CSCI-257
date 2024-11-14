import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	public static void main(String[] args) {
		runGame();
	}

	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static Room currentRoom = World.buildWorld();
	
	
	public static void print(Object obj) {
		System.out.println(obj.toString());
		}
	
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

	public static void runGame() {
		Scanner input = new Scanner(System.in);

		String command; // player's command
		do {
			System.out.println(currentRoom);
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
					System.out.println("You Cannot Go That Way.");
				} else if (nextRoom.isLock()) {
					System.out.println("This door is locked. Find a Way to Unlock it!");
				} else {
					currentRoom = nextRoom;
				}
				break;

			// Take Command
			case "take":
				Item thing1 = currentRoom.getItem(parts[1]);
				if (thing1 != null) {
					inventory.add(thing1);
					currentRoom.removeItem(parts[1]);
					System.out.println("You Got a " + thing1.getName() + "!");
				} else {
					System.out.println("There is Nothing to Take Here.");
				}
				break;

			// Look Command
			case "look":
				Item thing2 = currentRoom.getItem(parts[1]);
				if (thing2 != null) {
					System.out.println(thing2.getDescription());
				} else {
					for (Item itemName : inventory) {
						if (itemName.getName().equals(parts[1])) {
							System.out.println(itemName.getDescription());
						} else {
							System.out.println("There is No Such Item");
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
					System.out.println("You Are Carrying Nothing");
				} else {
					System.out.println("What You Are Carrying: ");
					for (Item invItem : inventory) {
						System.out.println("- " + invItem.getName());
					}
				}
				break;
			case "x":
				System.out.println("Congrats you Win!...or did you?");
				break;
			default:
				System.out.println("I Dont Understand That");
			}

		} while (!command.equals("x"));

		input.close();
	}
}
