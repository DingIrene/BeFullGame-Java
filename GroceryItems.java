import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
//Each grocery item will be idenitifed by a number 

class GroceryItems{
	//Declaring variables
	private int identity,x,y; 
	private String[] imagesOfItems = {"images\\egg.PNG", "images\\milk.PNG","images\\strawberry.PNG"};
	private BufferedImage image1, image2,image3;
	
	//Methods
	public GroceryItems(){
		//Randmizing the starting positions 
		identity = (int)(Math.random()*3)+1; 
		
		y = (int)(((Math.random()*80)-100)*100);
		x = (int)(((Math.random()*8)+1)*100);
		try {
            image1 = ImageIO.read(new File(imagesOfItems[0]));
			image2 = ImageIO.read(new File(imagesOfItems[1])); 
			image3 = ImageIO.read(new File(imagesOfItems[2])); 
			
        }catch(IOException e) {
            e.printStackTrace();
        }
	}
	
	public int getIdentity(){
		return identity; 
	}
	
	public void move(){
		y += 40; 
		x += 1;
	}
	
	public void myDraw(Graphics g){
		if(identity == 1){
			g.drawImage(image1,x,y,null); 
		}else if(identity == 2){
			g.drawImage(image2,x,y,null); 
		}else{
			g.drawImage(image3,x,y,null); 
		}
    }	   
	
	
}