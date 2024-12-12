
public class Mark extends NPC{
	
	private int convo = 1;
	
	public Mark(String name, String desc) {
		super(name, desc);
	}
	
	@Override
	public void talk() {
		if (convo == 1) {
			say("Hello young knight!, Looking for some range?");
			String[] options = { "Yes I am, anything of the Dragon slaying sort?", "Could you tell me more about Archery?" };
			getResponse(options);
		}
	}
	
	@Override
	public void response(int option) {
		switch (option) {
		case 1:
			say("I got just the thing for you! What I got here is the Pinak. This Bow is said to be the most powerful celestial bow in Hindu Mythology. Said to belong to Lord Shiva who could destroy 3 entire cities with its magic arrows.");
			Game.print("You can clearly see its a simple 50 lbs recurve, but you nod and smile along." + "\n" + "You can take the bow and become an archer or check out the other warrior classes");
			break;
		case 2:
			say("Being an Archer is great, you stay at a safe distance away from your target and yet you can strike harder than a sword. Its easier to use than magic and never lets you down, the bow is an art form and you are the brush, the bow will only do what you 'the brush' will it to do. Archery is great for dragon hunting let me tell you.");
			Game.print("Talk to Mark again to check out the special bow he has. Or check out the other warrior classes");
			break;
		}
	}

}
