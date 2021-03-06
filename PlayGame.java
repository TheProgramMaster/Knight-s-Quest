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
	public Scanner console = new Scanner(System.in);
	public JLabel playerImage;
	public int x;
	public int y;
	public int dx = 10;
	public int dy = 10;
	public int col;
	public int row;
	public enum Direction {
		DOWN,
		LEFT,
		RIGHT,
		UP
	};
	//@SuppressWarnings("deprecation")
	public PlayGame() throws IOException {
		//Establish world as 10-by-10 squares.
		//Each square will be 50 pixels by 50 pixels.
		panel.setLayout(new GridLayout(10,10));
		frame.setSize(500,500);
		frame.setBackground(Color.GREEN);
		x = frame.getWidth()/2;
		y = frame.getHeight()/2;
		col = 3;
		row = 4;
		JLayeredPane pane = new JLayeredPane();
		//Create grass blocks for the ground and fill map with them.
		URL grassUrl = new URL("https://i.pinimg.com/originals/38/24/17/382417b60104d16330ea6933754a658b.png");
		BufferedImage grassImage = ImageIO.read(grassUrl);
		//Each grass block should be 25 pixels by 25 pixels.
		Image grassBlock = grassImage.getScaledInstance(frame.getWidth()/10, frame.getHeight()/10, Image.SCALE_DEFAULT);
		for(int i = 0;i < sprites.length;i++) {
			for(int j = 0;j < sprites[i].length;j++) {
				sprites[i][j] = new JLabel(new ImageIcon(grassBlock));
			}
		}
		//Create trees for map.
		URL treeUrl = new URL("https://us.v-cdn.net/5021068/uploads/editor/ap/aod40fury6mk.png");
		BufferedImage treeImage = ImageIO.read(treeUrl);
		Image treeBlock = treeImage.getScaledInstance(frame.getWidth()/20,frame.getHeight()/20,Image.SCALE_DEFAULT);
		//Fill left side of map with trees.
		for(int i = 0;i < sprites[0].length;i++) {
			sprites[i][0] = new JLabel(new ImageIcon(treeBlock));
		}
		//Fill right side of map with trees.
		for(int i = 0;i < sprites[0].length;i++) {
			sprites[i][sprites.length-1] = new JLabel(new ImageIcon(treeBlock));
		}
		//Fill bottom row of map with trees.
		for(int i = 1;i < sprites.length-1;i++) {
			sprites[sprites[i].length-1][i] = new JLabel(new ImageIcon(treeBlock));
		}
		//Add Castle to game
		URL castleUrl = new URL("https://th.bing.com/th/id/R.0bcf26abbf833300d73a8a743c95985d?rik=nNBklF4iuPRMCA&riu=http%3a%2f%2fwww.8bit.cool%2fwp-content%2fuploads%2fgem-castle.png&ehk=sYcWNmIuP4CZp0QBSogJOFyYqXeHYKocutDkuyPjz3A%3d&risl=&pid=ImgRaw&r=0");
		BufferedImage castleImage = ImageIO.read(castleUrl);
		Image castleBlock = castleImage.getScaledInstance(frame.getWidth()/10,frame.getHeight()/10, Image.SCALE_DEFAULT);
		sprites[5][6] = new JLabel(new ImageIcon(castleBlock));
		//Add player to game.
		//sprites[2][3] = player;
		//Create Dirt Path to next area.
		URL dirtPathUrl = new URL("https://s3.amazonaws.com/spoonflower/public/design_thumbnails/0464/6961/rr12x12_Dirt_Block_2015_shop_preview.png");
		BufferedImage dirtPathImage = ImageIO.read(dirtPathUrl);
		Image dirtPathBlock = dirtPathImage.getScaledInstance(frame.getWidth()/10,frame.getHeight()/10,Image.SCALE_DEFAULT);
		sprites[0][4] = new JLabel(new ImageIcon(dirtPathBlock));
		sprites[0][5] = new JLabel(new ImageIcon(dirtPathBlock));
		playerImage = new PlayerImage(frame.getWidth()/2,frame.getHeight()/2);
		sprites[col][row] = playerImage;
		for(int i = 0;i < sprites.length;i++) {
			for(int j = 0;j < sprites[i].length;j++) {
				panel.add(sprites[i][j]);
			}
		}
		frame.addKeyListener(this);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) throws IOException {
		PlayGame t = new PlayGame();
	}
	//@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//Move player down on down arrow key.
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			JLabel prev = sprites[col+1][row];
			sprites[col+1][row] = playerImage;
			sprites[col][row] = prev;
			col += 1;
			panel.revalidate();
			panel.repaint();
			panel.setLayout(new GridLayout(10,10));
			for(int i = 0;i < sprites.length;i++) {
				for(int j = 0;j < sprites[i].length;j++) {
					panel.add(sprites[i][j]);
				}
			}
			frame.add(panel);
		}
		//Move player right on right arrow key.
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			JLabel prev = sprites[col][row+1];
			sprites[col+1][row] = playerImage;
			sprites[col][row] = prev;
			row += 1;
			panel.revalidate();
			panel.repaint();
			panel.setLayout(new GridLayout(10,10));
			for(int i = 0;i < sprites.length;i++) {
				for(int j = 0;j < sprites[i].length;j++) {
					panel.add(sprites[i][j]);
				}
			}
			frame.add(panel);
		}
		//Move player left on left arrow key.
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			panel.revalidate();
			panel.repaint();
			panel.setLayout(new GridLayout(10,10));
			for(int i = 0;i < row;i++) {
				for(int j = 0;j < col-1;j++) {
					panel.add(sprites[i][j]);
				}
			}
			JLabel prev = sprites[col][row-1];
			sprites[col][row-1] = playerImage;
			sprites[col][row] = prev;
			row -= 1;
			for(int i = row+1;i < sprites.length;i++) {
				for(int j = col+1;j < sprites[i].length;j++) {
					panel.add(sprites[i][j]);
				}
			}
			frame.add(panel);
		}
		//Move player up on up arrow key.
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			JLabel prev = sprites[col-1][row];
			sprites[col-1][row] = playerImage;
			sprites[col][row] = prev;
			col -= 1;
			panel.revalidate();
			panel.repaint();
			panel.setLayout(new GridLayout(10,10));
			for(int i = 0;i < sprites.length;i++) {
				for(int j = 0;j < sprites[i].length;j++) {
					panel.add(sprites[i][j]);
				}
			}
			frame.add(panel);
		}
		if(row==4&&col==0) {
			frame.dispose();
			try {
				ForestMap t = new ForestMap();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(row==5&&col==0) {
			frame.dispose();
			try {
				ForestMap t = new ForestMap();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
