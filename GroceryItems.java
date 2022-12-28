import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
//Each grocery item will be idenitifed by a number 

class GroceryItems{
	//Declaring variables
	private int identity,x,y,width,height; 
	private String[] imagesOfItems = {"images\\egg.PNG", "images\\milk.PNG","images\\strawberry.PNG","images\\bread.PNG","images\\flour.PNG","images\\sugar.PNG"};
	private BufferedImage image1, image2,image3,image4,image5,image6;
	private boolean visible;
	
	//Methods
	public GroceryItems(){
		//Randmizing the starting positions 
		identity = (int)(Math.random()*6)+1; 
		
		y = (int)(((Math.random()*80)-100)*100);
		x = (int)(((Math.random()*8)+1)*100);
		
		try {
            image1 = ImageIO.read(new File(imagesOfItems[0]));
			image2 = ImageIO.read(new File(imagesOfItems[1])); 
			image3 = ImageIO.read(new File(imagesOfItems[2])); 
			image4 = ImageIO.read(new File(imagesOfItems[3]));
			image5 = ImageIO.read(new File(imagesOfItems[4]));
			image6 = ImageIO.read(new File(imagesOfItems[5]));
			
        }catch(IOException e) {
            e.printStackTrace();
        }
		
		width = 70;
		height = 84; 
		visible = true;
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
		}else if(identity == 3){
			g.drawImage(image3,x,y,null); 
		}else if(identity == 4){
			g.drawImage(image4,x,y,null); 
		}else if(identity == 5){
			g.drawImage(image5,x,y,null);
		}else{
			g.drawImage(image6,x,y,null);
		}
    }	   
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	
	public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
	
}