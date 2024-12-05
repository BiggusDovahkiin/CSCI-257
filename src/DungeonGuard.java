
public class DungeonGuard extends NPC{
	
	private int convo = 1;
	
	public DungeonGuard(String name, String desc) {
		super(name, desc);
	}
	
	@Override
	public void talk() {
		if (convo == 1) {
			say("Hello Young Knight! Welcome to the Royal Guard House, if you ever have any suspects that need to be held indefinitely, then you have come to the right place. I the Dungeon Guard have been Guarding this here Dungeon for the Last 2 Decades and have had 0 escapies or unathurized enterance. How can I help you?");
			
		}
		
		else if (convo == 2) {
			say("");
		}
	}
	
	@Override
	public void response(int option) {
		if (convo == 1) {
			switch (option) {
			case 1:
				say("");
			}
		}
	}

}
