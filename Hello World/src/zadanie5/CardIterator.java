package zadanie5;

import java.util.*;

public class CardIterator implements Iterator {
	private static int nr = 1;

	public CardIterator() {
	}

	public static void main(String[] args) {
		CardIterator karta = new CardIterator();
		while (nr<15){
			karta.next();
			karta.wypisz();	
		}
	}

	public void wypisz(){
		if (nr > 1 && nr < 11)
			System.out.println("Karta o numerze: " + nr);
		else {
			switch (nr) {
			case 11:
				System.out.println("Karta Jopek");
				break;
			case 12:
				System.out.println("Karta Dama");
				break;
			case 13:
				System.out.println("Karta Król");
				break;
			case 14:
				System.out.println("Karta As");
				break;
			}
		}
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object next() {
		nr++;
		return nr;
	}

}