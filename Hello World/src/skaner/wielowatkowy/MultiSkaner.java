package skaner.wielowatkowy;

public class MultiSkaner {

	public static int[] tablicaWynikow = new int[65536];

	public static void main(String[] args) {

		ThreadGroup grupa = new ThreadGroup("skanerki");
		for (int i = 0; i < 2000; i++) {
			new WatekSkanera(grupa, "127.0.0.1", i).start();
		}
		while (grupa.activeCount() != 0) {// sprawdzenie czy w grupie s¹ aktywne
											// watki - zatrzymuje w¹tek bie¿¹cy
											// jeœli tak
		}
		for (int i : tablicaWynikow)
			if (i != 0)
				System.out.println("Wolny :" + i);
	}
}
