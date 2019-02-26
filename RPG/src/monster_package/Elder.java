package monster_package;

public class Elder extends SuperMonster{
	
	private static String deathMsg = "The Elder lifts up a hand. He seems"
			+ "\npleased. \"You've proven your worth,"
			+ "\noutsider. Come, feast with us.";

	private static String surrenderMsg = "\"NO SURRENDER!\", the elder screams."
			+ "\nThe elder smashes in your skull with one"
			+ "\nswift downward cleave. Your head"
			+ "\nis completely missing, presumably"
			+ "\nlodged within your chest cavity."
			+ "\nYou're dead.";

	public Elder() {
		super("Village Elder", 60, 5, 20, deathMsg, surrenderMsg, 1);
	}
}
