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
	private JButton b1, b2,b3;
	private int clickCount = 0; 
	//private Icon locked = new ImageIcon("white.PNG"); 
	private HealthBar xpBar; 
	
	public Kitchen(){
		ImageIcon obj = new ImageIcon("images/Kitchen.PNG"); 
		pic = obj.getImage();
		
		b1= new JButton("");
		b1.addActionListener(this);
		b2= new JButton("");
		b2.addActionListener(this);
		b3= new JButton("");
		b3.addActionListener(this);
		
		this.add(b1);
		this.add(b2);
		this.add(b3); 
		
		xpBar = new HealthBar(); 
		 
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(pic, 0, 0, null);
		xpBar.myDraw(g);
		
	}
	
	public void actionListener(ActionEvent e){}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1){
			cooking(); 
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