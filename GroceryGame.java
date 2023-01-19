/*
Name: Irene D & Janice H
Date: January 18, 2023
Teacher: Ms. Strelkovska
Description: Grocery Game Class
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class GroceryGame extends JPanel implements ActionListener, KeyListener  { 
	//Declaring variables 
	private int speed = 0; //coordinates of the image  
    private Timer t; 
	private GroceryBasket a1; 
	private GroceryItems items[] = new GroceryItems[12];
	private JButton start, back, fridge; 
	private boolean isReady = false;
	private Image pic;
	private int temp = 0;
	private int[] itemIDs; 
	public static Fridge frigo;
	
	public GroceryGame(){ //constructor
		ImageIcon obj = new ImageIcon("images/groceryStore.PNG"); 
		pic = obj.getImage();
		
		frigo = new Fridge(); 
		
		this.setLayout(new BorderLayout()); 
		start = new JButton("Start");
		back = new JButton("Back");
		fridge = new JButton("Fridge"); 
		this.add(back, BorderLayout.NORTH); 
		this.add(start, BorderLayout.SOUTH);
		this.add(fridge, BorderLayout.EAST);
	    start.addActionListener(this);
		back.addActionListener(this);
		fridge.addActionListener(this); 
		fridge.setContentAreaFilled(false);
		
		//Printing out the shopping cart
		t= new Timer(120,this);
		a1 = new GroceryBasket(0,450); 
		this.addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
		g.drawImage(pic, 0, 0, null);
		this.setFocusable(true);
		this.requestFocusInWindow();
		a1.myDraw(g);
		if(isReady == true){
			for(int i = 0; i < 12; i++){
				items[i].myDraw(g);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		//When start button is pressed 
		if(e.getSource() == start){
			t.start();
			isReady = true;
			for(int i = 0; i < 12; i++){
				items[i] = new GroceryItems();
			}
		}
		if(e.getSource() == back){
			BeFullMain.cards.previous(BeFullMain.cont);
		}
		if(e.getSource() == fridge){
			JOptionPane.showMessageDialog(null,frigo,"Collected", JOptionPane.INFORMATION_MESSAGE);
		}

		//repositioning if cart is out of boundaries
		if(a1.getX() <= 10){
			a1.boundaryLeft();
		}else if(a1.getX() >= 800){
			a1.boundaryRight(); 
		}else{
			a1.move(); 
			repaint();
			checkCollisions();
		}
		
		if(e.getSource() == t){
			for(int i = 0; i < 12; i++){
				items[i].move();
				if(allItemsGone()){
					t.stop();
					if(items[i].caughtc() == true){
						frigo.addToFridge(items[i].getIdentity());
					}
				}
			}
		}
    }
	
	public boolean allItemsGone(){
		temp = 0;
		for(int i = 0; i < 12; i++){
			if(items[i].fallHeight() >= 680){
				temp += 1;
			}
		}
		if(temp == 12){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void checkCollisions(){
		Rectangle test = new Rectangle(a1.getX(), a1.getY(), a1.getWidth(), a1.getHeight());
		Rectangle list[] = new Rectangle[12]; 
		for(int i = 0; i < 12; i++){
			list[i] = new Rectangle(items[i].fallWidth(), items[i].fallHeight(), items[i].getWidth(), items[i].getHeight());
			
			if(list[i].intersects(test)){
                items[i].setVisible(false);
				if(items[i].isVisible() == false){
					items[i].isCaught(true);
				}
            }
        }
	}
	
	//Keylistener for the cart
	@Override
	public void keyTyped(KeyEvent e){}
	
	public void keyPressed(KeyEvent e){
		int KeyCode = e.getKeyCode(); 
		if(KeyCode == KeyEvent.VK_LEFT){
			a1.left(); 
		}
		else if(KeyCode == KeyEvent.VK_RIGHT){
			a1.right(); 
		}
	}
	
	public void keyReleased(KeyEvent e){
		a1.release(); 
	}
}