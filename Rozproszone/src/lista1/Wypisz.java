package lista1;

public class Wypisz extends Thread {
	World world;

	public Wypisz(World world) {
		this.world = world;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < world.n; i++) {
				System.out.println("Wartoœæ tablic o indeksie " + i + " = " + world.tab[i]);
				world.tab[i] = 0;
			}
		}
	}

}
