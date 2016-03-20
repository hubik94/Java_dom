package lista2MJ;

public class Klient extends Thread {
	Muzeum muzeum;
	
	public Klient(Muzeum muzeum){
		this.muzeum = muzeum;
		
	}
	
	public void run() {
		boolean wartosc;
		do {
			wartosc = muzeum.isFree();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (wartosc == false);

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		muzeum.exitFromMuseum();
	}
}
