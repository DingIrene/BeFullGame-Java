/*
Name: Irene D & Janice H
Date: January 18, 2023
Teacher: Ms. Strelkovska
Description: 
*/

import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;

public class HealthBar{
	//Declaring variables
	private int xp; 
	private boolean isFull; 
	private String[] imagesOfItems = {"images/notFull.PNG", "images/full.PNG"}; 
	private BufferedImage image1, image2;
	
	public HealthBar(){ //constructor
		xp = 0; 
		isFull = false; 
		try {
			image1 = ImageIO.read(new File(imagesOfItems[0]));
			image2 = ImageIO.read(new File(imagesOfItems[1]));
        }catch(IOException e) {
            e.printStackTrace();
        }
	}
	
	public void addXP(int add){
		xp += add; 
		System.out.println("Xp: "+ xp); 
	}
	
	public boolean isFull(){
		if(xp >= 100){
			isFull = true; 
		}
		return isFull; 
	}

	public void myDraw(Graphics g){ //Draw out the health
		for(int i = 1; i < 5; i++){
			if(xp >= 100 - (25*(4-i))){
				g.drawImage(image2, 0, 10+ (i*30), null);
			}else{
				g.drawImage(image1, 0,10 +  (i*30), null);
			}
		}
		if(xp >= 100){
			g.drawString("Full: " + ""+100 + "%",0, 40);
		}else{
			g.drawString("Full: " + ""+xp + "%",0, 40);
		}
    }

}