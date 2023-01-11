import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Buttons right now are taking up too much space need to rearrange 

class GroceryGame extends JPanel implements ActionListener, KeyListener  { 
	//Declaring variables 
	private int speed = 0; //coordinates of the image  
    private Timer t; 
	private GroceryBasket a1; 
	private GroceryItems items[] = new GroceryItems[12];
	private JButton start, back; 
	private boolean isReady = false;
	private Image pic; 
	
	public GroceryGame(){ //constructor
		ImageIcon obj = new ImageIcon("images/groceryStore.JPG"); 
		pic = obj.getImage();
		for(int i = 0; i < 12; i++){
			items[i] = new GroceryItems();
		}
		
		this.setLayout(new BorderLayout()); 
		start = new JButton("Start");
		back = new JButton("Back");
		this.add(back, BorderLayout.NORTH); 
		this.add(start, BorderLayout.SOUTH);
	    start.addActionListener(this);
		back.addActionListener(this);
		
		//Printing out the shopping cart
		t= new Timer(120,this);
		t.start();
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
		// Implement when there is actually a Map panel
		if(e.getSource() == back){
			BeFullMain.cards.previous(BeFullMain.cont);
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
    }
	
	public void checkCollisions(){
		Rectangle test = new Rectangle(a1.getX(), a1.getY(), a1.getWidth(), a1.getHeight());
		Rectangle list[] = new Rectangle[12]; 
		for(int i = 0; i < 12; i++){
			list[i] = new Rectangle(items[i].fallWidth(), items[i].fallHeight(), items[i].getWidth(), items[i].getHeight());
			
			if(list[i].intersects(test)){
                items[i].setVisible(false);
				//numberOfItems[items[i].getIdentity()] += 1; //how to transport to fridge
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