package monster_package;

public class DeathWizard extends SuperMonster{
	
	private static String deathMsg = "My my, how fortuitous this is for me to run into"
			+ "\nyou like this. Oh how I've been searching for a"
			+ "\nlittle play-thing to bring with me back to hell.";


	public DeathWizard() {
		super("Death Wizard", 9000, 1000, 1000, deathMsg, 0);
	}
	
}
