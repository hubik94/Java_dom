package Polimorfizm;

public class Tree extends Plant{

	@Override
	public void grow() {
		System.out.println("Drzewo ro�nie");
	}
	
	public void umiera(){
		System.out.println("Nie�le");
	}
	
}
