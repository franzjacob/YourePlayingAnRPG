package monster_package;

public class Goblin extends SuperMonster{

	private static String deathMsg = "You've been totally fucking owned by a"
			+ "\nsmall-ass, punk-faced, lvl 1 Goblin."
			+ "\n\nReturn to title screen, ya fucking nimwit."; 

	
	public Goblin() {
		super("Goblin", 20, 7, 10, deathMsg);
	}
}
