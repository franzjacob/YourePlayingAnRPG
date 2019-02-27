package default_package;

import java.util.Random;

import monster_package.DeathWizard;
import monster_package.Goblin;
import monster_package.Elder;
import monster_package.SuperMonster;
import speech_package.Chapter1Bits;
import speech_package.Chapter2Bits;
import speech_package.TownGate;
import speech_package.TownGuard1;
import weapon_package.Fists;
import weapon_package.Knife;
import weapon_package.LegendaryCleaver;
import weapon_package.LongSword;

public class Story {

	Game game;
	UI ui;
	VisibilityManager vm;
	Player player;
	SuperMonster monster;
	Helper helper;
	Tooltips tooltips;
	
	// contextual text/monologues
	TownGuard1 townGuard;
	TownGate townGate;
	Chapter1Bits ch1Text;
	Chapter2Bits ch2Text;
	
	// triggers for story/text events
	boolean silverRing;
	boolean talkedToGuard;
	boolean hitGuard;
	boolean seenCrossRoad;
	boolean apologize;
	boolean lieThere;
	boolean bloodrage;
	int talkedToGuardCounter;
	int attackedGuardCounter;
	int townGateCounter;
	int swordCounter;
	int crowdCounter;
	int bigGuyCounter;
	int weaponCounter;
	
	int smiteCD;
	
	public Story(Game g, UI userInterface, VisibilityManager vManager) {
		
		this.game = g;
		this.ui = userInterface;
		this.vm = vManager;
		this.helper = new Helper(userInterface, g);
	}
	
	// sets values for start of game
	public void defaultSetup() {
		player = new Player();
		player.hp = 10;
		ui.hpLabelNumber.setText(Integer.toString(player.hp));
		
		player.currentWeapon = new Knife();
		ui.weaponLabelName.setText(player.currentWeapon.name);
		
		townGuard = new TownGuard1();
		townGate = new TownGate();
		ch1Text = new Chapter1Bits();
		ch2Text = new Chapter2Bits();
		
		silverRing = false;
		talkedToGuard = false;
		hitGuard = false;
		seenCrossRoad = false;
		apologize = false;
		lieThere = false;
		bloodrage = false;
		
		talkedToGuardCounter = 0;
		attackedGuardCounter = 0;
		townGateCounter = 0;
		swordCounter = 0;
		crowdCounter = 0;
		bigGuyCounter = 0;
		weaponCounter = 0;
		
		smiteCD = 5;
		
		this.tooltips = new Tooltips(this.ui, this.game, this.player, this.monster);
		tooltips.setWeaponLabelNameTTT();
		tooltips.setWeaponLabelTTT();
		tooltips.setHealthTTT();
	}
	
	public void selectPosition(String nextPosition) {
		
		switch(nextPosition) {
		case "townGate": townGate(); break;
		case "talkGuard": talkGuard(); break;
		case "attackGuard": attackGuard(); break;
		case "crossRoad": crossRoad(); break;
		case "north": north(); break;
		case "east": east(); break;
		case "west": west(); break;
		case "fight": fight(); break;
		case "fight2": fight2(); break;
		case "playerAttack": playerAttack(); break;
		case "monsterAttack": monsterAttack(); break;
		case "win": win(); break;
		case "lose": lose(); break;
		case "returnTitle": returnTitle(); break;
		case "crowdGathers": crowdGathers(); break;
		case "enterTown": enterTown(); break;
		case "bigGuy": bigGuy(); break;
		case "surrenderDIE": surrenderDIE(); break;
		case "lieThere": lieThere(); break;
		case "getReady": getReady(); break;
		case "KO": KO(); break;
		case "end": end(); break;
		}
	}
	
