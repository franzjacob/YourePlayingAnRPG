package weapon_package;

import java.util.Random;

public class Knife extends SuperWeapon {
	
	public Random r = new Random();
	private int minDamage;
	private int maxDamage;
	
	public Knife() {
		this.setMinDmg(1);
		this.setMaxDmg(4);
		name = "Knife";
		damage = 4;
	}
	
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
	
	public int stab() {
		return r.nextInt((maxDamage - minDamage) + 1) + minDamage;
	}
	
	
}
