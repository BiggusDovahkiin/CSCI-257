
public class DungeonGuard extends NPC{
	
	private int convo = 1;
	
	public DungeonGuard(String name, String desc) {
		super(name, desc);
	}
	
	@Override
	public void talk() {
		if (convo == 1) {
			say("Hello Young Knight! Welcome to the Royal Guard House, if you ever have any suspects that need to be held indefinitely, then you have come to the right place. I, The Dungeon Guard have been Guarding this here Dungeon for the Last 2 Decades and have had 0 escapies or unauthorized enterance. How can I help you?");
			String[] options = { "There is a prisoner held here that I must speak with. It is oh ut' most importance to His Majesty.", "I need to get in the Dungeon." };
			getResponse(options);
			}
		
		else if (convo == 2) {
			say("Hello again Young Knight, Do you have a 'special token' of the Queen for my personal records... I- I- I mean the Dungeon mandated records?");
			String[] options = { "Sure man, here you go. (Hand over signed Tastful Holiday Calender", "Not yet, What exactly are you looking to get?" };
			getResponse(options);
		}
		
		else if (convo == 3) {
			say("What do you want?? Just leave me and my sweat Queen be!");
			Game.print("The Guard is not interested in talking or doing his job at the moment.");
		}
	}
	
	@Override
	public void response(int option) {
		if (convo == 1) {
			switch (option) {
			case 1:
				say("Im sorry young knight, I cannot grant you access. If what you are saying is true and just, than I shall require proof. Say perhaps a token of her Majesty?");
				Game.print("The Guard has a... creepy toothy smile. He seems... off, best to try and just get him what he wants.");
				convo = 2;
				break;
			case 2:
				say("Ah...Indeed... Well as per regulation, I shall require a token of Her Majesty, eh for my personal records of course");
				Game.print("The Guard has a... creepy toothy smile. He seems... off, best to try and just get him what he wants.");
				convo = 2;
				break;
			}
		}
		
		else if (convo == 2) {
			switch (option) {
			case 1:
				Game.print("You give the Calender to the Guard.");
				say("YES! THANK YOU GOOD SIR!! I do not know how you convinced the Queen to do this for you, BUT YOU MUST TEACH ME SO I CAN GET MORE!");
				Game.print("Brother must of been starving. So sad to see a person like this, the Dungeon is now open to explore!");
				convo = 3;
				break;
			case 2:
				say("Her Majesty has evaded my MANY attempts to capture her heart... She refuses to even send me the yearly Holiday Calender that all citizens get every year... Could you try and bring me one? Signed by the Queen perhaps?");
				Game.print("Im sure the Queen would comply if informed your progress is held to a halt.");
				break;
			}
		}
	}

}
