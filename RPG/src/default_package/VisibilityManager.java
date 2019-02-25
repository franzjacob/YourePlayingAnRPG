package default_package;

public class VisibilityManager {

	UI ui;
	
	public VisibilityManager(UI userInterface) {
		
		this.ui = userInterface;
	}
	
	public void showTitleScreen() {
		
		// show title screen
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		
		// hide game screen elements
		ui.playerPanel.setVisible(false);
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
	}
	
	public void titleToTown() {
		
		// show title screen
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
				
		// hide game screen elements
		ui.playerPanel.setVisible(true);
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
	}
}
