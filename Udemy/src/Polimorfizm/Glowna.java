package Polimorfizm;

public class Glowna {
	public static void main(String[] args) {
		Plant plant1 = new Plant();
		Tree tree = new Tree();
		
		Plant plant2 = plant1;
		
		plant2.grow();
		tree.grow();
		
		doGrow(tree);
	}
	
	public static void doGrow(Plant plant){
		plant.grow();
	}
}