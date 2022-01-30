import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.*;
import java.util.*;
public class ForestMainMap {
	public JFrame frame = new JFrame();
	public JLabel[][] blocks = new JLabel[10][10];
	public JPanel world = new JPanel();
	public Random rand = new Random();
	public ForestMainMap() throws IOException {
		frame.setSize(500,500);
		world.setLayout(new GridLayout(10,10));
		URL grassPathUrl = new URL("https://i.pinimg.com/originals/38/24/17/382417b60104d16330ea6933754a658b.png");
		BufferedImage grassPathImage = ImageIO.read(grassPathUrl);
		Image grassPathBlock = grassPathImage.getScaledInstance(frame.getWidth()/50, frame.getHeight()/50, Image.SCALE_DEFAULT);
		for(int i = 0;i < blocks.length;i++) {
			for(int j = 0;j < blocks[0].length;j++) {
				blocks[i][j] = new JLabel(new ImageIcon(grassPathBlock));
			}
		}
		URL dirtPathUrl = new URL("https://th.bing.com/th/id/R.c928294c3b721975231366b6298648f7?rik=GqlCSDyVESBD%2fA&riu=http%3a%2f%2fi.imgur.com%2ftMbow.png&ehk=cO7W%2b%2fH9fLUPW7EEpsY8RI6PCq8A6T%2fpqO9y6FNMR4Q%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1");
		BufferedImage dirtPathImage = ImageIO.read(dirtPathUrl);
		Image dirtPathBlock = dirtPathImage.getScaledInstance(frame.getWidth()/50, frame.getHeight()/50, Image.SCALE_DEFAULT);
		blocks[9][4] = new JLabel(new ImageIcon(dirtPathBlock));
		blocks[9][5] = new JLabel(new ImageIcon(dirtPathBlock));
		URL goblinPathUrl = new URL("https://i.pinimg.com/736x/39/57/e3/3957e3772a3b1014064c2c0110566fd2.jpg");
		BufferedImage goblinPathImage = ImageIO.read(goblinPathUrl);
		Image goblinPathBlock = goblinPathImage.getScaledInstance(frame.getWidth()/50, frame.getHeight()/50, Image.SCALE_DEFAULT);
		for(int i = 0;i < 4;i++) {
			int x = (int)(rand.nextDouble()*(blocks.length));
			int y = (int)(rand.nextDouble()*(blocks[0].length));
			blocks[x][y] = new JLabel(new ImageIcon(goblinPathBlock));
		}
		for(int i = 0;i < blocks.length;i++) {
			for(int j = 0;j < blocks[0].length;j++) {
				world.add(blocks[i][j]);
			}
		}
		frame.add(world);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) throws IOException {
		ForestMainMap t = new ForestMainMap();
	}
}
