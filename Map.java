import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Map implements ActionListener{
	//Declaring variables
	private Image pic; 
	
	public Map(){
		// (Should be the picture of the map) ImageIcon obj = new ImageIcon("images/Kitchen.PNG");  
		pic = obj.getImage();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(pic, 0, 0, null);
	}
}
