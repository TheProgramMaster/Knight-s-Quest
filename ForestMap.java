import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.*;
import java.util.*;
public class ForestMap implements KeyListener{
	public JFrame frame = new JFrame();
	public JPanel world = new JPanel();
	public JLabel[][] blocks = new JLabel[10][10];
	public JLabel player;
	private int col;
	private int row;
	public ForestMap() throws IOException{
		frame.setSize(500,500);
		world.setLayout(new GridLayout(10,10));
		col = 9;
		row = 4;
		URL dirtPathUrl = new URL("https://th.bing.com/th/id/R.c928294c3b721975231366b6298648f7?rik=GqlCSDyVESBD%2fA&riu=http%3a%2f%2fi.imgur.com%2ftMbow.png&ehk=cO7W%2b%2fH9fLUPW7EEpsY8RI6PCq8A6T%2fpqO9y6FNMR4Q%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1");
		BufferedImage dirtPathImage = ImageIO.read(dirtPathUrl);
		Image dirtPathBlock = dirtPathImage.getScaledInstance(frame.getWidth()/10, frame.getHeight()/10, Image.SCALE_DEFAULT);
		for(int i = 0;i < blocks.length;i++) {
			for(int j = 0;j < blocks[0].length;j++) {
				blocks[i][j] = new JLabel(new ImageIcon(dirtPathBlock));
			}
		}
		URL grassPathUrl = new URL("https://i.pinimg.com/originals/38/24/17/382417b60104d16330ea6933754a658b.png");
		BufferedImage grassPathImage = ImageIO.read(grassPathUrl);
		Image grassPathBlock = grassPathImage.getScaledInstance(frame.getWidth()/10, frame.getHeight()/10, Image.SCALE_DEFAULT);
		for(int i = 0;i < blocks.length;i++) {
			for(int j = 2;j < 4;j++) {
				blocks[i][j] = new JLabel(new ImageIcon(grassPathBlock));
			}
		}
		for(int i = 0;i < blocks.length;i++) {
			for(int j = 6;j < 8;j++) {
				blocks[i][j] = new JLabel(new ImageIcon(grassPathBlock));
			}
		}
		URL treeBlockUrl = new URL("https://th.bing.com/th/id/R.c9724a4464cd9496a5cb0e3377b6029c?rik=wEpzXKRAltvK6Q&pid=ImgRaw&r=0");
		BufferedImage treePathImage = ImageIO.read(treeBlockUrl);
		Image treePathBlock = treePathImage.getScaledInstance(frame.getWidth()/10,frame.getHeight()/10,Image.SCALE_DEFAULT);
		for(int i = 0;i < blocks.length;i++) {
			for(int j = 0;j < 2;j++) {
				blocks[i][j] = new JLabel(new ImageIcon(treePathBlock));
			}
		}
		for(int i = 0;i < blocks.length;i++) {
			for(int j = 8; j < blocks[0].length;j++) {
				blocks[i][j] = new JLabel(new ImageIcon(treePathBlock));
			}
		}
		player = new PlayerImage(frame.getWidth()/2,frame.getHeight()/2);
		blocks[col][row] = player;
		for(int i = 0;i < blocks.length;i++) {
			for(int j = 0;j < blocks[0].length;j++) {
				world.add(blocks[i][j]);
			}
		}
		frame.add(world);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
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
				JLabel prev = blocks[col+1][row];
				blocks[col+1][row] = player;
				blocks[col][row] = prev;
				col += 1;
				world.revalidate();
				world.repaint();
				world.setLayout(new GridLayout(10,10));
				for(int i = 0;i < blocks.length;i++) {
					for(int j = 0;j < blocks[i].length;j++) {
						world.add(blocks[i][j]);
					}
				}
				frame.add(world);
			}
			//Move player right on right arrow key.
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				JLabel prev = blocks[col][row+1];
				blocks[col+1][row] = player;
				blocks[col][row] = prev;
				row += 1;
				world.revalidate();
				world.repaint();
				world.setLayout(new GridLayout(10,10));
				for(int i = 0;i < blocks.length;i++) {
					for(int j = 0;j < blocks[i].length;j++) {
						world.add(blocks[i][j]);
					}
				}
				frame.add(world);
			}
			//Move player left on left arrow key.
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				JLabel prev = blocks[col][row-1];
				blocks[col][row-1] = player;
				blocks[col][row] = prev;
				row -= 1;
				world.revalidate();
				world.repaint();
				world.setLayout(new GridLayout(10,10));
				for(int i = 0;i < blocks.length;i++) {
					for(int j = 0;j < blocks[i].length;j++) {
						world.add(blocks[i][j]);
					}
				}
				frame.add(world);
			}
			//Move player up on up arrow key.
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				JLabel prev = blocks[col-1][row];
				blocks[col-1][row] = player;
				blocks[col][row] = prev;
				col -= 1;
				world.revalidate();
				world.repaint();
				world.setLayout(new GridLayout(10,10));
				for(int i = 0;i < blocks.length;i++) {
					for(int j = 0;j < blocks[i].length;j++) {
						world.add(blocks[i][j]);
					}
				}
				frame.add(world);
			}
			if(row==4&&col==0) {
				frame.dispose();
				try {
					ForestMainMap t = new ForestMainMap();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(row==5&&col==0) {
				frame.dispose();
				try {
					ForestMainMap t = new ForestMainMap();
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
	public static void main(String[] args) throws IOException {
		ForestMap t = new ForestMap();
	}
}
