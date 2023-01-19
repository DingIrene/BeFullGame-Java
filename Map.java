/*
Name: Irene D & Janice H
Date: January 18, 2023
Teacher: Ms. Strelkovska
Description: Map class
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Map extends JPanel implements ActionListener{
	//Declaring variables
	private Image pic; 
	private JButton b1, b2, b3, b4, b5;
	
	public Map(){
		//background
		ImageIcon obj = new ImageIcon("images/map.PNG");  
		pic = obj.getImage();
		
		this.setLayout(null);
		
		//Buttons to different JPanels
		b1 = new JButton("");
		b1.setBounds(80, 120, 185, 90);
		this.add(b1);
		b1.addActionListener(this);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		
		b2 = new JButton("");
		b2.setBounds(587, 65, 90, 90);
		this.add(b2);
		b2.addActionListener(this);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		
		b3 = new JButton("");
		b3.setBounds(70, 380, 200, 100);
		this.add(b3);
		b3.addActionListener(this);
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(false);
		
		b4 = new JButton("");
		b4.setBounds(530, 320, 90, 80);
		this.add(b4);
		b4.addActionListener(this);
		b4.setContentAreaFilled(false);
		b4.setBorderPainted(false);
		
		b5 = new JButton("");
		b5.setBounds(870, 270, 90, 130);
		this.add(b5);
		b5.addActionListener(this);
		b5.setContentAreaFilled(false);
		b5.setBorderPainted(false);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(pic, 0, 0, null);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1){
			BeFullMain.cards.next(BeFullMain.cont);
		}
		else if(e.getSource() == b2){
			JOptionPane.showMessageDialog(null,"Uh oh! You are too hungry to go to school :( Fill up before heading to class!","School", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == b3){
			JOptionPane.showMessageDialog(null,"You start heading to the park but suddenly your stomach grumbles really loud... how embarrassing! Maybe you should eat something first.","Park", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == b4){
			JOptionPane.showMessageDialog(null,"Uh oh! You are too weak for the gym, how about some protein? >:)","Gym", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == b5){
			BeFullMain.cards.last(BeFullMain.cont);
		}
	}
}