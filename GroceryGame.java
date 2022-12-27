import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class GroceryGame extends JPanel implements ActionListener, KeyListener { 
	//Declaring variables 
	private int speed = 0; //coordinates of the image  
    private Timer t; 
	private GroceryBasket a1; 
	private GroceryItems items[] = new GroceryItems[12];
	private JButton start; 
	private boolean isReady = false;
	
	public GroceryGame(){ //constructor
		this.setLayout(new BorderLayout()); 
		start = new JButton("Start");
		this.add(start, BorderLayout.SOUTH);
	    start.addActionListener(this);
		
 //Printing out the shopping cart
		t= new Timer(120,this);
		t.start();
		a1 = new GroceryBasket(0,450); 
		this.addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false); 
		
		for(int i = 0; i < 12; i++){
			items[i] = new GroceryItems(); 
		}
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
		this.setFocusable(true);
		this.requestFocusInWindow();
		a1.myDraw(g);

		if(isReady == true){
			for(int i = 0; i < 12; i++){
				items[i].move();
				items[i].myDraw(g); 
			}
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		//When start button is pressed 
		if(e.getSource() == start){
			isReady = true;
		}
		if(a1.getX() <= 10){
			a1.boundaryLeft();
		}else if(a1.getX() >= 800){
			a1.boundaryRight(); 
		}else{
			a1.move(); 
			repaint();
		}
			
	}
   
	//Keylistener for the cart
	@Override
	public void keyTyped(KeyEvent e){}
	
	public void keyPressed(KeyEvent e){
		int KeyCode = e.getKeyCode(); 
		if(KeyCode == KeyEvent.VK_LEFT){
			System.out.print(KeyCode); 
			a1.left(); 
		}
		else if(KeyCode == KeyEvent.VK_RIGHT){
			System.out.print(KeyCode); 
			a1.right(); 
		}
	}
	
	public void keyReleased(KeyEvent e){
		a1.release(); 
	}
	
}
       