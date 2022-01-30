import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;
import java.net.*;
public class PlayerImage extends JLabel{
	private int x;
	private int y;
	private final static int FRAME_HEIGHT = 500;
	private final static int FRAME_WIDTH = 500;
	private Image playerSprite;
	public PlayerImage(int x, int y) throws IOException {
		this.x = x;
		this.y = y;
		URL playerUrl = new URL("https://th.bing.com/th/id/R.331223af028a69bca99a177d5cdb5efc?rik=5IkBIs%2fAdd8gZg&riu=http%3a%2f%2frlv.zcache.com%2f8_bit_knight_pixel_art_poster-raab8b3b1774d4d18a769ca9d36451172_a2n8p_8byvr_512.jpg&ehk=Nf4I0%2f1nLzPutvfNAxt7stoXb%2ffZTViJKnugBVfBTf4%3d&risl=&pid=ImgRaw&r=0");
		BufferedImage playerImg = ImageIO.read(playerUrl);
		playerSprite = playerImg.getScaledInstance(FRAME_WIDTH/10, FRAME_HEIGHT/10, Image.SCALE_DEFAULT);
		this.setIcon(new ImageIcon(playerSprite));
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(playerSprite,x,y,this);
	}
	public void moveUp() {
		y += 10;
		repaint();
	}
	public void moveRight() {
		x += 10;
		repaint();
	}
	public void moveLeft() {
		x -= 10;
		repaint();
	}
	public void moveDown() {
		y -= 10;
		repaint();
	}
}
