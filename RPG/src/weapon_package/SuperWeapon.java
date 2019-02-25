package weapon_package;

import java.util.Random;

/*
 * can't put weapon specific attacks(methods) or stats in weapon class files b/c
 * I'm calling on the super class to access data (weapon is of class SuperWeapon in Story.java.
 * Setting a "normalized" damage value in the individual weapon classes that will act as a 
 * modifier. Gets passed from subclass to super so super can access it and dicate the min/max dmg values.
 * Putting attack methods in this file, will just have to remember which ones to call
 * in the story file.
 */

public class SuperWeapon {
	
	private int minDmg;
	private int maxDmg;
	
	public String name;
	public int damage;
	
	
	public SuperWeapon(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}
	
	public void setMin() {
		minDmg = (int) (damage - (damage / 1.5));
	}
	
	public void setMax() {
		maxDmg = (int) (damage - (damage / 1.5));
	}
	
	public int getMin() {
		return minDmg;
	}
	
	public int getMax() {
		return maxDmg;
	}
	
	public String getName() {
		return name;
	}
	
	// assign to variable in Story.java then deduct from monster.hp
	// general-purpose attack move
	public int basicAttack() {
		Random r = new Random();
		int atk = r.nextInt(maxDmg - minDmg) + minDmg;
		return atk;
	}
	
}
