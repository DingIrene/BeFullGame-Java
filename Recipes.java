import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;

/*
Will randomize the recipes to use in a deck of recipes 
*/

//How/what will i return to the kitchen class

public class Recipes{
	//Declaring variables
	private static String[] imagesOfMeals = {"images/mealSmoothie.PNG","images/mealToast.PNG", "images/mealCake.PNG", "images/mealRoll.PNG","images/mealPancake.PNG", "images/mealDonut.PNG"}; 
	private String[] randomMeals;  
	
	public Recipes(){
		for(int i = 0; i < 3; i ++){
			int random = (int)((Math.random()*imagesOfMeals.length)+1);
			randomMeals[i+1] = imagesOfMeals[random]; 
		}
	} 
	
	public String icon(int number){
		String mealID = randomMeals[number];
		return mealID; 	 
	}
}