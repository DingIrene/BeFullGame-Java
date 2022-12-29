import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
//Each grocery item will be idenitifed by a number 

class GroceryItems{
	//Declaring variables
	private int identity,x,y; 
	private String[] imagesOfItems = {"images/egg.PNG", "images/milk.PNG","images/strawberry.PNG","images/bread.PNG","images/flour.PNG","images/sugar.PNG"};
	private BufferedImage image;
	private boolean visible = true;
	
	//Methods
	public GroceryItems(){
		//Randmizing the starting positions
		identity = (int)((Math.random()*imagesOfItems.length)+1);
		y = -((int)(((Math.random()*3000) + 50)));
		x = (int)(((Math.random()*8)+1)*90);
		try {
			image = ImageIO.read(new File(imagesOfItems[identity - 1]));
        }catch(IOException e) {
            e.printStackTrace();
        }
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
}