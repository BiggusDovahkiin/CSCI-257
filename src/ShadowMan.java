
public class ShadowMan extends NPC{
	
	private int convo = 1;
	
	public ShadowMan(String name, String desc) {
		super(name, desc);
	}
	
	@Override
	public void talk() {
		if (convo == 1 ) {
			say("Ah, youre here.");
			String[] options = { "Maria! I have come to save you! Release her at once!", "Ima mess you up fool!", "Care to make a deal?" };
			getResponse(options);
		}
		
		else if (convo == 2) {
			say("The only thing you can do is leave and forget you ever came here or saw this place or me. Just jump into this portal and leave, Got it?");
			Game.print("He waves his hand and opens a portal close to where Maria is held");
			String[] options = { "*Punch him and make a run for the portal and Maria*", "*Push him and make a break for the portal*", "You think I'm not Prepared to fight a 'god'?" };
			getResponse(options);
		}
		
		else if (convo == 3) {
			say("What kind of deal are we talking here?");
			String[] options = { "I take the Princess, and we both promise to never mention this at all, ever", "I kill you, save Maria, have a bomb wedding and live happy ever after? Thoughts?" };
			getResponse(options);
		}
	}
	
	@Override
	public void response(int option) {
		if (convo == 1) {
			switch (option) {
			case 1:
				say("Not gonna happen. You know why? Because I said so, I'm bloody God for all you care. Im the only reason the princess keeps getting taken. Im brainwashing you fools to continue my perfect world. A constant cycle of Princess's being taken with a brave knight stepping up to Slay the Dragon only for it to happen to his our daughter later on! You people are so simple that youll even believe a whole Dragon did it! It was me all along. Im telling you this cuase Im gonna wipe your brains clean anyway so it really doesnt matter.");
				Game.print("He walks closer to you");
				convo = 2;
				break;
			case 2:
				say("I am a God to you, what could you possibly do?");
				Game.print("He walks closer to you");
				convo = 2;
				break;
			case 3:
				say("A deal? That actually sounds interesting!");
				convo = 3;
				break;
			}
		}
		
		else if (convo == 2) {
			switch (option) {
			case 1:
				Game.print("You say nothing and sucker punch the Shadow Man in his jaw. He stumbles to the floor and you make a break for Maria. With adrenaline pumping you rip off the padlock and take Maria by the hand, the two of you then jump into the portal back into the throne room");
				Game.print("All of a sudden you seem to not be bale to recall anything that happened in the last few days, all you know is that you somehow saved the Princess. Thats all she seems to remember too");
				Game.print("The two of you marry and ascend to the throne as the new King and Queen.");
				Game.print("Years later, you have a daughter, but your peaceful life is shattered when a new dragon kidnaps her. You watch as young knights ask for your blessings to go save the princess and Slay the Dragon");
				Game.print("Game Over: Congrats you won! Or did you?\n");
				Game.gui.stopAcceptingInput();
				break;
			case 2:
				Game.print("You say nothing and without even glacing at the locked up Princess Maria, you dash to the portal, dropping your shoulder and laying out the Shadow Man as you dive into the portal onyl for it to close and you hit the ground");
				Game.print("You turn around in horror as the Shadow Man reveals his true form, its something you cant even describe.");
				Game.print("Princess Maria watches in horror as her supposed 'hero' attempted to flee the scene, and as punishment, watches you get eaten by the Shadow Man");
				say("Sorry about that love, maybe the next one will be better");
				Game.print("Game Over. You died.");
				Game.gui.stopAcceptingInput();
				break;
			case 3:
				Game.print("The Shadow Man thinks it over... almost as if he could be worried you might actually try it.");
				Game.print("Before he can get a word out, you saw a chance and stab him with the dragon scale gifted to you. The Shadow Man looks horrified as the light leaves his eyes. The space around you starts to crumble");
				Game.print("Maria's cage desolves into dust as she runs to you, you both see the portal slowly closing as you jump into it");
				Game.print("You land in the Throne room and the King and Queen are shocked to see you have brought their dear daughter back");
				Game.print("In gratitude for your bravery, she kisses you and declares you a hero of the kingdom.");
				Game.print("The two of you marry and ascend to the throne as the new King and Queen.");
				Game.print("Years later, you have not only a daughter, but a son aswell. You are the first King in Kingdom history to heir a son and a daughter. You live a normaly live with Queen Maria at your side, as you live happily, ever after.");
				Game.print("Game Over: Congrats you truly won! The Shadow Man is no more and so is the cloud of Brainwashing. You win!");
				Game.gui.stopAcceptingInput();
				break;
			}
		}
		
		else if (convo == 3) {
			switch (option) {
			case 1:
				say("Deal. But if you break this promise... I will kill you");
				Game.print("You shake the Shadow Mans hand, all while he has this eerie toothy smile");
				Game.print("The Shadow Man frees Princess Maria and she goes running to you, The Shadow Man waves his hands and makes a portal under you to send you back");
				say("Bye Bye now! Dont break your promise, cause I wont break mine...");
				Game.print("All of a sudden you seem to not be bale to recall anything that happened in the last few days, all you know is that you somehow saved the Princess. Thats all she seems to remember too");
				Game.print("The two of you marry and ascend to the throne as the new King and Queen.");
				Game.print("Years later, you have a daughter, but your peaceful life is shattered when a new dragon kidnaps her. You watch as young knights ask for your blessings to go save the princess and Slay the Dragon");
				Game.print("Game Over: Congrats you won! Or did you?\n");
				Game.gui.stopAcceptingInput();
				break;
			case 2:
				Game.print("The Shadow Man thinks it over... almost as if he could be worried you might actually try it.");
				Game.print("Before he can get a word out, you saw a chance and stab him with the dragon scale gifted to you. The Shadow Man looks horrified as the light leaves his eyes. The space around you starts to crumble");
				Game.print("Maria's cage desolves into dust as she runs to you, you both see the portal slowly closing as you jump into it");
				Game.print("You land in the Throne room and the King and Queen are shocked to see you have brought their dear daughter back");
				Game.print("In gratitude for your bravery, she kisses you and declares you a hero of the kingdom.");
				Game.print("The two of you marry and ascend to the throne as the new King and Queen.");
				Game.print("Years later, you have not only a daughter, but a son aswell. You are the first King in Kingdom history to heir a son and a daughter. You live a normaly live with Queen Maria at your side, as you live happily, ever after.");
				Game.print("Game Over: Congrats you truly won! The Shadow Man is no more and so is the cloud of Brainwashing. You win!");
				Game.gui.stopAcceptingInput();
				break;
			}
		}
	}

}
