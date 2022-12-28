import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

/*
Cart object
*/

class GroceryBasket{
	//Declaring variables
	private int y,x,vel = 0, height, width;
	private BufferedImage image;

	public GroceryBasket(int x, int y){ //constructor
		this.x=x;
		this.y=y;
        try {
            image = ImageIO.read(new File("images\\groceryCart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		height = 212;
		width = 712; 
	}
  
	public void myDraw(Graphics g){
      g.drawImage(image,x,y,null); 
    }	   
   
	public void left(){
	   vel = -40;
    }
	
	public void right(){
		vel = 40; 
	}
	
	public void move(){
		x  += vel; 
		y = 450; 
	}
	
	public void release(){
		vel = 0; 
	}
	
	public int getX(){
		return x; 
	}
	

	public void boundaryLeft(){
		x = 50; 
	}
	
	public void boundaryRight(){
		x = 780; 
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
}