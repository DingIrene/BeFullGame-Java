/*
Name: Irene D & Janice H
Date: January 18, 2023
Teacher: Ms. Strelkovska
Description: Be Full main
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


//Problem with the grocery cart image not printing on the GroceryGame panel

class BeFullMain extends JFrame{
	static CardLayout cards;
	static Container cont; 
	
	public BeFullMain(){
		cont = getContentPane();
		cards = new CardLayout();
		cont.setLayout(cards);
		
		
		// create an object of our game panel
		MainMenuPanel mainScreen = new MainMenuPanel();
		GroceryGame game = new GroceryGame();
		Map map1 = new Map(); 
		Kitchen kitchen1 = new Kitchen(); 
		
			// add this game panel to the center of the frame 
		cont.add(mainScreen, BorderLayout.CENTER);
		cont.add(map1, BorderLayout.CENTER);
		cont.add(game, BorderLayout.CENTER);
		cont.add(kitchen1, BorderLayout.CENTER);
			
		/*
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // make frame closed when x button is pressed
			//andrea was here
		this.setVisible(true);     // make the frame visible
		this.setSize(1000, 700);  // set the size of the frame. Maximum size: 1024 x 768 
		*/
	}
	
	public static void main(String[] args){
		BeFullMain main1 = new BeFullMain();
		main1.setSize(1000, 650);
		main1.setVisible(true);
		main1.setResizable(false);
		main1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // make frame closed when x button is pressed

	}
}