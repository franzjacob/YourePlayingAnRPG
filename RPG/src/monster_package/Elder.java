package monster_package;

public class Elder extends SuperMonster{
	
	public Elder() {
		name = "Village Elder";
		hp = 60;
		attack = 3;
		deathMessage = "The Elder lifts up a hand. He seems"
				+ "\npleased. \"You've proven your worth,"
				+ "\noutsider. Come, feast with us.";
		surrenderMessage = "\"NO SURRENDER!\", the elder screams."
				+ "\nThe elder smashes in your skull with one"
				+ "\nswift downward cleave. Your head"
				+ "\nis completely missing, presumably"
				+ "\nlodged within your chest cavity."
				+ "\nYou're dead.";
		loseNum = 1;
	}
}
