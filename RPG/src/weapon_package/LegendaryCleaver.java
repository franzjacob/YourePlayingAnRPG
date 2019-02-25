package weapon_package;

import java.util.Random;

public class LegendaryCleaver extends SuperWeapon{

	Random r = new Random();
	
	public LegendaryCleaver() {
		name = "LGMI";
		damage = r.nextInt(50) + 1;
	}
}
