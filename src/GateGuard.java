
public class GateGuard extends NPC {

	private int convo = 1;
	private Room dragonsLair;

	public GateGuard(String name, String desc, Room dragonsLair) {
		super(name, desc);
		this.dragonsLair = dragonsLair;
	}

	@Override
	public void talk() {
		if (convo == 1) {
			say("Hello Young Knight! You must be here to Slay the Dragon. Are you Ready to Embark to the Dragons Lair?");
			String[] options = { "I am Ready.", "That is infact my Quest, but I am not yet Fully Prepared quite yet!" };
			getResponse(options);
			convo += 1;
		}

		else if (convo == 2) {
			say("Hello again Young Knight. Have you your affairs in order?");
			String[] options = { "I am Ready.", "Not Quite Yet." };
			getResponse(options);
		}
	}

	@Override
	public void response(int option) {
		switch (option) {
		case 1:
			say("Most Joyest of News Sir, I will Open the Gate and wish you Good Luck and Hope for you and Lady Maria's safe return.");
			Game.print("The Guard bows before you and you do the same before heading off into the Dragons Lair.");
			Game.currentRoom = dragonsLair;
			Game.gui.updateRoomDisplay();
			break;
		case 2:
			say("A Wise man Indeed. I shall be here Awaiting your word to Begin the Battle. Make Haste for we do not have the Luxury of Time.");
			Game.print("The Guard Bows and Returns to his Attention Position");
			break;
		}
	}
}
