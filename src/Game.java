import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	public static void main(String[] args) {
		runGame();
	}

	public static ArrayList<Item> inventory = new ArrayList<Item>();

	public static void runGame() {
		Room currentRoom = World.buildWorld();
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
				currentRoom = currentRoom.getExit(command.charAt(0));
				break;

			// Take Command
			case "take":
				Item item = currentRoom.getItem(parts[1]);
				if (item != null) {
					inventory.add(item);
					currentRoom.removeItem(parts[1]);
					System.out.println("You Got a " + item.getName() + "!");
				} else {
					System.out.println("There is Nothing to Take Here.");
				}
				break;

			// Look Command
			case "look":
				Item thing = currentRoom.getItem(parts[1]);
				if (thing != null) {
					System.out.println(thing.getDescription());
				} else {
					for (Item itemName : inventory) {
						if (itemName.getName().equals(parts[1])) {
							System.out.println(itemName.getDescription());
						} else {
							System.out.println("There is Such Item");
						}
					}
				}
				break;

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
