
public class Snape extends NPC{
	
	private int convo = 1;
	
	public Snape(String name, String desc) {
		super(name, desc);
	}
	
	@Override
	public void talk() {
		if (convo == 1) {
			say("Hello young knight!, Looking to get 'Magical?'");
			String[] options = { "Indeed I am, can you teach me anything to Slay a Dragon?", "Could you tell me more about the Wizard arts?" };
			getResponse(options);
		}
	}
	
	@Override
	public void response(int option) {
		switch (option) {
		case 1:
			say("I have just the scroll for you. Fireball... Simple yet incredibly devastating. Go on, Take it!");
			Game.print("Snape points to the Fireball scroll on the wall, Cant beat the classics." + "\n" + "You can take the scroll and become a Wizard or check out the other warrior classes");
			break;
		case 2:
			say("The Wizard arts are not easy. However those who take on the challenge are greeted with power unlike you have ever even dreamed of. Power is all forms is simply a scroll away from being yours.");
			Game.print("Talk to Snape again to check out the special scroll he has. Or check out the other warrior classes");
			break;
		}
	}

}
