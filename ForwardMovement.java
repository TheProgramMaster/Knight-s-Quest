import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.lang.*;
import java.io.*;
public class ForwardMovement extends JPanel{
	private Image img;
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	private int x;
	private int y;
	private boolean shouldDraw;
	public ForwardMovement(int x, int y) throws IOException {
		this.x = x;
		this.y = y;
		File file = new File("C:\\Users\\gavin\\OneDrive\\Pictures\\Forward.PNG");
		BufferedImage image = ImageIO.read(file);
		img = image.getScaledInstance(FRAME_WIDTH/10, FRAME_HEIGHT/10, Image.SCALE_DEFAULT);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img,x,y,FRAME_WIDTH/10,FRAME_HEIGHT/10,null);
	}
	public void translate(int x, int y) {
		this.x = x;
		this.y = y;
		repaint();
	}
}
