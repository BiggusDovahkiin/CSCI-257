
public class Bartender extends NPC{
	
	private int convo = 1;
	
	public Bartender(String name, String desc) {
		super(name, desc);
	}
	
	@Override
	public void talk() {
		if (convo == 1) {
			say("Good Afternoon my lord. What can I get ya?");
			String[] options = { "Dave is it? I need some 'info'.", "Beer." };
			getResponse(options);
		}
	}
	
	@Override
	public void response(int option) {
		switch (option) {
		case 1:
			Game.print("The Bartender looks surprised and proceeds to serve you a bottle of mead.");
			say("Ah, I understand it now. You want me to help you save Princess Maria by giving you 'special' information eh? All I can tell you is what I told all the other knights trying to win Maria's hand. Talk to the Royals up north in the Castle, cant miss it.");
			Game.print("The Bartender goes to clean another glass, seems you'll have the come back another time for more help.");
			convo = 2;
			break;
		case 2:
			Game.print("Dave goes to bring you a beer and sets it down.");
			say("Good lad, you know what you want, I can respect that. The King and his misses are sure to like that too, why dont you go see for youself. Here,Take this with you just incase.");
			Game.print("Dave puts down a firm bottle of Jack Daniels on the counter. Guess you'll go see the King and Queen up north in the Castle now.");
			convo = 2;
			break;
		}
	}
}
