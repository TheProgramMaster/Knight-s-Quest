import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
public class StoryText {
<<<<<<< HEAD
	//Initialize GUI components.
	public JFrame frame = new JFrame("Story Text");
	public JPanel panel = new JPanel();
	public JPanel backgroundPanel = new JPanel();
	public JLabel background = new JLabel();
	public JScrollPane scollPane = new JScrollPane();
	protected static JTextArea textArea;
	//Establish backbutton as image and button listener
	public ImageIcon backButtonIcon = new ImageIcon("C:\\Users\\gavin\\OneDrive\\Desktop\\back.png");
	public JButton backButton = new JButton(backButtonIcon);
	public ActionListener listener = new ButtonListener();
	//Declare method to resize image in button.
=======
	public JFrame frame = new JFrame("Story Text");
	public JPanel panel = new JPanel();
	public JLabel background = new JLabel();
	public JScrollPane scollPane = new JScrollPane();
	protected static JTextArea textArea;
	ImageIcon backButtonIcon = new ImageIcon("C:\\Users\\gavin\\OneDrive\\Desktop\\back.png");
	JButton backButton = new JButton(backButtonIcon);
	public ActionListener listener = new ButtonListener();
>>>>>>> a6a4bb2034b2347e418971e625b8e6e641605ddd
	public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}
	public StoryText() throws IOException {
<<<<<<< HEAD
		//Initialize JFrame.
		frame.setSize(500,500);
		frame.setLayout(new BorderLayout());
		//Add listener to back button
		backButton.addActionListener(listener);
		//Establish textArea and add textArea to JFrame.
		textArea = new InfoTextScreen(frame.getWidth()/20,frame.getHeight()/10);
		textArea.setBackground(new Color(1,1,1,(float) 0.50));
		frame.add(textArea,BorderLayout.CENTER);
		//Output story text file to screen for user.
=======
		frame.setSize(500,500);
		frame.setLayout(new BorderLayout());
		textArea = new InfoTextScreen(frame.getWidth()/20,frame.getHeight()/10);
		textArea.setBackground(new Color(1,1,1,(float) 0.50));
		frame.add(textArea);
>>>>>>> a6a4bb2034b2347e418971e625b8e6e641605ddd
		File file = new File("C:\\Users\\gavin\\OneDrive\\Documents\\KnightsQuestStoryText.txt");
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = in.readLine();
		while(line != null) {
			textArea.append(line + "\n");
			line = in.readLine();
		}
<<<<<<< HEAD
		//Add textArea over top of background.
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
=======
		backButton.setBounds(frame.getWidth()/3*2,frame.getHeight()/5,frame.getWidth()/5,frame.getHeight()/10);
		int offset = backButton.getInsets().left;
		backButton.setIcon(resizeIcon(backButtonIcon,backButton.getWidth()-offset,backButton.getHeight()-offset));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>>>>>>> a6a4bb2034b2347e418971e625b8e6e641605ddd
		URL backgroundUrl = new URL("https://c4.wallpaperflare.com/wallpaper/779/824/841/pixel-art-8-bit-wallpaper-preview.jpg");
		BufferedImage bufferedImage = ImageIO.read(backgroundUrl);
		Image image = bufferedImage.getScaledInstance(frame.getWidth(),frame.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(image);
		background.setIcon(icon);
<<<<<<< HEAD
		//Set background image.
		backButton.setBounds(frame.getWidth()/2,0,frame.getWidth()/5,frame.getHeight()/10);
		int offset = backButton.getInsets().left;
		backButton.setIcon(resizeIcon(backButtonIcon,backButton.getWidth()-offset,backButton.getHeight()-offset));
		panel.add(backButton);
		frame.add(panel,BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
=======
		panel.add(backButton);
		panel.add(textArea);
		frame.add(panel);
>>>>>>> a6a4bb2034b2347e418971e625b8e6e641605ddd
		frame.setVisible(true);
	}
	public class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Returns to home title screen when user clicks the back button.
			if(e.getSource()==backButton) {
				frame.dispose();
				try {
					TitleScreen t = new TitleScreen();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		StoryText t = new StoryText();
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> a6a4bb2034b2347e418971e625b8e6e641605ddd
