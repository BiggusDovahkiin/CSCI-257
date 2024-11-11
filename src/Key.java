
public class Key extends Item{
	
	public Key(String name, String desc) {
		super(name,desc);
	}
	
	@Override
	public void use() {
		Game.print("If You Find a Safe, Try Opening It!");
	}

}
