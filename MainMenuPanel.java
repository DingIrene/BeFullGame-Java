import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.imageio.*;
import java.util.*;
import java.io.*;

//Need to re-make the layout so that the health bar is at the south, bottom of the panel

class MainMenuPanel extends JPanel implements ActionListener{
	//Declaring variables
	private JButton b1,b2,b3; 
	private ImageIcon instructions; 
	private JLabel background, healthBar;
	
	public MainMenuPanel(){
		b1 = new JButton("Instructions"); 
		b2 = new JButton("Play"); 
		b3 = new JButton("Exit"); 
		 
		JLabel background = new JLabel(new ImageIcon("images/TitleScreen.jpg"));
		//JLabel healthBar = new JLabel(new ImageIcon("images/Bar.PNG"));
		//this.setLayout(new BorderLayout());

		this.add(b1);
		this.add(b2);  
		this.add(b3);
		this.add(background); 
		//this.add(healthBar, BorderLayout.SOUTH);
	  
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b1.setContentAreaFilled(false);
		b2.setContentAreaFilled(false);
		b3.setContentAreaFilled(false);
		
		//instructions= new ImageIcon("InstructionsPoints.PNG"); png of the instructions
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			//Pop up window of the instructions
			JOptionPane.showMessageDialog(null,"","Instructions", JOptionPane.INFORMATION_MESSAGE,instructions);
		}	
		else if (e.getSource()==b2){ 
			BeFullMain.cards.next(BeFullMain.cont);
		}
		else if (e.getSource()==b3){
			JOptionPane.showMessageDialog(null, "That was an exit button", "My exit message",JOptionPane.WARNING_MESSAGE ); 
			System.exit(0);
		}	
    }
	
	public void paintComponent(Graphics g){
	   super.paintComponent(g);
	}

}

