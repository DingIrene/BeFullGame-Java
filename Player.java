public class Player{
	private int xp; 
	private boolean isGreen; 
	
	public Player(){
		xp = 0; 
		isGreen = false; 
	}
	
	public void addXP(int add){
		xp += add; 
	}
	
	public boolean isBarGreen(){
		if(xp >= 80){
			isGreen = true; 
		}
		return isGreen; 
	}
	
	/*
	public void DrawBar(Graphics g){
		
    }
	*/
}