	public void townGate() {
		String default_s = "You are standing at the gate of the town"
				+ "\nA guard blocks the entrance"
				+ "\n\nWhat do you do?";
		Random r = new Random();
		
		helper.enabler(3);
		
		if (!seenCrossRoad) {
			ui.mainTextArea.setText(default_s);
		} else {
			ui.mainTextArea.setText(townGate.contextual_monologues[r.nextInt(5)]);
		}
		
		if (talkedToGuardCounter >= 7) {
			helper.setChoiceText("PESTER!", "Attack the Guard", "Leave");
		} else if (talkedToGuardCounter > 3) {
			helper.setChoiceText("Pester Guard", "Attack the Guard", "Leave");
		} else if (talkedToGuardCounter > 0) {
			helper.setChoiceText("Ask Guard Again", "Attack the Guard", "Leave");
		} else {
			helper.setChoiceText("Ask Guard", "Attack the Guard", "Leave");
		}
		
		townGateCounter++;
		helper.setNextPosition("talkGuard", "attackGuard", "crossRoad");
	}
	
	public void talkGuard() {
		talkedToGuard = true;
		Random r = new Random();
		helper.enabler(1);
		if (!silverRing) {
			if (talkedToGuardCounter == 7) {
				ui.mainTextArea.setText(townGuard.last_straw[r.nextInt(3)]);
				helper.setChoiceText(">");
				helper.setNextPosition("attackGuard");
			} else if (talkedToGuardCounter < 7 && talkedToGuardCounter > 3) {
				ui.mainTextArea.setText(townGuard.extra_monologues[r.nextInt(4)]);
				talkedToGuardCounter++;
				helper.setChoiceText(">");
				helper.setNextPosition("townGate");
			} else if (talkedToGuardCounter < 4 && talkedToGuardCounter > 0) {
				ui.mainTextArea.setText(townGuard.nonviolent_monologues[r.nextInt(6)]);
				talkedToGuardCounter++;
				helper.setChoiceText(">");
				helper.setNextPosition("townGate");
			} else {
				ui.mainTextArea.setText("\"You are an outsider. I do not know you."
						+ "\nBegone, miscreant.\"");
				talkedToGuardCounter++;
				helper.setChoiceText(">");
				helper.setNextPosition("townGate");
			}
			
		} else {
			endChapter1();
		}
	}
	
	public void attackGuard() {
		helper.enabler(1);
		if (talkedToGuardCounter == 7 || attackedGuardCounter == 7) {
			player.hp = 0;
			ui.hpLabelNumber.setText(Integer.toString(player.hp));
			ui.mainTextArea.setText(ch1Text.guardKOS[0]);
			helper.setChoiceText("Return to Title");
			helper.setNextPosition("returnTitle");
			
		} else {
			Random r = new Random();
			attackedGuardCounter++;
			player.hp -= 3;
			hitGuard = true;
			ui.hpLabelNumber.setText(Integer.toString(player.hp));
			ui.mainTextArea.setText(townGuard.contextual_monologues[r.nextInt(5)]
					+ "\n(Guard backhands you. Take 3 damage)");
			
			if (player.hp > 0) {
				helper.setChoiceText(">");
				helper.setNextPosition("townGate");
			} else {
				helper.setChoiceText("You Died");
				helper.setNextPosition("returnTitle");
			}
		}
	}
	
	public void crossRoad() {
		ui.choice2.setEnabled(true); // b/c playerAttack() is one of next possible calls after smite button being possibly disabled
		
		seenCrossRoad = true;
		ui.mainTextArea.setText("You are at a crossroad. Taking the southern"
				+ "\nroute will return you to the town."
				+ "\n\nWhat do you do?");
		
		helper.enabler(4);
		helper.setChoiceText("Go North", "Go East", "Go South", "Go West");
		helper.setNextPosition("north", "east", "townGate", "west");
	}
	
