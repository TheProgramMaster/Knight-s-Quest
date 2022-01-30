import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.*;
public class PlayerTest implements KeyListener{
	public JFrame frame = new JFrame();
	public int dx = 10;
	public int dy = 10;
	private int x;
	private int y;
	private PlayerImage playerPanel;
	public PlayerTest() throws IOException{
		frame.setSize(500,500);
		x = frame.getWidth()/2;
		y = frame.getHeight()/2;
		playerPanel = new PlayerImage(x,y);
		frame.add(playerPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) throws IOException {
		PlayerTest t = new PlayerTest();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			y -= dx;
			playerPanel.movePlayer(x,y);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += dx;
			playerPanel.movePlayer(x, y);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= dx;
			playerPanel.movePlayer(x, y);
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			y += dy;
			playerPanel.movePlayer(x, y);
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
