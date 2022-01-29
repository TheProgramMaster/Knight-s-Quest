import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
public class TitleScreenSprite extends JComponent{
	private JPanel panel = new JPanel();
	private BufferedImage image;
	public TitleScreenSprite() {
		try {
			image = ImageIO.read(new File("C:/Users/gavin/OneDrive/Documents/megaman.jfif"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	//@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image,0,0,panel);
	}
}
