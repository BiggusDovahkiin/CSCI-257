
public class Item {
	
	private String name;
	private String description;
	
	public Item(String n, String d) {
		name = n;
		description = d;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
	
	public void open() {
		Game.print("You Can't Open That.");
	}
	
	public void use() {
		Game.print("You Can't Use That.");
	}
}
