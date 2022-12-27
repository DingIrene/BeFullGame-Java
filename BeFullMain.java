import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


//Problem with the grocery cart image not printing on the GroceryGame panel

class BeFullMain extends JFrame{
	static CardLayout cards;
	static Container cont; 

	MainMenuPanel mainScreen; 
	GroceryGame game; 
	OpeningScreen first;
	
	public BeFullMain(){
		cont = getContentPane();
		cards=new CardLayout();
		cont.setLayout(cards); 
		
		// create an object of our game panel
		//first = new OpeningScreen(); 
		mainScreen = new MainMenuPanel();
		game = new GroceryGame();
		cont.add(game, BorderLayout.CENTER);
			
			// add this game panel to the center of the frame
		//cont.add(first, BorderLayout.CENTER);
		cont.add(mainScreen, BorderLayout.CENTER);
		cont.add(game, BorderLayout.CENTER);
			
		/*
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // make frame closed when x button is pressed
			//andrea was here
		this.setVisible(true);     // make the frame visible
		this.setSize(1000, 700);  // set the size of the frame. Maximum size: 1024 x 768 
		*/
	}
	
	public static void main(String[] args){
		BeFullMain main1 = new BeFullMain();
		main1.setSize(1000, 700);
		main1.setVisible(true);
		main1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // make frame closed when x button is pressed

	}
}

