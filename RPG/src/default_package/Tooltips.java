package default_package;

import monster_package.SuperMonster;

public class Tooltips {

	
	UI ui;
	Game game;
	Player player;
	SuperMonster monster;
	
	public Tooltips(UI ui, Game game, Player player, SuperMonster monster) {
		this.ui = ui;
		this.game = game;
		this.player = player;
		this.monster = monster;
	}
	
	public void setWeaponLabelNameTTT() {
		ui.weaponLabelName.setToolTipText("<html><p height='500'><font size='60'>"
				+ "Weapon Damage: " + player.currentWeapon.getMin() + " - "
				+ player.currentWeapon.getMax() + "</font></p></html>");
	}
	
	
}
