
public class World {
	public static Room buildWorld() {
		Room dragon = new Room("DragonsLair");
		Room gate = new Room("MainGate");
		Room tavern = new Room("Tavern");
		Room market = new Room("Market");
		Room blacksmith = new Room("BlackSmith");
		Room range = new Room("ArcheryRange");
		Room sanctum = new Room("WizardSanctum");
		Room throne = new Room("ThroneRoom");
		Room knight = new Room("GuardHouse");
		Room dungeon = new Room("Dungeon");
		Room vault = new Room("RoyalVault");
		Room agartha = new Room("Agartha");
		
		gate.addExit('e', tavern);
		gate.addExit('s', dragon);
		gate.addExit('n', market);
		gate.addExit('w', knight);
		
		tavern.addExit('w', gate);
		
		dragon.addExit('n', gate);
		dragon.addExit('u', agartha);
		
		market.addExit('s', gate);
		market.addExit('e', blacksmith);
		market.addExit('w', range);
		market.addExit('u', sanctum);
		market.addExit('n', throne);
		
		knight.addExit('e', gate);
		knight.addExit('d', dungeon);
		
		agartha.addExit('d', throne);
		
		blacksmith.addExit('w', market);
		
		range.addExit('e', market);
		
		sanctum.addExit('d', market);
		
		throne.addExit('s', market);
		throne.addExit('d', vault);
		
		dungeon.addExit('u', knight);
		
		vault.addExit('u', throne);
		vault.setLock(true);
		
		// Gate Items / NPC
		NPC gateguard = new GateGuard("Guard", "A Royal Guard Guarding the Main Gate, Talk to him once you're Ready to Slay the Dragon and Save the Princess");
		Item tiara = new Item("Tiara", "The Tiara of Princess Maria, I Must Return it!");
		Item dull = new Item("DullSword", "An extremly Dull Sword, Totally NOT the Dragon Slaying Kind, Could be Fixed Up.");
		Item half = new Item("BurnedArmor", "Charred and Burned Unusable Knight Armor, NOT the Dragon Slyaing Kind, But Could be Fixed.");
		
		gate.addNPC(gateguard.getName(), gateguard);
		gate.addItem(tiara.getName(), tiara);
		gate.addItem(dull.getName(), dull);
		gate.addItem(half.getName(), half);
		// Tavern Items
		Item jack = new Item("BottleOfJack", "A bottle of 1987 All-American Whiskey. At Least Thats What the Wizard Says, America Doesn't Exist Here.");
		
		tavern.addItem(jack.getName(), jack);
		// Knights Quarters Items
		NPC guardguard = new GuardGuard("Guard", "A Royal Guard protcting the Royal Knights Quarters or simply the Guard House.");
		Item armor = new Item("RoyalArmor", "A Reliable, Sturdy, and Shiny Red and Gold Armor Made for the Royal Knights");
		
		knight.addNPC(guardguard.getName(), guardguard);
		knight.addItem(armor.getName(), armor);
		// Dungeon Items
		NPC dungeonguard = new DungeonGuard("Guard", "A Royal Guard posted up before the Dungeon.");
		Key vaultKey = new Key("VaultKey", "A Key to The Royal Vault!");
		
		dungeon.addNPC(dungeonguard.getName(), dungeonguard);
		dungeon.addItem(vaultKey.getName(), vaultKey);
		// Dragon Lair Items
		// Agartha Items
		// Market Items
		
		// No Items so far
		
		// Blacksmith Items
		// Archery Range Items
		// Wizard Sanctum Items
		// Throne Room Items
		VaultDoor vaultDoor = new VaultDoor("RoyalVaultDoor", "A Massive Vault Door With a Tungsten Carbide Hull, Titanium Alloy Hydroylics, Maraging Steel Interior, Graphene-Reinforced Composite Frame, and Ceramic-Metal Armored Plates." + "\n" + "...Unless You Have a Vault Key of Somesort, You Aint Ever Get in!");

		throne.addItem(vaultDoor.getName(), vaultDoor);
		// Vault Items
		
		return gate; // returns to starting gate
	}
}
