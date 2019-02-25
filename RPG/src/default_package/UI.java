package default_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import default_package.Game.ChoiceHandler;

public class UI {

	JFrame window;
	JPanel titleNamePanel, startButtonPanel, playerPanel, mainTextPanel, choiceButtonPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 60);
	Font italicFont = new Font("Times New Roman", Font.ITALIC, 60);
	Font longFont = new Font("Times New Roman", Font.PLAIN, 40);
	
	
	
	public void createUI(ChoiceHandler cHandler) {
		 // WINDOW
		
		window = new JFrame();
		window.setSize(1920, 1080);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		// TITLE SCREEN
		titleNameLabel = new JLabel("<html>YOU'RE PLAYING AN<br/> ----------------------> RPG</html>");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(480, 250, 930, 200);
		titleNamePanel.setBackground(Color.red);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(780, 600, 300, 150);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("BEGIN");
		startButton.setBackground(Color.green);
		startButton.setForeground(Color.black);
		startButton.setFocusPainted(false);
		startButton.setFont(normalFont);
		startButton.addActionListener(cHandler);
		startButton.setActionCommand("start");
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		window.add(titleNamePanel);
		window.add(startButtonPanel);
		
		
		// GAME SCREEN
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(300, 50, 1400, 100);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		
		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		
		//weaponLabel.setToolTipText("<html><p height='500'><font size='60'>" + "Currently Equipped Weapon" + "<br>" + "THIS IS UR WEAPON"  + "</font></p></html>");
		
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(300, 180, 1200, 350);
		mainTextPanel.setBackground(Color.black);
		
		mainTextArea = new JTextArea("This is the Main Text Area. This game is gonna be dope af");
		mainTextArea.setBounds(300, 180, 1200, 350);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);  // if text line is too long, it will start new line automatically
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(700, 600, 500, 300);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));  // customized layout, 4 rows, 1 column
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("c1");  // what differentiates events between choices , so they dont all return the same thing
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("c2");
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(cHandler);
		choice3.setActionCommand("c3");
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(cHandler);
		choice4.setActionCommand("c4");
		
		playerPanel.add(hpLabel);
		playerPanel.add(hpLabelNumber);
		playerPanel.add(weaponLabel);
		playerPanel.add(weaponLabelName);
		
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel.add(choice1);
		choiceButtonPanel.add(choice2);
		choiceButtonPanel.add(choice3);
		choiceButtonPanel.add(choice4);
		
		window.add(playerPanel);
		window.add(mainTextPanel);
		window.add(choiceButtonPanel);
		
		
		mainTextArea.setEditable(false);
		
		
		window.setVisible(true);
		
		
	}
}
