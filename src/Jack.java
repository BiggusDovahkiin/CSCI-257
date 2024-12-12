
public class Jack extends NPC{
	
	private int convo = 1;
	
	public Jack(String name, String desc) {
		super(name, desc);
	}
	
	@Override
	public void talk() {
		if (convo == 1) {
			say("Hello young knight! Can I interest you in some weapons?");
			String[] options = { "Yes please, I need something that'll make a Dragon have a bad day.", "Could you tell me more about the way of the Sword?" };
			getResponse(options);	
		}		
	}
	
	@Override
	public void response(int option) {
		switch (option) {
		case 1:
			say("Ah, the Dragon. I have just the thing. I call it, Dragonblade. It was forged from Special steel from Hanamura, Japan. The soul of the Dragon of the south wind was forged into this blade. This particular Dragon being a folktale turned real, in the form of the youngest Shimada Brother");
			Game.print("This is truly a beautiful blade. The Green mystical-like glow, the smooth and sleek design with the Green dragon pattern is stunning and a mastercraft in its own right." + "\n" + "You can take the scroll and become a Wizard or check out the other warrior classes");
			break;
		case 2:
			say("The way of the Blade is a simple yet special form of combat. Getting up close and personal with your target. You perform a dance like motion and have your blade become an extention of yourself, you must be one with the wind in tune with your body. The sword will become more than some metal stick, itll become a friend and a life saving ally");
			Game.print("Talk to Jack again to check out the special sword he has. Or check out the other warrior classes");
			break;
		}
	}

}
