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
	private int xp; 
	private boolean isFull; 
	private String[] imagesOfItems = {"images/notFull.PNG", "images/full.PNG"}; 
	private BufferedImage image1, image2;
	
	public HealthBar(){
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
	}
	
	public boolean isFull(){
		if(xp >= 100){
			isFull = true; 
		}
		return isFull; 
	}
	
	public boolean isColored(){
		if(xp >= 25){
			return true; 
		}
		else{
			return false; 
		}
	}
	
	public void myDraw(Graphics g){
		for(int i = 0; i < 4; i++){
			if(xp >= 100 - (25*(4-1))){
				g.drawImage(image2, 0, 35 + (i*30), null);
			}else{
				g.drawImage(image1, 0, 35 + (i*30), null);
			}
		}
		g.drawString("Full: " + ""+(xp/100) + "%",0, 25);
		
    }

}