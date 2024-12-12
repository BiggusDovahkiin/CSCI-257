
public class King extends NPC{
	
	public int convo = 1;
	
	public King(String name, String desc) {
		super(name, desc);
	}
	
	@Override
	public void talk() {
		if (convo == 1) {
			say("What?");
			String[] options = { "Greetings your lordship. I am a simple knight seeking your blessing to save Fair Maria and win her hand in marrige.", "Im just a chill guy, tryna bag Maria or whatever." };
			getResponse(options);
		}
		
		else if (convo == 2) {
			Game.print("The king doesnt even look at you.");
		}
	}
	
	@Override
	public void response(int option) {
		switch (option) {
		case 1:
			say("As I have said to all the others before you, whoever kills that forsaken Lizard will win Maria. If you need equipment go speak to either of the 3 warrior class leaders, you can find them in the Range, Blacksmith, or Sanctum. Be gone with you!");
			Game.print("The King is very unpleased, The Queen however looks at you with interest, maybe shell be easier to talk to.");
			convo = 2;
			break;
		case 2:
			say("At least your honest, go to the market area and speak to one of the specialist to get equipement. Just be gone.");
			Game.print("The King is very unpleased, The Queen however looks at you with interest, maybe shell be easier to talk to.");
			convo = 2;
			break;
		}
	}
}
