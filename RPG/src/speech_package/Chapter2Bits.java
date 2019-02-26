package speech_package;

/*
 * since a lot of the narrator's speech occurs linearly, I'm putting them in this class and then calling
 * the index of the correct text to cut down on lines in Story.java
 * 
 */

public class Chapter2Bits {

	public String[] enteringTown;
	public String[] crowdGathering;
	public String[] bigGuy;
	
	public int enterTownCounter;
	public int crowdGatherCounter;
	public int bigGuyCounter;
	
	public Chapter2Bits() {
		enteringTown = new String[] {
				"You enter the town and you instantly regret the"
						+ "\ndecision. The place is littered with rubbage and"
						+ "\nsewage. The people look as horrid as they smell."
						+ "\nA crowd gathers."
		};
		crowdGathering = new String[] {
				"\"Anotha' fookin' outsider, eh? Well, if ya really" 
						+ "\nreally wans in to er lovely lil' place ere', youse"
						+ "\ngonna 'ave to prove you can hang wit us!\""
						+ "\n(The crowd cheers)",
				"\"Yuh may have gottin past our fookin' guard" 
						+ "\nsomeone in the crowd yells 'Fuck you, Gary!'), "
						+ "\nbut yull 'ave to get passed us if ya wanna stay."
						+ "\nWe'll let ya pick who gets to beat ya, tho.\"",
				"The brute before you waves his hand and the"
						+ "\ncrowd parts. Three people step forth from the"
						+ "\nmass of people: a hunched, shrouded figure; "
						+ "\na drunken oaf; and a small child. "
						+ "\n\"So who's it gonna be?\""
		};
		bigGuy = new String[] {
				"*THUD THUD THUD*"
						+ "\nThe crowd falls silent and you witness a panic"
						+ "\nset in on their pale faces Another figure enters"
						+ "\nthe scene, but it towers over the rest.",
				"\"This isn't some game. There will be no"
						+ "\nchoosing today. It's my turn to fight.\""
		};
		enterTownCounter = 0;
		crowdGatherCounter = 0;
		bigGuyCounter = 0;
	}
}
