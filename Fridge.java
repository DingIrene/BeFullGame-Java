/*
Name: Irene D & Janice H
Date: January 18, 2023
Teacher: Ms. Strelkovska
Description: Fridge class
*/
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Fridge extends JPanel implements ActionListener{
	//Declaring variables
	private String name;
	//Remember we are storing the number of items not the idenity of the item; the index number is the idenity
	private ArrayList<Integer> storage = new ArrayList<Integer>();
	private JButton[] button = new JButton[6];
	private String[] icons = {"images/egg.PNG", "images/milk.PNG","images/strawberry.PNG","images/bread.PNG","images/flour.PNG","images/sugar.PNG"};
	private int indentity; 
	private String[] listofItems = {"Egg", "Milk", "Strawberry", "Bread", "Flour", "Sugar"}; 
	
	public Fridge(){ //constructor
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setSize(new Dimension(30, 100));
		this.add(Box.createHorizontalStrut(20));
		GroceryItems items = new GroceryItems();
		for(int i = 0; i <6; i++){
			ImageIcon image = new ImageIcon(icons[i]);
			button[i] = new JButton(image); 
			button[i].addActionListener(this);
			this.add(button[i]); 
		}
		for(int j = 0; j < 6; j++){
			storage.add(0);
		}
	}
	
	public void addToFridge(int identity){
		int temp  = (storage.get(identity)) +1;
		System.out.println("New amount is: "+temp);
		
        storage.set(identity, temp);
	}
	
	public void removeFrom(int identity, int num){
		int temp = (storage.get(identity)) - num;
		storage.set(identity, temp);
	}
	
	public int getNumberOfItem(int identity){ 
		System.out.println(storage); 
		return storage.get(identity); 
	}
	
	public String itemDescript(int identity){
		return listofItems[identity] + (": "+getNumberOfItem(identity)); 
	}
	
	public void actionPerformed(ActionEvent e){
		for(int i = 0; i <6; i++){
			if(e.getSource()== button[i] ){
				JOptionPane.showMessageDialog(null,itemDescript(i),"Collected", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
}