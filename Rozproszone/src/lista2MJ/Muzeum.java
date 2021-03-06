package lista2MJ;

public class Muzeum {
	static int Max = 5;
	volatile int PeopleIn = 0;

	public static void main(String[] args) {
		Muzeum muzeum = new Muzeum();
		new Bramka(muzeum).start();
	}

	synchronized public boolean isFree() {
		String name = Thread.currentThread().getName();
		if (PeopleIn < Max) {
			System.out.println("Do muzeum wchodzi: " + name);
			PeopleIn++;
			return true;
		} else {
			System.out.println("Do muzeum nie mo�e wej��: " + name);
			return false;
		}
	}
	
	synchronized public void exitFromMuseum(){
		String name = Thread.currentThread().getName();
		System.out.println("Z muzeum wychodzi: " + name);
		PeopleIn--;
	}

}