	public void north() {
		player.hp += 3;
		ui.hpLabelNumber.setText(Integer.toString(player.hp));
		ui.mainTextArea.setText("You find a pond and drink from its cool water."
				+ "\n\n(Not the most sanitary thing, but eh. Gain 3 \nhealth.)");
		
		helper.enabler(1);
		helper.setChoiceText(">");
		helper.setNextPosition("crossRoad");
	}
	
	
	public void east() {
		
		helper.enabler(1);
		if (swordCounter <= 4) {
			player.currentWeapon = new LongSword();
			ui.weaponLabelName.setText(player.currentWeapon.name);
			ui.mainTextArea.setText(ch1Text.east[swordCounter]);
			tooltips.setWeaponLabelNameTTT();
			tooltips.setWeaponLabelTTT();
			swordCounter++;
			weaponCounter = 1;
			
			helper.setChoiceText(">");
			helper.setNextPosition("crossRoad");
		} else if (swordCounter == 5){
			player.currentWeapon = new LegendaryCleaver();
			ui.weaponLabelName.setText(player.currentWeapon.name);
			ui.mainTextArea.setText(ch1Text.east[swordCounter]);
			tooltips.setWeaponLabelNameTTT();
			tooltips.setWeaponLabelTTT();
			swordCounter++;
			weaponCounter = 2;
			
			helper.setChoiceText(">");
			helper.setNextPosition("crossRoad");
		} else {
			ui.mainTextArea.setText(ch1Text.east[ch1Text.east.length - 1]);
			
			helper.setChoiceText(">");
			helper.setNextPosition("crossRoad");
		}
	}
	
	public void west() {
		int r = new Random().nextInt(101);
		if (r < 90 && !silverRing) {
			monster = new Goblin();
			
			ui.mainTextArea.setText("You encounter a " + monster.name + "!");
			
			helper.enabler(2);
			helper.setChoiceText("Fight", "Run");
			helper.setNextPosition("fight", "crossRoad");
		} else if (r < 90 && silverRing) {
			ui.mainTextArea.setText(ch1Text.west[0]);
			
			helper.enabler(1);
			helper.setChoiceText(">");
			helper.setNextPosition("crossRoad");
		} else {
			monster = new DeathWizard();
			
			ui.mainTextArea.setText(ch1Text.west[1]
					+ "\nYou encounter a " + monster.name + "!");
			
			helper.enabler(2);
			helper.setChoiceText("Fight", "Run");
			helper.setNextPosition("fight", "crossRoad");
		}
	}
	
