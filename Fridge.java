import java.util.*;
class Fridge{
	private String name;
	//Remember we are storing the number of items not the idenity of the item; the index number is the idenity
	private ArrayList<Integer> storage = new ArrayList<Integer>();
	
	public Fridge(String name){
		name = this.name; 
	}
	
	//I am wondering if this can be private? 
	private void addToFridge(int identity){
		storage.get(identity) += 1;  // adding 1 to that index, fix the code
	}
	
	public String getNumberOfItem(int identity){
		return storage.get(idenity); 
	}
}