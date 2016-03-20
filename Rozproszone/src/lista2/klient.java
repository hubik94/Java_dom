package lista2;

public class klient extends Thread {
	Museum muzeum = new Museum();

	public void run() {
		boolean wartosc = false;
		do {
			wartosc = muzeum.entrance.enterToMuseum();
		} while (wartosc == false);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		muzeum.exit.exitFromMuseum();
	}
}
