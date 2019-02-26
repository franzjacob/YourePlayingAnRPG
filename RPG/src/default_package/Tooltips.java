package default_package;

import javax.swing.JButton;

import monster_package.SuperMonster;

public class Tooltips {

	
	UI ui;
	Game game;
	Player player;
	SuperMonster monster;
	
	String opening_html = "<html><p height='500'><font size='60'>";
	String closing_html = "</font></p></html>";
	
	public Tooltips(UI ui, Game game, Player player, SuperMonster monster) {
		this.ui = ui;
		this.game = game;
		this.player = player;
		this.monster = monster;
	}
	
	public void setWeaponLabelNameTTT() {
		ui.weaponLabelName.setToolTipText(opening_html
				+ "Weapon Damage: " + player.currentWeapon.getMin() + " - "
				+ player.currentWeapon.getMax() + closing_html);
	}
	
	public void setWeaponLabelTTT() {
		ui.weaponLabel.setToolTipText(opening_html
				+ "Currently Equipped Weapon" + closing_html);
	}
	
	// have two tooltiptext setters here because we will never have to change these
	// after game start
	public void setHealthTTT() {
		ui.hpLabel.setToolTipText(opening_html
				+ "Current Health Count" + closing_html);
		ui.hpLabelNumber.setToolTipText(opening_html
				+ "If this number reaches 0, you lose" + closing_html);
	}
	
	// show how long the CD is on a skill/attack. takes a parameters because the button that this will
	// show up on will change
	public void showSkillCD(JButton jbutton, int cd) {
		jbutton.setToolTipText(opening_html 
				+ "Attacks till off CD: " + cd + closing_html);
	}
	
	
}
