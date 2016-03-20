package baza.dane;

public class Zawodnik {
	String imie, nazwisko;
	private int id;

	public Zawodnik(int id, String im, String naz) {
		imie = im;
		nazwisko = naz;
		this.id = id;
	}

	public void wypiszDane() {
		System.out.println("Zawodnik " + imie + " " + nazwisko);
	}
}
