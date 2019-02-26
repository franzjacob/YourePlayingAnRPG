package default_package;

public class Helper {

	UI ui;
	Game game;
	
	public Helper(UI ui, Game game) {
		this.ui = ui;
		this.game = game;
	}
	
	public void setChoiceText(String a) {
		setChoiceText(a, null);
	}
	
	public void setChoiceText(String a, String b) {
		setChoiceText(a, b, null);
	}
	
	public void setChoiceText(String a, String b, String c) {
		setChoiceText(a, b, c, null);
	}
	
	public void setChoiceText(String a, String b, String c, String d) {
		ui.choice1.setText(a);
		ui.choice2.setText(b);
		ui.choice3.setText(c);
		ui.choice4.setText(d);
	}
	
	public void setNextPosition(String a) {
		setNextPosition(a, null);
	}
	
	public void setNextPosition(String a, String b) {
		setNextPosition(a, b, null);
	}
	
	public void setNextPosition(String a, String b, String c) {
		setNextPosition(a, b, c, null);
	}
	
	public void setNextPosition(String a, String b, String c, String d) {
		game.nextPosition1 = a;
		game.nextPosition2 = b;
		game.nextPosition3 = c;
		game.nextPosition4 = d;
	}
	
	public void greyout3() {
		ui.choice2.setEnabled(false);
		ui.choice3.setEnabled(false);
		ui.choice4.setEnabled(false);
	}

	public void greyout2() {
		ui.choice3.setEnabled(false);
		ui.choice4.setEnabled(false);
	}
	
	public void greyout1() {
		ui.choice4.setEnabled(false);
	}
	
	public void enable3() {
		ui.choice2.setEnabled(true);
		ui.choice3.setEnabled(true);
		ui.choice4.setEnabled(true);
	}
	
	public void enable2() {
		ui.choice3.setEnabled(true);
		ui.choice4.setEnabled(true);
	}
	
	public void enable1() {
		ui.choice4.setEnabled(true);
	}
}
