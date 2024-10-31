
public class Combination extends Item{
	
	public Combination(String name, String desc) {
		super(name,desc);
	}
	
	@Override
	public void use() {
		Game.print("If You Find a Safe, Try Opening It!");
	}

}
