package monster_package;

public class Goblin extends SuperMonster{

	public Goblin() {
		name = "Goblin";
		hp = 20;
		attack = 6;
		deathMessage = "You've been totally fucking owned by a"
				+ "\nsmall-ass, punk-faced, lvl 1 Goblin."
				+ "\n\nReturn to title screen, ya fucking nimwit."; 
		loseNum = 0;
	}
}
