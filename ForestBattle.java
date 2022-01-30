import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.*;
import java.util.*;
public class ForestBattle{
	public JFrame frame = new JFrame();
	public JTextField text = new JTextField();
	public JPanel playerOptions = new JPanel();
	public JLabel background = new JLabel();
	public JTextArea characterInfo = new JTextArea();
	public JTextArea enemyInfo = new JTextArea();
	public ActionListener listener = new ButtonListener();
	public JButton buttonAttack = new JButton("attack");
	public JButton buttonDefense = new JButton("defense");
	public JButton buttonMagic = new JButton("magic");
	public JButton buttonItems = new JButton("items");
	public Player player;
	public Hunter hunter;
	public Wizard wizard;
	public Cleric cleric;
	public Goblin goblin;
	public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}
	public ForestBattle() throws IOException {
		player = new Player(100,10,10);
		hunter = new Hunter(100,10,10);
		wizard = new Wizard(100,10,10);
		cleric = new Cleric(100,10,10);
		goblin = new Goblin(100,10,10);
		frame.setSize(500,500);
		text.setText("You find yourself in battle!");
		text.setBackground(Color.BLACK);
		text.setForeground(Color.WHITE);
		frame.setLayout(new BorderLayout());
		buttonAttack.addActionListener(listener);
		buttonDefense.addActionListener(listener);
		buttonMagic.addActionListener(listener);
		buttonItems.addActionListener(listener);
		Player player = new Player(100,10,10);
		Hunter hunter = new Hunter(100,10,10);
		Wizard wizard = new Wizard(100,10,10);
		Cleric cleric = new Cleric(100,10,10);
		Goblin goblin = new Goblin(100,10,10);
		characterInfo.setText(characterInfo.getText()+player+"\n");
		characterInfo.setText(characterInfo.getText()+hunter+"\n");
		characterInfo.setText(characterInfo.getText()+wizard+"\n");
		characterInfo.setText(characterInfo.getText()+cleric+"\n");
		characterInfo.setBackground(Color.BLACK);
		characterInfo.setForeground(Color.WHITE);
		enemyInfo.setText(enemyInfo.getText()+goblin+"\n");
		enemyInfo.setBackground(Color.BLACK);
		enemyInfo.setForeground(Color.WHITE);
		playerOptions.setLayout(new GridLayout(4,1));
		playerOptions.add(buttonAttack);
		playerOptions.add(buttonDefense);
		playerOptions.add(buttonMagic);
		playerOptions.add(buttonItems);
		//Establish Forest background scenary
		URL forestBackgroundUrl = new URL("https://i.pinimg.com/originals/af/54/2d/af542d89a7722b3ba7d078247d3314fe.gif");
		BufferedImage bufferedImage = ImageIO.read(forestBackgroundUrl);
		Image image = bufferedImage.getScaledInstance(frame.getWidth(),frame.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(image);
		background.setIcon(icon);
		//Add all necessary components to Border JFrame.
		frame.add(background,BorderLayout.CENTER);
		frame.add(text,BorderLayout.NORTH);
		frame.add(characterInfo,BorderLayout.SOUTH);
		frame.add(enemyInfo,BorderLayout.EAST);
		frame.add(playerOptions,BorderLayout.WEST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Run attack sequence if player chooses attack.
			if(e.getSource() == buttonAttack) {
				text.setText("You used attack!");
				int powPlayer = player.fight();
				int powHunter = player.fight();
				text.setText(text.getText() + ": Player did" + powPlayer + "damage.\n Hunter did: " + powHunter + "damage");
				goblin.setHealth(goblin.getHealth()-powPlayer);
				goblin.setHealth(goblin.getHealth()-powHunter);
				int powerGoblin = goblin.fight();
				text.setText(text.getText() + " Goblin does: " + powerGoblin + " damage!");
				player.setHealth(player.getHealth()-powerGoblin);
				hunter.setHealth(hunter.getHealth()-powerGoblin);
				wizard.setHealth(wizard.getHealth()-powerGoblin);
				cleric.setHealth(cleric.getHealth()-powerGoblin);
			}
			//Run defense sequence if player chooses defense.
			if(e.getSource() == buttonDefense) {
				text.setText("You used defend!");
				int blockPlayer = player.block();
				int blockHunter = hunter.block();
				int blockCleric = cleric.block();
				int blockWizard = wizard.block();
				int powGoblin = goblin.fight();
				int playerDamage = powGoblin - blockPlayer;
				int hunterDamage = powGoblin - blockHunter;
				int clericDamage = powGoblin - blockCleric;
				int wizardDamage = powGoblin - blockWizard;
				if(playerDamage > 0) {
					text.setText(text.getText() + " Goblin does: " + playerDamage + " to player!");
					player.setHealth(player.getHealth() - playerDamage);
				}
				if(hunterDamage > 0) {
					text.setText(text.getText() + " Goblin does: " + hunterDamage + " to hunter!");
					hunter.setHealth(hunter.getHealth() - hunterDamage);
				}
				if(clericDamage > 0) {
					text.setText(text.getText() + " Goblin does: " + clericDamage + " to cleric!");
					cleric.setHealth(cleric.getHealth() - clericDamage);
				}
				if(wizardDamage > 0) {
					text.setText(text.getText() + " Goblin does: " + wizardDamage + " to wizard!");
					wizard.setHealth(wizard.getHealth() - wizardDamage);
				}
			}
			//Run magic sequence if player chooses magic.
			if(e.getSource() == buttonMagic) {
				text.setText("You used magic!");
				int attackMagic = wizard.castSpell();
				int healingMagic = cleric.heal();
				text.setText(text.getText() + " Wizard does: " + attackMagic + " to goblin!");
				goblin.setHealth(goblin.getHealth()-attackMagic);
				text.setText(text.getText() + " Cleric heals party by: " + healingMagic + " points!");
				player.setHealth(player.getHealth()+healingMagic);
				hunter.setHealth(hunter.getHealth()+healingMagic);
				wizard.setHealth(wizard.getHealth()+healingMagic);
				cleric.setHealth(cleric.getHealth()+healingMagic);
				if(player.getHealth() >= 100) {
					player.setHealth(100);
				}
				if(hunter.getHealth() >= 100) {
					hunter.setHealth(100);
				}
				if(wizard.getHealth() >= 100) {
					wizard.setHealth(100);
				}
				if(cleric.getHealth() >= 100) {
					cleric.setHealth(100);
				}
				int powerGoblin = goblin.fight();
				text.setText(text.getText() + " Goblin does: " + powerGoblin + " damage!");
				player.setHealth(player.getHealth()-powerGoblin);
				hunter.setHealth(hunter.getHealth()-powerGoblin);
				wizard.setHealth(wizard.getHealth()-powerGoblin);
				cleric.setHealth(cleric.getHealth()-powerGoblin);
			}
			//Run item use sequence if player chooses item.
			if(e.getSource() == buttonItems) {
				text.setText("You used Items!");
				int potionPower = (int)(Math.random() * 20);
				text.setText(text.getText() + " You used a potion! Potion does: " + potionPower + " healing points!");
				player.setHealth(player.getHealth()+potionPower);
				hunter.setHealth(hunter.getHealth()+potionPower);
				wizard.setHealth(wizard.getHealth()+potionPower);
				cleric.setHealth(cleric.getHealth()+potionPower);
				if(player.getHealth() >= 100) {
					player.setHealth(100);
				}
				if(hunter.getHealth() >= 100) {
					hunter.setHealth(100);
				}
				if(wizard.getHealth() >= 100) {
					wizard.setHealth(100);
				}
				if(cleric.getHealth() >= 100) {
					cleric.setHealth(100);
				}
				int powerGoblin = goblin.fight();
				text.setText(text.getText() + " Goblin does: " + powerGoblin + " damage!");
				player.setHealth(player.getHealth()-powerGoblin);
				hunter.setHealth(hunter.getHealth()-powerGoblin);
				wizard.setHealth(wizard.getHealth()-powerGoblin);
				cleric.setHealth(cleric.getHealth()-powerGoblin);
			}
			if(goblin.getHealth() <= 0) {
				goblin.setHealth(0);
				text.setText("Victory!");
			}
			if(player.getHealth()<=0&&hunter.getHealth()<=0&&wizard.getHealth()<=0&&cleric.getHealth()<=0) {
				player.setHealth(0);
				hunter.setHealth(0);
				wizard.setHealth(0);
				cleric.setHealth(0);
				text.setText("You're party was defeated! Game Over!");
			}
			characterInfo.setText(player+"\n");
			characterInfo.setText(characterInfo.getText()+hunter+"\n");
			characterInfo.setText(characterInfo.getText()+wizard+"\n");
			characterInfo.setText(characterInfo.getText()+cleric+"\n");
			characterInfo.setBackground(Color.BLACK);
			characterInfo.setForeground(Color.WHITE);
			enemyInfo.setText(goblin+"\n");
			enemyInfo.setBackground(Color.BLACK);
			enemyInfo.setForeground(Color.WHITE);
		}
		
	}
	public static void main(String[] args) throws IOException {
		ForestBattle t = new ForestBattle();
	}
}
