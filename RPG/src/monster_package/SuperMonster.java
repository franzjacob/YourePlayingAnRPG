package monster_package;

public class SuperMonster {

	public String name;
	public int hp;
	public int minDmg;
	public int maxDmg;
	public String deathMessage;
	public String surrenderMessage;
	public int loseNum;
	
	private static String surMsgDEFAULT = null;
	private static int loseNumDEFAULT = 0; 	// just in case i forget or something
	
	public SuperMonster(String name, int hp, int minDmg, int maxDmg, String deathMessage) {
		this(name, hp, minDmg, maxDmg, deathMessage, surMsgDEFAULT, loseNumDEFAULT);
	}
	
	// missing a loseNum
	public SuperMonster(String name, int hp, int minDmg, int maxDmg, String deathMessage, String surrenderMessage) {
		this(name, hp, minDmg, maxDmg, deathMessage, surrenderMessage, loseNumDEFAULT);
	}
	
	// missing a surrender message
	public SuperMonster(String name, int hp, int minDmg, int maxDmg, String deathMessage, int loseNum) {
		this(name, hp, minDmg, maxDmg, deathMessage, surMsgDEFAULT, loseNum);
	}
	
	public SuperMonster(String name, int hp, int minDmg, int maxDmg, String deathMessage, String surrenderMessage, int loseNum) {
		this.name = name;
		this.hp = hp;
		this.minDmg = minDmg;
		this.maxDmg = maxDmg;
		this.deathMessage = deathMessage;
		this.surrenderMessage = surrenderMessage;
		this.loseNum = loseNum;
	}
}
