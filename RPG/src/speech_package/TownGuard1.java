package speech_package;

public class TownGuard1 extends SuperMonologues{
	
	public String[] nonviolent_monologues;
	public String[] last_straw;

	public TownGuard1() {
		// text for when u attack guard
		contextual_monologues = new String[] {
				"\"You're back. Hmph, must like getting slapped..."
				+ "\none of those, freaks, eh?\"",
				"\"If you provoke me again, I won't hesitate"
				+ "\nto put you in your place again, peasant.\"",
				"\"You've returned...but nothing has changed. I'm"
				+ "\nstill wearing gauntlets and you're still an"
				+ "\nannoying piece of trash.\"",
				"\"Someone hasn't learn their lesson, obviously.\"",
				"\"Oh, you're back...Surprise, surprise....\"",
				"\"Back for more, eh?\""
		};
		// text for when u ask again
		nonviolent_monologues = new String[] {
				"\"Oh, hi, uh, again. New question or...*sigh*\"",
				"\"Lemme guess, you want to get in....again.\"",
				"\"...You're back. Great. What's your query?\"",
				"\"If you're here asking about getting in again,"
				+ "\nprepare to be dissappointed, again.\"",
				"\"Peasant, what is it now?\"",
				"\"I cannot spend all day rejecting you from"
				+ "\nmy town. I just can not.\""
		};
		// text for pestering
		extra_monologues = new String[] {
				"\"My god, FUCK OFF!\"",
				"\"So is this going to be a recurring thing?"
				+ "\nIf so, EXPECT TO GET LAID OUT, BRUV.\"",
				"\"I SWEAR to GOD someone is about to CATCH "
				+ "\nthese HANDS. BET.\"",
				"\"YOU FINNA GET FADED, SON. GONNA LAY YOU OUT"
				+ "\nIF YOU KEEP BUGGING ME.\""				
		};
		// text right before guard kills player
		last_straw = new String[] {
				"\"Dave! Get your arse over here. This asshole"
				+ "\nis done. I've had it. I'm ending him."
				+ "\nLike, goddamn. HE'S DONE.\"",
				"\"NOPE. I AM SO DONE. LIGHTS OUT TIME.\"",
				"(The Guard unsheathes his sword and slowly"
				+ "\nwalks towards you)"
		};
	}
}
