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
	public String[] getReady;
	public String end;
	
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
						+ "\n\"WE HAVEN'T STARTED YET. STOP "
						+ "\nHITTING ME.\""
		};
		apologize = new String[] {
				"\"Um, that...I thought we had sta-\", you manage"
						+ "\nto blerp out before you're promptly mobbed"
						+ "\nto death by the crowd and your opponent."
						+ "\n"
						+ "\nWe have no place for the dishonorable here.\","
						+ "\nsays the Elder, standing over your corpse.",
				"\"Pity, I thought we were gonna this people a good"
						+ "\nshow\". There's a tinge of dissappointment and"
						+ "resentment in the Elder's voice as he crushes"
						+ "your skull underfoot, not that you would've"
						+ "\nnoticed anyways, since you're dead."
		};
		getReady = new String[] {
				"\"No amount of foresight could have prepared you"
						+ "\nfor the slap-of-god backhand from the Elder."
						+ "\nYou're face down in the mud. People heckle you"
						+ "\nand throw vegetables."
						+ "The Elder bellows, \"Looks like the outsider"
						+ "\ndoesn't have much in him.\"",
				"This doesn't really constitute much as public shaming."
						+ "\nStill, this snide remark hits you in your little"
						+ "\nsensitive core and you black out in a fit of fury."
						+ "\nThe last things you see before everything fades "
						+ "\ninto obscurity are dark red stripes in the air,"
						+ "\npainting the night sky like a macabre canvas."
		};
		KO = new String[] {
				"You wake, standing, to find the crowd quietly dispersing."
						+ "\nThe Elder lies beneath you, in shreds."
						+ "\nYou get the feeling that you should probably go"
						+ "\n\"So, uh, I'll be off then.\""
						+ "You here a quiet cough and a simulataneous "
						+ "\n\"...dick\". You think that's a fair assessment.",
				"The crowd is so amped up by the spectacle that "
						+ "\nthey get whipped into a frenzy and start "
						+ "\nfighting amongst themselves."
						+ "\nYou nope out of there so quick."
		};
		end = "You sheepishly scurry out of the town and find"
				+ "\nyourself back at the crossroads."
				+ "\nSucks to be back where you pretty much began."
				+ "\n"
				+ "\nYup, that's it. A lot happened, and a lot didn't.";
				
		enterTownCounter = 0;
		crowdGatherCounter = 0;
	}
}
