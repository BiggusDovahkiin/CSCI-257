
public class VaultDoor extends Item{
	
	public VaultDoor(String name, String desc) {
		super(name,desc);
	}
	
	@Override
	public void open() {
		boolean hasKey = false;
		for (Item itemName : Game.inventory) {
			if (itemName.getName().equals("VaultKey")) {
				hasKey = true;
			}
		}
		
		if (hasKey) {
			Room vaultRoom = Game.currentRoom.getExit('d');
			if (vaultRoom != null && vaultRoom.isLock()) {
				vaultRoom.setLock(false);  // Unlock the room
				Game.print("You use the Vault Key to open the Vault Door. The Vault is Now Unlocked!");
			} else {
				Game.print("The Vault is already unlocked.");
			}
		} else {
			Game.print("You don't have the key to open this door.");
		}
	}
}
