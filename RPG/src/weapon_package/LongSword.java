package weapon_package;

import java.util.Random;

public class LongSword extends SuperWeapon {
	
	private Random r = new Random();
	private int minDamage;
	private int maxDamage;
	
	public LongSword() {
		super("LongSword", 10);
	}
	
	/*
	public int getMinDmg() {
		return minDamage;
	}
	
	public int getMaxDmg() {
		return maxDamage;
	}
	
	public void setMinDmg(int min) {
		this.minDamage = min;
	}
	
	public void setMaxDmg(int max) {
		this.maxDamage = max;
	}
	*/
}
