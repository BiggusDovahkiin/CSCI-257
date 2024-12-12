
public class World {
	public static Room buildWorld() {
		Room dragon = new Room("DragonsLair");
		Room gate = new Room("MainGate");
		Room tavern = new Room("Tavern");
		Room market = new Room("Market");
		Room blacksmith = new Room("Blacksmith");
		Room range = new Room("Range");
		Room sanctum = new Room("WizardSanctum");
		Room throne = new Room("ThroneRoom");
		Room knight = new Room("GuardHouse");
		Room dungeon = new Room("Dungeon");
		Room vault = new Room("RoyalVault");
		Room agartha = new Room("Agartha");
		
		gate.addExit('e', tavern);
		gate.addExit('n', market);
		gate.addExit('w', knight);
		
		tavern.addExit('w', gate);
		
		dragon.addExit('u', agartha);
		
		market.addExit('s', gate);
		market.addExit('e', blacksmith);
		market.addExit('w', range);
		market.addExit('u', sanctum);
		market.addExit('n', throne);
		
		knight.addExit('e', gate);
		knight.addExit('d', dungeon);
		
		blacksmith.addExit('w', market);
		
		range.addExit('e', market);
		
		sanctum.addExit('d', market);
		
		throne.addExit('s', market);
		throne.addExit('d', vault);
		
		dungeon.addExit('u', knight);
		
		vault.addExit('u', throne);
		vault.setLock(true);
		
		// Gate Items / NPC
		NPC gateguard = new GateGuard("Guard", "A Royal Guard Guarding the Main Gate, Talk to him once you're Ready to Slay the Dragon and Save the Princess", dragon);
		
		gate.addNPC(gateguard.getName(), gateguard);
		// Tavern Items
		NPC bartender = new Bartender("Dave", "Dave the Bartender, been here for as long as anyone, the kind of guy you want in your corner.");
		Item jack = new Item("JackDaniels", "A bottle of 1987 All-American Whiskey. At Least Thats What the Wizard Says, America Doesn't Exist Here.");
		
		tavern.addNPC(bartender.getName(), bartender);
		tavern.addItem(jack.getName(), jack);
		// Knights Quarters Items
		NPC dungeonguard = new DungeonGuard("Guard", "The Guard guarding the dungeon.");
		
		knight.addNPC(dungeonguard.getName(), dungeonguard);
		// Dungeon Items
		Key vaultKey = new Key("VaultKey", "A Key to The Royal Vault!");
		
		dungeon.addItem(vaultKey.getName(), vaultKey);
		// Dragon Lair Items
		NPC dragonBoss = new Dragon("Dragon", "The son of the Dragon that took the current Queen", agartha);
		
		dragon.addNPC(dragonBoss.getName(), dragonBoss);
		// Agartha Items
		NPC shadowman = new ShadowMan("ShadowMan", "The one and only, Shadow Man, The one who controls it all.");
		
		agartha.addNPC(shadowman.getName(), shadowman);
		// Blacksmith Items
		NPC cooljack = new Jack("Jack", "The Castle Blacksmith, earned his place here by 100%ing Cool Math Game's Jacksmith game.");
		Item sword = new Item("Dragonblade", "When activated, it channels the power of the dragon, significantly enhancing the wielder's speed and lethality for a short period.");
		
		blacksmith.addNPC(cooljack.getName(), cooljack);
		blacksmith.addItem(sword.getName(), sword);
		// Archery Range Items
		NPC mark = new Mark("Mark", "Mark the Marksmen won his place by missing the apple from a tree. This is because he was aiming for a bird which he also didnt hit");
		Item bow = new Item("Pinak", "A bow made by and for a god. AKA, a simple 50 lbs Bow");
		
		range.addNPC(mark.getName(), mark);
		range.addItem(bow.getName(), bow);
		// Wizard Sanctum Items
		NPC snape = new Snape("Snape", "Snape used to teach defense against the dark arts here, but someone got it before him");
		Item fireball = new Item("Fireball", "The Fireball spell is as simple as it is effective at removing whatever you dont want there anymore. Its a Ball of Fire");
		
		sanctum.addNPC(snape.getName(), snape);
		sanctum.addItem(fireball.getName(), fireball);
		// Throne Room Items
		NPC queen = new Queen("Queen", "Queen Maven Black-Briar. She was the princess before she became Queen. She was taken by a dragon long ago, She was saved by the now King, and became his Queen.");
		NPC king = new King("King", "King Barlgruuf the Greater. Was once a simple knight turned Jarl of Whiterun, He then saved His Queen from a Dragon so many years ago and became King of this Land.");
		VaultDoor vaultDoor = new VaultDoor("RoyalVaultDoor", "A Massive Vault Door With a Tungsten Carbide Hull, Titanium Alloy Hydroylics, Maraging Steel Interior, Graphene-Reinforced Composite Frame, and Ceramic-Metal Armored Plates." + "\n" + "...Unless You Have a Vault Key of Somesort, You Aint Ever Get in!");

		throne.addNPC(queen.getName(), queen);
		throne.addNPC(king.getName(), king);
		throne.addItem(vaultDoor.getName(), vaultDoor);
		// Vault Items
		Item axe = new Item("Stormbreaker", "A weapon fit for a king");
		Item shotgun = new Item("SuperShotgun", "Double-barreled, explosive shells, brutal stopping power. What more could a Queen want?");
		Item tiara = new Item("Tiara", "Princess Marias Tiara, just holding it makes you feel stronger");
		
		vault.addItem(tiara.getName(), tiara);
		vault.addItem(shotgun.getName(), shotgun);
		vault.addItem(axe.getName(), axe);
		
		return gate; // returns to starting gate
	}
}
