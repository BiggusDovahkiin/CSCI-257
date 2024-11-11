
public class VaultDoor extends Item{
	
	public VaultDoor(String name, String desc) {
		super(name,desc);
	}
	
	@Override
	public void open() {
		boolean openDoor = false;
		for (Item itemName : Game.inventory) {
			if (itemName.getName().equals("VaultKey")) {
				openDoor = true;
			}
		}
		if (openDoor) {
			Item Diamond = new Item("Diamond", "A Super Shiny Diamond!");
			Game.inventory.add(Diamond);
			Game.print("Using the Vault Key, You Open the Vault Door to Find a Very Shiny Diamond");
		}
		else {
			Game.print("You Found the Vault but it Appears you Have No Means to Open this Vault. It Looks Like you Need a Vault Key!"); }
	}

}
