
public class World {
	public static Room buildWorld() {
		Room dragon = new Room("This is the Lair of the Great Dragon, GoodLuck!");
		Room gate = new Room("This is the Main Gate of the Castle. The Dragon Awaits You Once You are Ready!");
		Room tavern = new Room("This is the Castle Tavern, Information and Drinks Await!");
		Room market = new Room("This is the Castle Market where you can Buy and Sell Goods!");
		Room blacksmith = new Room("This is the Castle Blacksmith, where Powerful Weapons are Made... Maybe even the Dragon Slaying kind?");
		Room range = new Room("This is where the Royal Archers are Trained and Supplied with Special Bows and Arrows! Maybe even the Dragon Slaying kind?");
		Room sanctum = new Room("This is where the Old Wizard lives. Some Weird stuff in here and lots of Magical Items... Maybe even the Dragon Slaying kind?");
		Room throne = new Room("The Throne Room of the Mighty King Barlgruuf the Greater and Queen Maven Black-Briar. Princess Maria's Throne sits empty");
		Room knight = new Room("This is where the Castle Knights live, the Castle Dungeon is below.");
		Room dungeon = new Room("The Dungeon, where the Scum Manage to stay Alive after Betraying our Great Kingdom");
		Room vault = new Room("The Royal Vault. Where the Royal Family keeps everything Royal... well Royal! Sure to be some Royaly Royal things of Royalty in here.");
		Room agartha = new Room("Welcome to Agartha. The Home of Dr. Monty, the True King and a God in his own right.");
		
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
		
		// Gate Items
		Item tiara = new Item("Tiara", "The Tiara of Princess Maria, I Must Return it!");
		Item dull = new Item("DullSword", "An extremly Dull Sword, Totally NOT the Dragon Slaying Kind, Could be Fixed Up.");
		Item half = new Item("BurnedArmor", "Charred and Burned Unusable Knight Armor, NOT the Dragon Slyaing Kind, But Could be Fixed.");
		
		gate.addItem(tiara.getName(), tiara);
		gate.addItem(dull.getName(), dull);
		gate.addItem(half.getName(), half);
		// Tavern Items
		Item jack = new Item("BottleOfJack", "A bottle of 1987 All-American Whiskey. At Least Thats What the Wizard Says, America Doesn't Exist Here.");
		
		tavern.addItem(jack.getName(), jack);
		// Knights Quarters Items
		Item armor = new Item("RoyalArmor", "A Reliable, Sturdy, and Shiny Golden Armor Made for the Royal Knights");
		
		knight.addItem(armor.getName(), armor);
		// Dungeon Items
		Combination vaultKey = new Combination("VaultKey", "A Key to The Royal Vault!");
		
		dungeon.addItem(vaultKey.getName(), vaultKey);
		// Dragon Lair Items
		// Agartha Items
		// Market Items
		// Blacksmith Items
		// Archery Range Items
		// Wizard Sanctum Items
		// Throne Room Items
		// Vault Items
		Safe royalVault = new Safe("RoyalVault", "The Vault That Contains all the Powerful and Valuable Findings of the Royal Family");
		
		vault.addItem(royalVault.getName(), royalVault);
		
		return gate; // returns to starting gate
	}
}
