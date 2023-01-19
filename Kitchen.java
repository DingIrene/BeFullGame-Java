/*
Name: Irene D & Janice H
Date: January 18, 2023
Teacher: Ms. Strelkovska
Description: Kitchen class
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Kitchen extends JPanel implements ActionListener{
	//Declaring variables
	private Image pic; 
	private JButton b4, fridge;
	private int clickCount = 0; 
	private HealthBar xpBar;
	private MealsDeck deck; 
	
	public Kitchen(){ //constructor
		this.setLayout(new BorderLayout()); 
		ImageIcon obj = new ImageIcon("images/Kitchen.PNG"); 
		pic = obj.getImage();
		deck = new MealsDeck(); 

		fridge = new JButton("Fridge");
		fridge.addActionListener(this); 
		
		b4 = new JButton("Back"); 
		b4.addActionListener(this); 
		
		this.add(fridge,BorderLayout.SOUTH); 
		this.add(b4, BorderLayout.NORTH); 
		this.add(deck,BorderLayout.CENTER); 
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(pic, 0, 0, null);
		MealsDeck.bar.myDraw(g);
		repaint();
		
	}
	
	public void actionListener(ActionEvent e){}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b4){
			BeFullMain.cards.previous(BeFullMain.cont);
			BeFullMain.cards.previous(BeFullMain.cont);
		}else if(e.getSource() == fridge){
			JOptionPane.showMessageDialog(null,GroceryGame.frigo,"Collected", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}