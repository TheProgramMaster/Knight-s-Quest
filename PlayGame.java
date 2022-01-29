import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.*;
public class PlayGame {
	public JFrame frame = new JFrame();
	public JLabel[][] sprites = new JLabel[20][20];
	public PlayGame() throws IOException {
		frame.setSize(500,500);
		frame.setLayout(new GridLayout(20,20));
		URL grassUrl = new URL("https://i.pinimg.com/originals/38/24/17/382417b60104d16330ea6933754a658b.png");
		BufferedImage grassImage = ImageIO.read(grassUrl);
		ImageIcon grassIcon = new ImageIcon(grassImage);
		//Each grass block should be 25 pixels by 25 pixels.
		Image grassBlock = grassImage.getScaledInstance(frame.getWidth()/20, frame.getHeight()/20, Image.SCALE_DEFAULT);
		for(int i = 0;i < sprites.length;i++) {
			for(int j = 0;j < sprites[i].length;j++) {
				sprites[i][j] = new JLabel(new ImageIcon(grassBlock));
			}
		}
		for(int i = 0;i < sprites.length;i++) {
			for(int j = 0;j < sprites[i].length;j++) {
				frame.add(sprites[i][j]);
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) throws IOException {
		PlayGame t = new PlayGame();
	}
}
