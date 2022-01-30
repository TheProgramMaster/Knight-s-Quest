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
	public JLabel playerOptions = new JLabel();
	public JLabel background = new JLabel();
	public ImageIcon attackButtonIcon = new ImageIcon("C:\\Users\\gavin\\OneDrive\\Documents\\attackButton.png");
	public JButton attackButton = new JButton(attackButtonIcon);
	public ImageIcon defenseButtonIcon = new ImageIcon("C:\\Users\\gavin\\OneDrive\\Documents\\defenseButton.png");
	public JButton defenseButton = new JButton(defenseButtonIcon);
	public ImageIcon magicButtonIcon = new ImageIcon("C:\\Users\\gavin\\OneDrive\\Documents\\magicButton.png");
	public JButton magicButton = new JButton();
	public ImageIcon itemsButtonIcon = new ImageIcon("C:\\Users\\gavin\\OneDrive\\Documents\\itemsButton.png");
	public JButton itemsButton = new JButton(itemsButtonIcon);
	public JButton[] buttons = {attackButton, defenseButton,
			magicButton, itemsButton};
	public JTextArea characterInfo = new JTextArea();
	public JTextArea enemyInfo = new JTextArea();
	public ActionListener listener = new ButtonListener();
	public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}
	public ForestBattle() throws IOException {
		frame.setSize(500,500);
		text.setText("You find yourself in battle!");
		text.setBackground(Color.BLACK);
		text.setForeground(Color.WHITE);
		frame.setLayout(new BorderLayout());
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
		playerOptions.setLayout(new GridLayout(1,4));
		//Establish Forest background scenary
		URL forestBackgroundUrl = new URL("https://i.pinimg.com/originals/af/54/2d/af542d89a7722b3ba7d078247d3314fe.gif");
		BufferedImage bufferedImage = ImageIO.read(forestBackgroundUrl);
		Image image = bufferedImage.getScaledInstance(frame.getWidth(),frame.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(image);
		background.setIcon(icon);
		//Establish Attack Button
		attackButton.setBounds(playerOptions.getWidth()/2,0,playerOptions.getWidth(),frame.getHeight());
		playerOptions.add(attackButton);
		int offset = attackButton.getInsets().left;
		attackButton.setIcon(resizeIcon(attackButtonIcon,attackButton.getWidth()-offset,attackButton.getHeight()-offset));
		//Establish Defense Button
		defenseButton.setBounds(0,playerOptions.getHeight()/4,playerOptions.getWidth(),frame.getHeight()/4);
		playerOptions.add(defenseButton);
		int offset2 = defenseButton.getInsets().left;
		defenseButton.setIcon(resizeIcon(defenseButtonIcon,defenseButton.getWidth()-offset2,defenseButton.getHeight()-offset2));
		//Establish Magic Button.
		magicButton.setBounds(0,playerOptions.getHeight()/2,playerOptions.getWidth(),frame.getHeight()/2);
		playerOptions.add(magicButton);
		int offset3 = magicButton.getInsets().left;
		magicButton.setIcon(resizeIcon(magicButtonIcon,magicButton.getWidth()-offset3,magicButton.getHeight()-offset3));
		//Establish Items Button.
		itemsButton.setBounds(0,0,playerOptions.getWidth()/4,frame.getHeight());
		playerOptions.add(itemsButton);
		int offset4 = itemsButton.getInsets().left;
		attackButton.setIcon(resizeIcon(itemsButtonIcon,itemsButton.getWidth()-offset4,itemsButton.getHeight()-offset4));
		frame.add(background,BorderLayout.CENTER);
		frame.add(text,BorderLayout.NORTH);
		frame.add(playerOptions,BorderLayout.WEST);
		frame.add(characterInfo,BorderLayout.SOUTH);
		frame.add(enemyInfo,BorderLayout.EAST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) throws IOException {
		ForestBattle t = new ForestBattle();
	}
	public class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == attackButton) {
				text.setText("You used attack!");
			}
			if(e.getSource() == defenseButton) {
				text.setText("You used defend!");
			}
			if(e.getSource() == magicButton) {
				text.setText("You used magic!");
			}
			if(e.getSource() == itemsButton) {
				
			}
		}
		
	}
}
