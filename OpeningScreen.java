import java.awt.*; 
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.swing.*; 

//How to add custom font with its own ttf file
//How to create timer for this panel to show for a few seconds at the start of the game

class OpeningScreen extends JPanel{
	private JLabel title; 
	
	public OpeningScreen(){
		this.setLayout(new BorderLayout());
		title = new JLabel("Stuffed"); 
		this.add(title);
		/*
		try {
		
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("font\\3D.ttf"));
            title = new JLabel("Stuffed");
			//GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			//genv.registerFont(font);
            //title.setFont(font.deriveFont(Font.BOLD, 48f));
            add(title);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
		*/
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		  
	}
	
	public void paint(Graphics g){
		Font bigFont = new Font("RedPixel", Font.PLAIN, 30); 
		g.setFont(bigFont);
		g.drawString("Stuffed" ,100,490);
	}
	
	
}