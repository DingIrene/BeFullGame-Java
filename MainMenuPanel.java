import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//Need to import the instructions image that will be in the popup of the instructions button

class MainMenuPanel extends JPanel implements ActionListener{
	//Declaring variables
	private JButton b1,b2,b3; 
	private static ImageIcon instructions; 
		
	public MainMenuPanel(){
		b1 = new JButton("Instructions"); 
		b2 = new JButton("Go Shopping"); 
		b3 = new JButton("Exit"); 
		
		this.setLayout(new FlowLayout());
		
		this.add(b1);
		this.add(b2);  
		this.add(b3);
	  
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		//instructions= new ImageIcon("InstructionsPoints.PNG"); png of the instructions
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			this.setBackground(Color.pink); 
			//Pop up window of the instructions
			JOptionPane.showMessageDialog(null,"","Instructions", JOptionPane.INFORMATION_MESSAGE,instructions);
		}	
		else if (e.getSource()==b2){ 
			BeFullMain.cards.next(BeFullMain.cont);
		}
		else if (e.getSource()==b3){
			JOptionPane.showMessageDialog(null, "That was an exit button", "My exit message",JOptionPane.WARNING_MESSAGE ); 
			System.exit(0);
		}	
    }

	
	public void paintComponent(Graphics g){
	   super.paintComponent(g);
	}

}

