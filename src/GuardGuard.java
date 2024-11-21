
public class GuardGuard extends NPC{

	private int convo = 1;

	public GuardGuard(String name, String desc) {
		super(name, desc);
	}

	@Override
	public void talk() {
		if (convo == -1) {
			say("My Lord, esteemed member of the Flame Guard, please excuse my insignificant existence.");
		}
		
		else if (convo == 0) {
			say("Hey man, come on in");
		}
		
		else if (convo == 1) {
			say("Hello Young Knight! The Guard House is currenty off limits to Knights who have not been named Banneret? Please Move Along.");
			String[] options = { "How does one Acheve the Rank of Banneret?", "But you yourself arent a Banneret? Shall I have you Reported to the King Himself?", "HOW DARE YOU PEASANT. ILL HAVE YOU KNOW THAT I AM HELD SECOND TO ONLY HIS MAJESTY HIMSELF. IF YOU DO NOT DISPATCH YOUSELF IMMEDIATELY I WILL HAVE YOU BURNED IN THE CONFINES OF THE DUNGEONS." };
			getResponse(options);
		}

		else if (convo == 2) {
			say("Hello again Young Knight. You Reach Banneret Rank yet?");
			String[] options = { "Indeed I have (Show Seal of the Flame Guard)", "Not Quite Yet." };
			getResponse(options);
		}
		
		else if (convo == 3) {
			say("Hello again Young Knight. You got the goods?");
			String[] options = { "Indeed I do (Hand over Bottle of Jack Daniels)", "Not yet no, What exactly are you looking for again?" };
			getResponse(options);
		}
		
		else if (convo == 4) {
			say(" 'Crying Profusely still in a fetal position on the floor' ");
		}
	}
	
	@Override
	public void response(int option) {
		if (convo == 1) {
		switch (option) {
		case 1:
			say("Oh it is only the single most challenging endever a Knight could ever hope to accomplish. You Must First gain the trust of the King himself, then take on a Personal Favor of Her Majesty the Queen. Then and ONLY THEN, wll you be tasked on a mission SO DANGEROUS, that only 1 Knight hasever done it and lived... That man is non other than THE KING HIMSELF... I would wish you luck, but theres no way you could ever hope to complete such a task when not even myself has gained the kings trust. Begone with you now.");
			Game.print("The Guard turns his head to give you the hand to talk to. Clearly this guys helmets on little tight. Guess you could try talking to the king, worth a shot anyway.");
			convo = 2;
			break;
		case 2:
			say("I- uhhhhhhhh... HARKS! Fine fine, you got me, please dont go to his Majesty about this. Ive aleady been in trouble a few times and I really need this job man. ");
			say("Look Ill let you in BUT, only after you do something for me. I need you to get me someting to take the edge off yk? ");
			say("I hear the Tavern got a new sipment of stuff from this odd place called Tennessee or whatever that wasteland is called. ");
			say("Bring me that and Ill THINK about letting you in.");
			Game.print("The Guard seems to be, well, off his guard. Im sure the Bartender at the Tavern can help you out");
			convo = 3;
			break;
		case 3:
			say("IM SO SORRY SIR! THATS MY MISTAKE IM SO SORRY, PLEASE FORGIVE ME ILL DO ANYTHING, ANYTHING I SWEAR PLEASE DONT KILL ME!");
			Game.print("So yeah this dude lost it. Literally balling his eyes out in a fetal position begging for mercy... thats a yikes from me man. On the brightside tho hes no longer guarding the Guard House.");
			convo = 4;
			break;
		}
		}
		
		else if (convo == 2) {
			switch (option) {
			case 1:
				say("I- ... Being honest i was just messing with you, I didn't think you would ACTUALLY go and do it... Well then... Pardon me my Lord, and Please excuse my idiotic actions. My most humble apologies my good Sir.");
				Game.print("The Guard Bows and steps aside letting you into the Guard House.");
				convo = -1;
				break;
			case 2:
				say("Dude yk im only messing with you right? Theres no lockdown or anything. And plus to be a Banneret you gotta join the Cult of the Flame Guard or something anyways. yeah come in man.");
				Game.print("The Guard steps aside saving you time and energy of going on that probably worth while quest honestly.");
				convo = 0;
				break;
			}
		}
		
		else if (convo == 3) {
			switch (option) {
			case 1:
				say("THANK YOU! Oh my days... I am going to have a WONDERFUL NIGHT WITH YOU");
				Game.print("Yeah he totally just said that to the bottle... this guys nuts. Good news is the door is now unguarded.");
				convo = 0;
				break;
			case 2:
				say("Its a bottle of liquid old if yk what I mean. Made by this genius named, Jack, Daniels... Super crazy good stuff, Ben the bartender could help you find it.");
				Game.print("Whats crazy is the look in this guys eyes. The lights are on but no ones home. Anyway, gotta find this Jack Daniels from Tennessee dude or something like that.");
				convo = 3;
				break;
			}
		}
	}
}
