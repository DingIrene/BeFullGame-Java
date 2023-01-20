/*
Name: Irene D & Janice H
Date: January 18, 2023
Teacher: Ms. Strelkovska
Description: Main Menu Panel
*/

import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.imageio.*;
import java.util.*;
import java.io.*;

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

		this.add(b1);
		this.add(b2);  
		this.add(b3);
		this.add(background); 
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b1.setContentAreaFilled(false);
		b2.setContentAreaFilled(false);
		b3.setContentAreaFilled(false);
		
		instructions= new ImageIcon("images/instructions.PNG"); 
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			//Pop up window of the instructions
			JOptionPane.showMessageDialog(null,instructions,"Instructions", JOptionPane.INFORMATION_MESSAGE);
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

