package lista1;

public class Zad2 extends Thread {

	World world;
	// int n = super.n;
	static int i = 0;

	public Zad2(World world) {
		this.world = world;
	}

	@Override
	public void run() {
		while (i < world.n) {
			world.setInteger();
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("nie uda�o si�!");
			}
		}
	}

}
