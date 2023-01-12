import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;

/*
Will randomize the recipes to use in a deck of recipes 
*/

public class Recipes{
	//Declaring variables
	private String[] imagesOfMeals = {}; 
	private BufferedImage meal1, meal2, meal3; 
	
	public Recipes(){
		for(int i = 0; i < 3; i ++){
			int random = (int)((Math.random()*imagesOfItems.length)+1);
			try {
				image[i+1] = ImageIO.read(new File());
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}