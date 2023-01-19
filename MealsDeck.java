/*
Name: Irene D & Janice H
Date: January 18, 2023
Teacher: Ms. Strelkovska
Description: Part of the kitchen panel, where it shows the meal deck
*/

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MealsDeck extends JPanel implements ActionListener{
	private ImageIcon[] meals=new ImageIcon[3];;
	private String[] mealString = {"images/mealCake.PNG","images/mealSmoothie.PNG","images/mealRoll.PNG"};
	private JButton b1, b2,b3, b4, fridge; 
	//private boolean enough = false;
	private int[] cake =  new int[]{0,1,2,1,2,1,7};
	private int[] smoothie =  new int[]{0,2,3,0,0,1,6};
	private int[] roll = new int[]{1,2,3,2,1,0,9};
	public static HealthBar bar; 
	private int checker = 0;
	
	public MealsDeck(){
		JPanel pane = new JPanel(); 
		this.add(pane);
		GridLayout grid1;
		grid1 = new GridLayout(1,3);
		grid1.setHgap(50);
		pane.setLayout(grid1); 
		pane.setSize(700, 300);
		this.setOpaque(false); 
		pane.setOpaque(false);
		
		bar = new HealthBar(); 
		
		for(int i = 0; i <3; i++){
			meals[i] = new ImageIcon(mealString[i]);
		}
		b1= new JButton(meals[0]);
		b1.addActionListener(this);
		b2= new JButton(meals[1]);
		b2.addActionListener(this);
		b3= new JButton(meals[2]);
		b3.addActionListener(this);
		
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(false);
		
		pane.add(b1);
		pane.add(b2);
		pane.add(b3);
		
		//Declaring the requirements needed to cook each meal 
		
	}
	
	public boolean check(int storageOfItem, int need){
		if(storageOfItem >= need){
			return true;			
		}
		return false;
	}
	
	public void actionListener(ActionEvent e){}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b1){
			for(int i = 0; i < 6; i++){
				int need = cake[i]; 
				if(check(GroceryGame.frigo.getNumberOfItem(i), need) == false){
					checker += 1;
				}
			}
			if(checker >= 1){
				JOptionPane.showMessageDialog(null,"Not enough ingredients!","", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				cooking();
				bar.addXP(cake[6]);
				bar.isFull();
				bar.isColored();
				for(int i = 0; i < 6; i++){
					GroceryGame.frigo.removeFrom(i, cake[i]);
				}
			}
			checker = 0;
		}
		else if(e.getSource() == b2){
			for(int i = 0; i < 6; i++){
				int need = smoothie[i]; 
				if(check(GroceryGame.frigo.getNumberOfItem(i), need) == false){
					checker += 1;
				}
			}
			if(checker >= 1){
				JOptionPane.showMessageDialog(null,"Not enough ingredients!","", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				cooking();
				bar.addXP(smoothie[6]);
				bar.isFull();
				bar.isColored();
				for(int i = 0; i < 6; i++){
					GroceryGame.frigo.removeFrom(i, smoothie[i]);
				}
			}
			checker = 0;
		}
		else if(e.getSource() == b3 ){
			for(int i = 0; i < 6; i++){
				int need = roll[i]; 
				if(check(GroceryGame.frigo.getNumberOfItem(i), need) == false){
					checker += 1;
				}
			}
			if(checker >= 1){
				JOptionPane.showMessageDialog(null,"Not enough ingredients!","", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				cooking();
				bar.addXP(roll[6]);
				bar.isFull();
				bar.isColored();
				for(int i = 0; i < 6; i++){
					GroceryGame.frigo.removeFrom(i, roll[i]);
				}
			}
			checker = 0;
		}
	}
	
	public void cooking(){
		ImageIcon icon = new ImageIcon(Kitchen.class.getResource("images/cooking.gif").getFile());
		JLabel label2 = new JLabel(icon);
		JLabel label = new JLabel("CHOP!");
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(label2,BorderLayout.CENTER); 
		panel.add(label, BorderLayout.SOUTH); 
		JOptionPane.showMessageDialog(null,panel, "Time to cook!",JOptionPane.INFORMATION_MESSAGE);
	}
}