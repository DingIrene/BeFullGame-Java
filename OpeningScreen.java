import java.awt.*; 
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.swing.*; 
import java.awt.event.*; 

//How to add custom font with its own ttf file
//How to create timer for this panel to show for a few seconds at the start of the game

class OpeningScreen extends JPanel implements ActionListener{
	private JLabel title; 
	private JButton start; 
	
	public OpeningScreen(){
		this.setLayout(new BorderLayout());
		title = new JLabel("Stuffed"); 
		this.add(title);
		start = new JButton("Start"); 
		this.add(start); 
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
	public void paint(Graphics g){
		Font bigFont = new Font("RedPixel", Font.PLAIN, 30); 
		g.setFont(bigFont);
		g.drawString("Stuffed" ,100,490);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== start){
			BeFullMain.cards.next(BeFullMain.cont);
		}
	}
	
}