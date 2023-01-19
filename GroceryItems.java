/*
Name: Irene D & Janice H
Date: January 18, 2023
Teacher: Ms. Strelkovska
Description: Grocery items file
*/

import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
//Each grocery item will be idenitifed by a number 


class GroceryItems{
	//Declaring variables
	private int identity,x,y, random; 
	private String[] imagesOfItems = {"images/egg.PNG", "images/milk.PNG","images/strawberry.PNG","images/bread.PNG","images/flour.PNG","images/sugar.PNG"};
	private int[] identities = new int[]{0,1,2,3,4,5}; 
	private BufferedImage image;
	private boolean visible = true;
	private boolean caught = false;
	
	//Methods
	public GroceryItems(){ //constructor
		//Randmizing the item and the starting positions
		random = (int)((Math.random()*imagesOfItems.length));
		 
		for(int i = 0; i < 6; i++){ //Initizing the identity of the item
			if(random == identities[i]){
				identity = i; 
				break;
			}
		}
		y = -((int)(((Math.random()*3000) + 50)));
		x = (int)(((Math.random()*8)+1)*90);
		try {
			image = ImageIO.read(new File(imagesOfItems[random]));
        }catch(IOException e) {
            e.printStackTrace();
        }
	}
	
	public void isCaught(boolean caught){
		this.caught = caught;
	}
	
	public boolean caughtc(){
		return caught;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	public int fallHeight(){
		return y;
	}
	
	public int fallWidth(){
		return x;
	}
	
	public int getIdentity(){
		return identity; 
	}
	
	public int getHeight(){
		return 84;
	}
	
	public int getWidth(){
		return 70;
	}
	
	public void move(){
		y += 40;
		x += 1;
	}
	
	public void myDraw(Graphics g){
		if(!visible){
			return;
		}
		g.drawImage(image, x, y, null);
    }
	
	public String getImage(int number){
		return imagesOfItems[number]; 
	}
}