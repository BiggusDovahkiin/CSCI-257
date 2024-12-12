
public class Dragon extends NPC{
	
	private int convo = 1;
	private Room agartha;
	
	public Dragon(String name, String desc, Room agartha) {
		super(name, desc);
		this.agartha = agartha;
	}
	
	@Override
	public void talk() {
		if (convo == 1) {
			say("You are not going to attack me?");
			String[] options = { "Why do you terrorize this land?", "'Attack'" };
			getResponse(options);
		}
		
		else if (convo ==2) {
			say("You are brave to seek dialogue rather than resorting to violence. You are the first of your kind to do so.");
			String[] options = { "You say you are protecting this land, why steal our Princess' time and time again?", "Violence is not always the answer, my people struggle with this idea" };
			getResponse(options);
		}
		
		else if (convo == 3) {
			say("The Shadow Man. The crazy place or Agartha is where he and Maria are. He draws your people out to fight my kind all for some crule twisted game, over the years we Dragon have learned that the Humans are too far lost, you have proved this wrong young knight");
			String[] options = { "Can you Take me to this Shadow Man?", "Can you help me save my Princess?" };
			getResponse(options);
		}
		
		else if (convo == 4) {
			boolean hasDragonblade = false;
			boolean hasPinak = false;
			boolean hasFireball = false;
			
			for (Item item : Game.inventory) {
				if (item.getName().equalsIgnoreCase("Dragonblade")) {
					hasDragonblade = true;
				} else if (item.getName().equalsIgnoreCase("Pinak")) {
					hasPinak = true;
				} else if (item.getName().equalsIgnoreCase("Fireball")) {
					hasFireball = true;
				}
			}
			Game.print("What will you attack with?");
				if (hasDragonblade && hasPinak && hasFireball) {
					String[] options = { "Dragonblade", "Pinak Bow", "Fireball" };
					getResponse(options);
			} else if (hasDragonblade && hasPinak) {
				String[] options = { "Dragonblade", "Pinak Bow", "" };
				getResponse(options);
			} else if (hasDragonblade && hasFireball) {
				String[] options = { "Dragonbalde", "", "Fireball" };
				getResponse(options);
			} else if (hasPinak && hasFireball) {
				String[] options = { "", "Pinak Bow", "Fireball" };
				getResponse(options);
			} else if (hasDragonblade) {
				String[] options = { "Dragonblade", "", "" };
				getResponse(options);
			} else if (hasPinak) {
				String[] options = { "", "Pinak Bow", "" };
				getResponse(options);
			} else if (hasFireball) {
				String[] options = { "", "", "Fireball" };
				getResponse(options);
			}
		}
	}
	
	@Override
	public void response(int option) {
		if (convo == 1) {
			switch (option) {
			case 1:
				Game.print("The massive Dragon tilts it head in curiosity");
				say("Terrorize? No no no, Im protecting this land from the greater threat at hand.");
				convo = 2;
				break;
			case 2:
				Game.print("The Dragon huffs some smoke through its large nose");
				say("Well... ig ill wait then?");
				Game.print("This Dragon is odd indeed");
				convo = 4;
				break;
			}
		}
		
		else if (convo == 2) {
			switch (option) {
			case 1:
				Game.print("The Dragon moves closer and lowers his voice");
				say("(In a close whisper) The Shadow Man. The Shadow man is the one who steals the Castle's Princess', We dragons have never done such. The Shadow Man is controlling the people inside the castle walls. He has no power outside of it.");
				convo = 3;
				break;
			case 2:
				Game.print("The Dragon laughs a little");
				say("Aye you are indeed correct young knight. I do know where your Princess is being held, I assure you that my kind are not the foe you seek. The one who stole your Maria is in 'The Crazy Place'.");
				convo = 3;
				break;
			}
		}
		
		else if (convo == 3) {
			switch (option) {
			case 1:
				Game.print("The Dragon Stands and opens his wings");
				say("I can do that, but you must confront him on your own, for Dragons cannot remain there for long. I will give you one of my scales however, it has special properties");
				Game.currentRoom = agartha;
				Game.gui.updateRoomDisplay();
				break;
			case 2:
				Game.print("The Dragon Stands and opens his wings");
				say("I can take you there, but you must confront him on your own, for Dragons cannot remain there for long. I will give you one of my scales however, it has special properties");
				Game.currentRoom = agartha;
				Game.gui.updateRoomDisplay();
				break;
			}
		}
		
		else if (convo == 4) {
			switch (option) {
			case 1:
				Game.print("You charge at the Dragon, wielding the gleaming Dragonblade with unwavering determination. With a final, powerful swing, the blade pierces the dragon's heart, unleashing a radiant energy that brings the mighty beast crashing to the ground in a triumphant roar.");
				triggerCutscene();
				break;
			case 2:
				Game.print("You draw the magical Pinak bow, nocking an arrow imbued with wild, unpredictable magic. As the bowstring is released, the arrow streaks toward the dragon, unleashing a burst of chaotic energy, transforming into bolts of lightning, freezing the air, or summoning fiery explosions as it strikes, each shot weakening the dragon until it finally falls.");
				triggerCutscene();
				break;
			case 3:
				Game.print("You channel the scrolls magic, conjuring a blazing sphere of intense flame in your hand. With a swift motion, you hurl it at the dragon, and upon impact, the fireball erupts in a massive explosion, engulfing the dragon in searing fire that melts its scales and weakens it until it collapses in defeat.");
				triggerCutscene();
				break;
			}
		}
	}
	
	private void triggerCutscene() {
		Game.print("\nThe Dragon falls to the ground, defeated.");
		Game.print("You stand victorious as the princess appears out of thin air, tears in her eyes.");
		Game.print("In gratitude for your bravery, she kisses you and declares you a hero of the kingdom.");
		Game.print("The two of you marry and ascend to the throne as the new King and Queen.");
		Game.print("Years later, you have a daughter, but your peaceful life is shattered when a new dragon kidnaps her. You watch as young knights ask for your blessings to go save the princess and Slay the Dragon");
		Game.print("Game Over: Congrats you won! Or did you?\n");
		Game.gui.stopAcceptingInput();
	}
	
	

}
