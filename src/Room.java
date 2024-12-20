import java.util.HashMap;

public class Room {

	private HashMap<String, Item> items = new HashMap<String, Item>();
	private HashMap<String, NPC> npcs = new HashMap<>();
	private String name;
	private Room n;
	private Room e;
	private Room s;
	private Room w;
	private Room u;
	private Room d;
	private boolean lock;

	// constructor
	public Room(String n) {
		name = n;
	}

	// get methods
	public Room getExit(char m) {
		if (m == 'n') {
			return n;
		}
		if (m == 'e') {
			return e;
		}
		if (m == 's') {
			return s;
		}
		if (m == 'w') {
			return w;
		}
		if (m == 'u') {
			return u;
		}
		if (m == 'd') {
			return d;
		} 
		else {
			return null;
		}
	}

	// set methods
	public void addExit(char m, Room r) {
		if (m == 'n') {
			n = r;
		}
		if (m == 'e') {
			e = r;
		}
		if (m == 's') {
			s = r;
		}
		if (m == 'w') {
			w = r;
		}
		if (m == 'u') {
			u = r;
		}
		if (m == 'd') {
			d = r;
		}
	}
	
	public String getDesc() {
		return Game.rooms.get(name);
	}
	
	public String getName() {
		return name;
	}
	
	public Item getItem(String itemName) {
		return items.get(itemName);
	}
	
	public HashMap<String, Item> getMap() {
		return items;
	}
	
	public void addItem(String itemName, Item thing) {
		items.put(itemName, thing);
	}
	
	public void removeItem(String itemName) {
		items.remove(itemName);
	}
	
	public NPC getNPC(String npcName) {
		return npcs.get(npcName);
	}
	
	public void addNPC(String npcName, NPC person) {
		npcs.put(npcName, person);
	}
	
	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	// special methods
	public String toString() {
		return getDesc();
	}
	
}
