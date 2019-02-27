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
	public String[] apologize;
	public String[] KO;
	
	public int enterTownCounter;
	public int crowdGatherCounter;
	// got rid of bigGuyCounter b/c there is a similar thing like that already in Story.java
	
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
						+ "\nset in on their pale faces. Another figure enters"
						+ "\nthe scene, but it towers over the rest.",
				"\"This isn't some game. There will be no"
						+ "\nchoosing today. It's my turn to fight.\"",
				"Take away his gear! We fight with fists."
						+ "\n"
						+ "\nThe crows cheers. You surmise it's been quite "
						+ "\nsome time since they've witnessed a bloodsport.",
				"Your punch lands a lot harder than you expected."
						+ "\nEveryone goes quiet. The Elder is frozen in a "
						+ "\na state of disbelief."
						+ "\n\"What the...You're dead. You're so dead.\"",
				"\"OOOOOO\", the crowd is reacting positively to"
						+ "\nyour shots, surprisngly. The Elder is not having"
						+ "\nit, and his face isn't holding up too well."
						+ "\n\"WE HAVEN'T STARTED YET. STOP HITTING ME\"."
		};
		apologize = new String[] {
				"\"Um, that...I thought we had sta-\", you manage"
						+ "\nto blerp out before you're promptly mobbed"
						+ "\nto death by the crowd and your opponent."
						+ "\n"
						+ "\nWe have no place for the dishonorable here.\","
						+ "\nsays the Elder, standing over your corpse."
		};
		enterTownCounter = 0;
		crowdGatherCounter = 0;
	}
}
