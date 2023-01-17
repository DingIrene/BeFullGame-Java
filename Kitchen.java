/*
Name: Irene D & Janice H
Date: January 18, 2023
Teacher: Ms. Strelkovska
Description: Kitchen class
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Kitchen extends JPanel implements ActionListener{
	//Declaring variables
	private Image pic; 
	private JButton b1, b2,b3, b4, fridge;
	private int clickCount = 0; 
	//private Icon locked = new ImageIcon("white.PNG"); 
	private HealthBar xpBar;
	private ImageIcon[] meals=new ImageIcon[3];;
	private String[] mealString = {"images/mealCake.PNG","images/mealSmoothie.PNG","images/mealRoll.PNG"};
	private Fridge frigo; 
	
	public Kitchen(){
		ImageIcon obj = new ImageIcon("images/Kitchen.PNG"); 
		pic = obj.getImage();
		
		frigo = new Fridge(); 
		
		for(int i = 0; i <3; i++){
			meals[i] = new ImageIcon(mealString[i]);
		}
		
		xpBar = new HealthBar(); 
		/*for(int i = 0; i <3; i ++){
			meals[i] = new ImageIcon(xpBar.icon(i)); 
		}*/
		
		
		//Recipe cards

		b1= new JButton(meals[0]);
		b1.addActionListener(this);
		b2= new JButton(meals[1]);
		b2.addActionListener(this);
		b3= new JButton(meals[2]);
		b3.addActionListener(this);
	
		fridge = new JButton("Fridge");
		fridge.addActionListener(this); 
		
		b4 = new JButton("Back"); 
		b4.addActionListener(this); 
		
		this.add(b1);
		this.add(b2);
		this.add(b3); 
	
		this.add(fridge); 
		this.add(b4); 
		
		xpBar = new HealthBar(); 
		 
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(pic, 0, 0, null);
		xpBar.myDraw(g);
		
	}
	
	public void actionListener(ActionEvent e){}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1||e.getSource()==b2 || e.getSource()==b3 ){
			cooking(); 
		}else if(e.getSource() == b4){
			BeFullMain.cards.previous(BeFullMain.cont);
			BeFullMain.cards.previous(BeFullMain.cont);
		}else if(e.getSource() == fridge){
			JOptionPane.showMessageDialog(null,frigo,"Collected", JOptionPane.INFORMATION_MESSAGE);
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