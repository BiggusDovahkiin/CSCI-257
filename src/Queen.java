
public class Queen extends NPC{
	
	private int convo = 1;
	
	public Queen(String name, String desc) {
		super(name, desc);
	}
	
	@Override
	public void talk() {
		if (convo == 1) {
			say("Sorry about him, he may try to not show it but Maria's kidnapping is taking a heavy toll on him. You see, this isnt the first time this has happened here. Only last time, it was me who was taken. He saved me from that beast and almost lost his own life saving mine. Please be understanding with him for he means no real harm.");
			String[] options = { "I understand your highness, I am prepared to lay down my own life for Maria's sake. I swear I will save her.", "Yeah thats cool ig 'shrug'." };
			getResponse(options);
		}
	}
	
	@Override
	public void response(int option) {
		switch (option) {
		case 1:
			say("Thank you my dear knight, Go now with my blessings <3");
			Game.print("The Queen has a genuine smile as she waves you off, the King still looks angry.");
			convo = 2;
			break;
		case 2:
			say("Thank you my dear knight, Go now with my blessings <3");
			Game.print("The Queen has a genuine smile as she waves you off, the King still looks angry.");
			convo = 2;
			break;
		}
	}

}
