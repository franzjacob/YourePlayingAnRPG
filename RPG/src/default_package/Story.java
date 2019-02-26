package default_package;

import java.util.Random;

import monster_package.DeathWizard;
import monster_package.Goblin;
import monster_package.Elder;
import monster_package.SuperMonster;
import speech_package.Chapter1Bits;
import speech_package.TownGate;
import speech_package.TownGuard1;
import weapon_package.Knife;
import weapon_package.LegendaryCleaver;
import weapon_package.LongSword;

public class Story {

	Game game;
	UI ui;
	VisibilityManager vm;
	Player player;
	SuperMonster monster;
	
	// contextual text/monologues
	TownGuard1 townGuard;
	TownGate townGate;
	Chapter1Bits ch1Text;
	
	// triggers for story/text events
	boolean silverRing;
	boolean talkedToGuard;
	boolean hitGuard;
	boolean seenCrossRoad;
	int talkedToGuardCounter;
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
	}
	
	// sets values for start of game
	public void defaultSetup() {
		player = new Player();
		player.hp = 10;
		ui.hpLabelNumber.setText(Integer.toString(player.hp));
		
		player.currentWeapon = new Knife();
		ui.weaponLabelName.setText(player.currentWeapon.name);
		//ui.weaponLabel.setToolTipText();
		
		townGuard = new TownGuard1();
		townGate = new TownGate();
		ch1Text = new Chapter1Bits();
		
		silverRing = false;
		talkedToGuard = false;
		hitGuard = false;
		seenCrossRoad = false;
		
		talkedToGuardCounter = 0;
		townGateCounter = 0;
		swordCounter = 0;
		crowdCounter = 0;
		bigGuyCounter = 0;
		weaponCounter = 0;
		
		smiteCD = 5;
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
		}
	}
	
	public void townGate() {
		String default_s = "You are standing at the gate of the town"
				+ "\nA guard blocks the entrance"
				+ "\n\nWhat do you do?";
		Random r = new Random();
		
		if (!seenCrossRoad) {
			ui.mainTextArea.setText(default_s);
		} else {
			ui.mainTextArea.setText(townGate.contextual_monologues[r.nextInt(5)]);
		}
		
		if (talkedToGuardCounter >= 7) {
			setChoiceText("PESTER!", "Attack the Guard", "Leave");
		} else if (talkedToGuardCounter > 3) {
			setChoiceText("Pester Guard", "Attack the Guard", "Leave");
		} else if (talkedToGuardCounter > 0) {
			setChoiceText("Ask Guard Again", "Attack the Guard", "Leave");
		} else {
			setChoiceText("Ask Guard", "Attack the Guard", "Leave");
		}
		
		townGateCounter++;
		setNextPosition("talkGuard", "attackGuard", "crossRoad");
	}
	
	public void talkGuard() {
		talkedToGuard = true;
		Random r = new Random();
		if (!silverRing) {
			if (talkedToGuardCounter == 7) {
				ui.mainTextArea.setText(townGuard.last_straw[r.nextInt(3)]);
				setChoiceText(">");
				setNextPosition("attackGuard");
			} else if (talkedToGuardCounter < 7 && talkedToGuardCounter > 3) {
				ui.mainTextArea.setText(townGuard.extra_monologues[r.nextInt(4)]);
				talkedToGuardCounter++;
				setChoiceText(">");
				setNextPosition("townGate");
			} else if (talkedToGuardCounter < 4 && talkedToGuardCounter > 0) {
				ui.mainTextArea.setText(townGuard.nonviolent_monologues[r.nextInt(6)]);
				talkedToGuardCounter++;
				setChoiceText(">");
				setNextPosition("townGate");
			} else {
				ui.mainTextArea.setText("\"You are an outsider. I do not know you."
						+ "\nBegone, miscreant.\"");
				talkedToGuardCounter++;
				setChoiceText(">");
				setNextPosition("townGate");
			}
			
		} else {
			endChapter1();
		}
	}
	
	public void attackGuard() {
		if (talkedToGuardCounter == 7) {
			player.hp = 0;
			ui.hpLabelNumber.setText(Integer.toString(player.hp));
			ui.mainTextArea.setText("The guard straight up killed you, you annoying,"
					+ "\npersistent, asshat."
					+ "\nYou're, like, mega dead.");
			setChoiceText("Return to Title");
			setNextPosition("returnTitle");
			
		} else {
			Random r = new Random();
			player.hp -= 3;
			hitGuard = true;
			ui.hpLabelNumber.setText(Integer.toString(player.hp));
			ui.mainTextArea.setText(townGuard.contextual_monologues[r.nextInt(5)]
					+ "\n(Guard backhands you. Take 3 damage)");
			
			if (player.hp > 0) {
				setChoiceText(">");
				setNextPosition("townGate");
			} else {
				setChoiceText("You Died");
				setNextPosition("returnTitle");
			}
		}
	}
	
	public void crossRoad() {
		seenCrossRoad = true;
		ui.mainTextArea.setText("You are at a crossroad. Taking the southern"
				+ "\nroute will return you to the town."
				+ "\n\nWhat do you do?");
		
		setChoiceText("Go North", "Go East", "Go South", "Go West");
		setNextPosition("north", "east", "townGate", "west");
	}
	
	public void north() {
		player.hp += 3;
		ui.hpLabelNumber.setText(Integer.toString(player.hp));
		ui.mainTextArea.setText("You find a pond and drink from its cool water."
				+ "\n\n(Not the most sanitary thing, but eh. Gain 3 \nhealth.)");
		
		setChoiceText(">");
		setNextPosition("crossRoad");
	}
	
	
	public void east() {
		
		if (swordCounter <= 4) {
			player.currentWeapon = new LongSword();
			ui.weaponLabelName.setText(player.currentWeapon.name);
			ui.mainTextArea.setText(ch1Text.east[swordCounter]);
			swordCounter++;
			weaponCounter = 1;
			
			setChoiceText(">");
			setNextPosition("crossRoad");
		} else if (swordCounter == 5){
			player.currentWeapon = new LegendaryCleaver();
			ui.weaponLabelName.setText(player.currentWeapon.name);
			ui.mainTextArea.setText(ch1Text.east[swordCounter]);
			swordCounter++;
			weaponCounter = 2;
			
			setChoiceText(">");
			setNextPosition("crossRoad");
		} else {
			ui.mainTextArea.setText(ch1Text.east[ch1Text.east.length - 1]);
			
			setChoiceText(">");
			setNextPosition("crossRoad");
		}
	}
	
	public void west() {
		int r = new Random().nextInt(101);
		if (r < 90 && !silverRing) {
			monster = new Goblin();
			
			ui.mainTextArea.setText("You encounter a " + monster.name + "!");
			
			setChoiceText("Fight", "Run");
			setNextPosition("fight", "crossRoad");
		} else if (r > 90 && silverRing) {
			monster = new DeathWizard();
			
			ui.mainTextArea.setText("Despite being daytime, darkness eminates from"
					+ "\na person in front of you. They're not friendly."
					+ "\nYou encounter a " + monster.name + "!");
			
			setChoiceText("Fight", "Run");
			setNextPosition("fight", "crossRoad");
		} else {
			ui.mainTextArea.setText("All that remains is the corpse of the slain"
					+ "\ngoblin. Its peaceful existence has come to a"
					+ "\npremature end, thanks to you.");
		}
	}
	
	public void fight() {
		ui.mainTextArea.setText(monster.name + " HP: " + monster.hp
				+ "\n\nWhat do you do?");
		
		switch (weaponCounter) {
		case 0: 
			setChoiceText("Stab", "Run");
			setNextPosition("playerAttack", "crossRoad");
			break;
		case 1:
			setChoiceText("Slash", "Run");
			setNextPosition("playerAttack", "crossRoad");
			break;
		case 2:
			setChoiceText("Cleave", "Smite", "Run");
			setNextPosition("playerAttack", "playerAttack", "crossRoad");
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
	
	
	public void surrender() {
		
	}
	
	public void playerAttack() {
		
		int playerDamage = player.currentWeapon.basicAttack();
		if (smiteCD == 0 && player.currentWeapon.name == "LGMI") {
			playerDamage = player.currentWeapon.smite();
			smiteCD = 5;
		}
		monster.hp -= playerDamage;
		
		ui.mainTextArea.setText("You attack the " + monster.name + " for "
				+ playerDamage + " damage!\n\n"
				+ monster.name + " HP: " + monster.hp);
		
		setChoiceText(">");
		if (monster.hp >= 1) {
			setNextPosition("monsterAttack");
		} else if (monster.hp <= 0) {
			setNextPosition("win");
		}
	}
	
	
	public void monsterAttack() {
		Random r = new Random();
		int max = monster.attack;
		int min = monster.attack / 2;
		int monsterDamage = r.nextInt((max - min) - 1) + min;
		player.hp -= monsterDamage;
		
		ui.hpLabelNumber.setText(Integer.toString(player.hp));
		ui.mainTextArea.setText(monster.name + " attacks you for " + monsterDamage + " damage!\n\n"
				+ monster.name + " HP: " + monster.hp);
		
		if (player.hp >= 1) {
			setChoiceText("Attack", "Run");
			setNextPosition("playerAttack", "crossRoad");
		} else if (player.hp <= 0) {
			setChoiceText("Die");
			setNextPosition("lose");
		}
	}
	
	public void win() {
		silverRing = true;
		ui.mainTextArea.setText("You've defeated the " + monster.name + "! It dropped a silver \nring!"
				+ "\n\n(You obtained Silver Ring, you scummy, \ngrave-robbing bastard.)");
		monster = null;
		
		setChoiceText("Go East");
		setNextPosition("crossRoad");
	}
	
	public void lose() {
		player.hp = 0;
		ui.hpLabelNumber.setText(Integer.toString(player.hp));
		
		if (monster.loseNum == 0) {
			ui.mainTextArea.setText(monster.deathMessage);
		} else if (monster.loseNum == 1) {
			ui.mainTextArea.setText(monster.surrenderMessage);
		}
		
		setChoiceText("Title Screen");
		setNextPosition("returnTitle");
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
		
		setChoiceText(">");
		setNextPosition("enterTown");
	}
	
	
	/*
	 *  Start of Chapter 2 code 
	 *  
	 *  
	 *  
	 *  
	 *  
	 */
	
	public void enterTown() {
		ui.mainTextArea.setText("You enter the town and you instantly regret the"
				+ "\ndecision. The place is littered with rubbage and"
				+ "\nsewage. The people look as horrid as they smell."
				+ "\nA crowd gathers.");
		
		setChoiceText(">");
		setNextPosition("crowdGathers");
	}
	
	public void crowdGathers() {
		if (crowdCounter == 0) {
			ui.mainTextArea.setText("\"Anotha' fookin' outsider, eh? Well, if ya really" 
					+ "\nreally wans in to er lovely lil' place ere', youse"
					+ "\ngonna 'ave to prove you can hang with us!\""
					+ "\n(The crowd cheers)");
			
			setChoiceText(">");
			setNextPosition("crowdGathers");
			crowdCounter++;
			
		} else if (crowdCounter == 1) {
			ui.mainTextArea.setText("\"Yuh may have gottin past our fookin' guard" 
					+ "\nsomeone in the crowd yells 'Fuck you, Gary!'), "
					+ "\nbut yull 'ave to get passed us if ya wanna stay."
					+ "\nWe'll let ya pick who gets to beat ya, tho.\"");
			
			setChoiceText(">");
			setNextPosition("crowdGathers");
			crowdCounter++;
			
		} else {
			ui.mainTextArea.setText("The brute before you waves his hand and the"
					+ "\ncrowd parts. Three people step forth from the"
					+ "\nmass of people: a hunched, shrouded figure; "
					+ "\na drunken oaf; and a small child. "
					+ "\n\"So who's it gonna be?\"");
			
			setChoiceText("Hunchback", "Big Oaf", "Kindergarten-er");
			setNextPosition("bigGuy", "bigGuy", "bigGuy");	
		}
	}
	
	public void bigGuy() {
		if (bigGuyCounter == 0) {
			ui.mainTextArea.setText("*THUD THUD THUD*"
					+ "\nThe crowd falls silent and you witness a panic"
					+ "\nset in on their pale faces Another figure enters"
					+ "\nthe scene, but it towers over the rest.");
			
			setChoiceText(">");
			setNextPosition("bigGuy");
			bigGuyCounter++;
			
		} else if (bigGuyCounter == 1) {
			ui.mainTextArea.setText("\"This isn't some game. There will be no"
					+ "\nchoosing today. It's my turn to fight.\"");
			
			monster = new Elder();
			
			setChoiceText("Fight!", "Surrender");
			setNextPosition("fight2", "lose");
		}
	}
	
	
	// helper functions for setting choice text and variables, so I don't have to repeat so much code all the damn time
	private void setChoiceText(String a) {
		setChoiceText(a, null);
	}
	
	private void setChoiceText(String a, String b) {
		setChoiceText(a, b, null);
	}
	
	private void setChoiceText(String a, String b, String c) {
		setChoiceText(a, b, c, null);
	}
	
	private void setChoiceText(String a, String b, String c, String d) {
		ui.choice1.setText(a);
		ui.choice2.setText(b);
		ui.choice3.setText(c);
		ui.choice4.setText(d);
	}
	
	private void setNextPosition(String a) {
		setNextPosition(a, null);
	}
	
	private void setNextPosition(String a, String b) {
		setNextPosition(a, b, null);
	}
	
	private void setNextPosition(String a, String b, String c) {
		setNextPosition(a, b, c, null);
	}
	
	private void setNextPosition(String a, String b, String c, String d) {
		game.nextPosition1 = a;
		game.nextPosition2 = b;
		game.nextPosition3 = c;
		game.nextPosition4 = d;
	}
	
	
	

}