	public void fight() {
		ui.mainTextArea.setText(monster.name + " HP: " + monster.hp
				+ "\n\nWhat do you do?");
		
		switch (weaponCounter) {
		case 0: 
			helper.enabler(2);
			helper.setChoiceText("Stab", "Run");
			helper.setNextPosition("playerAttack", "crossRoad");
			break;
		case 1:
			helper.enabler(2);
			helper.setChoiceText("Slash", "Run");
			helper.setNextPosition("playerAttack", "crossRoad");
			break;
		case 2:
			helper.enabler(3);
			helper.setChoiceText("Cleave", "Smite", "Run");
			helper.setNextPosition("playerAttack", "playerAttack", "crossRoad");
			tooltips.showSkillCD(ui.choice2, smiteCD);
			if (smiteCD > 0) {
				ui.choice2.setEnabled(false);
			}
			break;
		}
	}
	
	
	public void fight2() {
		ui.mainTextArea.setText(monster.name + " HP: " + monster.hp
				+ "\n\nWhat do you do?");
		
		ui.choice1.setText("Fight!");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "playerAttack";
		game.nextPosition2 = "cross";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	
	public void surrenderDIE() {
		helper.enabler(1);
		if (apologize) {
			ui.mainTextArea.setText(ch2Text.apologize[0]);
			player.hp = 0;
			ui.hpLabelNumber.setText(Integer.toString(player.hp));
			
			helper.setChoiceText("Title Screen");
			helper.setNextPosition("returnTitle");
		} else {
			ui.mainTextArea.setText(monster.surrenderMessage);
			player.hp = 0;
			ui.hpLabelNumber.setText(Integer.toString(player.hp));
			
			helper.setChoiceText("Title Screen");
			helper.setNextPosition("returnTitle");
		}
	}
	
	public void playerAttack() {
		ui.choice2.setEnabled(true); // b/c playerAttack() is one of next possible calls after smite button being possibly disabled
		
		smiteCD--;
		int playerDamage = player.currentWeapon.basicAttack();
		if (smiteCD == 0 && player.currentWeapon.name == "LGMI") {
			playerDamage = player.currentWeapon.smite();
			smiteCD = 5;
		}
		monster.hp -= playerDamage;
		
		ui.mainTextArea.setText("You attack the " + monster.name + " for "
				+ playerDamage + " damage!\n\n"
				+ monster.name + " HP: " + monster.hp);
		
		helper.enabler(1);
		helper.setChoiceText(">");
		if (monster.hp >= 1) {
			helper.setNextPosition("monsterAttack");
		} else if (monster.hp <= 0) {
			helper.setNextPosition("win");
		}
	}
	
	
	public void monsterAttack() {
		int monsterDamage = monster.basicAttack();
		player.hp -= monsterDamage;
		
		ui.hpLabelNumber.setText(Integer.toString(player.hp));
		ui.mainTextArea.setText(monster.name + " attacks you for " + monsterDamage + " damage!\n\n"
				+ monster.name + " HP: " + monster.hp);
		
		if (player.hp >= 1) {
			helper.enabler(2);
			helper.setChoiceText("Attack", "Run");
			helper.setNextPosition("playerAttack", "crossRoad");
		} else if (player.hp <= 0) {
			helper.enabler(1);
			helper.setChoiceText("Die");
			helper.setNextPosition("lose");
		}
	}
	
	public void win() {
		silverRing = true;
		ui.mainTextArea.setText("You've defeated the " + monster.name + "! It dropped a silver \nring!"
				+ "\n\n(You obtained Silver Ring, you scummy, \ngrave-robbing bastard.)");
		monster = null;
		
		helper.enabler(1);
		helper.setChoiceText("Go Back");
		helper.setNextPosition("crossRoad");
	}
	
	public void lose() {
		player.hp = 0;
		ui.hpLabelNumber.setText(Integer.toString(player.hp));
		
		if (monster.loseNum == 0) {
			ui.mainTextArea.setText(monster.deathMessage);
		} else if (monster.loseNum == 1) {
			ui.mainTextArea.setText(monster.surrenderMessage);
		}
		
		helper.enabler(1);
		helper.setChoiceText("Title Screen");
		helper.setNextPosition("returnTitle");
	}
	
	public void returnTitle() {
		defaultSetup();
		townGate();
		vm.showTitleScreen();
	}
	
	public void endChapter1() {
		
		ui.mainTextArea.setText("Guard: Oh cool you killed that frail, old goblin"
				+ "\nthat pesters the town folk about littering. "
				+ "\nWelcome, fellow nature hater!");
		
		helper.enabler(1);
		helper.setChoiceText(">");
		helper.setNextPosition("enterTown");
	}
	
	
	/*
	 *  Start of Chapter 2 (lol that was short) code 
	 *  
	 *  
	 *  
	 *  
	 *  
	 */
	
	public void enterTown() {
		ui.mainTextArea.setText(ch2Text.enteringTown[ch2Text.enterTownCounter]);
		ch2Text.enterTownCounter++;
		
		helper.enabler(1);
		helper.setChoiceText(">");
		helper.setNextPosition("crowdGathers");
	}
	
	public void crowdGathers() {
		if (crowdCounter == 0) {
			ui.mainTextArea.setText(ch2Text.crowdGathering[ch2Text.crowdGatherCounter]);
			ch2Text.crowdGatherCounter++;
			
			helper.enabler(1);
			helper.setChoiceText(">");
			helper.setNextPosition("crowdGathers");
			crowdCounter++;
			
		} else if (crowdCounter == 1) {
			ui.mainTextArea.setText(ch2Text.crowdGathering[ch2Text.crowdGatherCounter]);
			ch2Text.crowdGatherCounter++;
			
			helper.enabler(1);
			helper.setChoiceText(">");
			helper.setNextPosition("crowdGathers");
			crowdCounter++;
			
		} else {
			ui.mainTextArea.setText(ch2Text.crowdGathering[ch2Text.crowdGatherCounter]);
			ch2Text.crowdGatherCounter++;
			bigGuyCounter = 0;
			
			helper.enabler(3);
			helper.setChoiceText("Hunchback", "Big Oaf", "Kindergarten-er");
			helper.setNextPosition("bigGuy", "bigGuy", "bigGuy");	
		}
	}
	
	// couldn't get the switch case to work for some reason, went with if/else unfortunately
	public void bigGuy() {
		if (bigGuyCounter == 0) {
			ui.mainTextArea.setText(ch2Text.bigGuy[bigGuyCounter]);
			
			helper.enabler(1);
			helper.setChoiceText(">");
			helper.setNextPosition("bigGuy");
			bigGuyCounter++;
		} else if (bigGuyCounter == 1) {
			ui.mainTextArea.setText(ch2Text.bigGuy[bigGuyCounter]);
			
			monster = new Elder();
			
			bigGuyCounter++;
			
			helper.enabler(2);
			helper.setChoiceText("Fight", "Surrender");
			helper.setNextPosition("bigGuy", "surrenderDIE");
		} else if (bigGuyCounter == 2) {
			ui.mainTextArea.setText(ch2Text.bigGuy[bigGuyCounter]);
			bigGuyCounter++;
			
			player.currentWeapon = new Fists();
			ui.weaponLabelName.setText(player.currentWeapon.getName());
			tooltips.setWeaponLabelNameTTT();
			
			helper.enabler(2);
			helper.setChoiceText("Sucker Punch", "Prepare");
			helper.setNextPosition("bigGuy", "getReady");
		} else if (bigGuyCounter == 3) {
			ui.mainTextArea.setText(ch2Text.bigGuy[bigGuyCounter]);
			bigGuyCounter++;
			
			helper.enabler(2);
			helper.setChoiceText("Kick His Ass", "Prepare Counter");
			helper.setNextPosition("bigGuy", "getReady");
		} else {
			ui.mainTextArea.setText(ch2Text.bigGuy[bigGuyCounter]);
			bigGuyCounter++;
			
			helper.enabler(4);
			helper.setChoiceText("Knock Out", "Knock Out", "Knock Out", "Knock Out");
			helper.setNextPosition("KO", "KO", "KO", "KO");
		}
		
		// sucker punch
		// 			-> sp again / apologize	
		//				-> sp again / apologize				-> die
		//						-> keep punching	
	}
	
	public void getReady() {
		if (bloodrage) {
			ui.mainTextArea.setText(ch2Text.getReady[1]);
			
			helper.enabler(1);
			helper.setChoiceText(">");
			helper.setNextPosition("KO");
		} else {
			ui.mainTextArea.setText(ch2Text.getReady[0]);
			
			bloodrage = true;
			
			helper.enabler(2);
			helper.setChoiceText("Blood Rage", "Lie There");
			helper.setNextPosition("bigGuy", "lieThere");
		}
	}
	
	// got lazy, made it its own method, put text in apologize b/c of laziness, too
	public void lieThere() {
		ui.mainTextArea.setText(ch2Text.apologize[1]);
		
		helper.enabler(1);
		helper.setChoiceText("Return to Title");
		helper.setNextPosition("returnTitle");
	}
	
	public void KO() {
		if (bloodrage) {
			ui.mainTextArea.setText(ch2Text.KO[0]);
			
			helper.enabler(1);
			helper.setChoiceText("End");
			helper.setNextPosition("End");
		} else {
			ui.mainTextArea.setText(ch2Text.KO[1]);
			
			helper.enabler(1);
			helper.setChoiceText("End");
			helper.setNextPosition("end");
		}
	}
	
	public void end() {
		ui.mainTextArea.setText(ch2Text.end);
		
		helper.setChoiceText("Return To Title");
		helper.setNextPosition("returnTitle");
	}
}
