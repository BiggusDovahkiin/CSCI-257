
public class Safe extends Item{
	
	public Safe(String name, String desc) {
		super(name,desc);
	}
	
	@Override
	public void open() {
		boolean openSafe = false;
		for (Item itemName : Game.inventory) {
			if (itemName.getName().equals("VaultKey")) {
				openSafe = true;
			}
		}
		if (openSafe) {
			Item Diamond = new Item("Diamond", "A Super Shiny Diamond!");
			Game.inventory.add(Diamond);
			Game.print("Using the Vault Key, You Open the Vault Door to Find a Very Shiny Diamond");
		}
		else {
			Game.print("You Found the Vault but it Appears you Have No Means to Open this Vault. It Looks Like you Need a Vault Key!"); }
	}

}
