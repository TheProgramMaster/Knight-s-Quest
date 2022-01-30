import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.*;
import java.util.*;
public class PlayGame implements KeyListener{
	public JFrame frame = new JFrame();
	public JLabel[][] sprites = new JLabel[10][10];
	public JPanel panel = new JPanel();
	public JPanel player = new JPanel();
	public JLayeredPane lPane = new JLayeredPane();
	public Scanner console = new Scanner(System.in);
	public int x;
	public int y;
	public int dx = 10;
	public int dy = 10;
	public enum Direction {
		DOWN,
		LEFT,
		RIGHT,
		UP
	};
	@SuppressWarnings("deprecation")
	public PlayGame() throws IOException {
		panel.setLayout(new GridLayout(10,10));
		frame.setSize(500,500);
		x = frame.getWidth()/100;
		y = frame.getHeight()/100;
		JPanel playerPanel = new ForwardMovement(x,y);
		URL grassUrl = new URL("https://i.pinimg.com/originals/38/24/17/382417b60104d16330ea6933754a658b.png");
		BufferedImage grassImage = ImageIO.read(grassUrl);
		//Each grass block should be 25 pixels by 25 pixels.
		Image grassBlock = grassImage.getScaledInstance(frame.getWidth()/10, frame.getHeight()/10, Image.SCALE_DEFAULT);
		for(int i = 0;i < sprites.length;i++) {
			for(int j = 0;j < sprites[i].length;j++) {
				sprites[i][j] = new JLabel(new ImageIcon(grassBlock));
			}
		}
		URL treeUrl = new URL("https://us.v-cdn.net/5021068/uploads/editor/ap/aod40fury6mk.png");
		BufferedImage treeImage = ImageIO.read(treeUrl);
		Image treeBlock = treeImage.getScaledInstance(frame.getWidth()/20,frame.getHeight()/20,Image.SCALE_DEFAULT);
		for(int i = 0;i < sprites[0].length;i++) {
			sprites[i][0] = new JLabel(new ImageIcon(treeBlock));
		}
		for(int i = 0;i < sprites[0].length;i++) {
			sprites[i][sprites.length-1] = new JLabel(new ImageIcon(treeBlock));
		}
		for(int i = 1;i < sprites.length-1;i++) {
			sprites[sprites[i].length-1][i] = new JLabel(new ImageIcon(treeBlock));
		}
		URL castleUrl = new URL("https://th.bing.com/th/id/R.0bcf26abbf833300d73a8a743c95985d?rik=nNBklF4iuPRMCA&riu=http%3a%2f%2fwww.8bit.cool%2fwp-content%2fuploads%2fgem-castle.png&ehk=sYcWNmIuP4CZp0QBSogJOFyYqXeHYKocutDkuyPjz3A%3d&risl=&pid=ImgRaw&r=0");
		BufferedImage castleImage = ImageIO.read(castleUrl);
		Image castleBlock = castleImage.getScaledInstance(frame.getWidth()/10,frame.getHeight()/10, Image.SCALE_DEFAULT);
		//Add Castle to game
		sprites[5][6] = new JLabel(new ImageIcon(castleBlock));
		//Add player to game.
		//sprites[2][3] = player;
		//Create Dirt Path to next area.
		URL dirtPathUrl = new URL("https://s3.amazonaws.com/spoonflower/public/design_thumbnails/0464/6961/rr12x12_Dirt_Block_2015_shop_preview.png");
		BufferedImage dirtPathImage = ImageIO.read(dirtPathUrl);
		Image dirtPathBlock = dirtPathImage.getScaledInstance(frame.getWidth()/10,frame.getHeight()/10,Image.SCALE_DEFAULT);
		sprites[0][4] = new JLabel(new ImageIcon(dirtPathBlock));
		sprites[0][5] = new JLabel(new ImageIcon(dirtPathBlock));
		for(int i = 0;i < sprites.length;i++) {
			for(int j = 0;j < sprites[i].length;j++) {
				panel.add(sprites[i][j]);
			}
		}
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) throws IOException {
		PlayGame t = new PlayGame();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			y += dy;
			//player.translate(x,y);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			y -= dy;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= dy;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += dx;
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
