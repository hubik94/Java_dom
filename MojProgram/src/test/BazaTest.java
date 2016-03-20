package test;

import java.util.List;
import java.util.Scanner;
import baza.dane.Zawodnik;
import program.glowny.Program;

public class BazaTest {

	public static void main(String[] args) {
		Program p = new Program();
		String imie, nazwisko;
		Scanner read = new Scanner(System.in);
		System.out.println("Podaj imi� zawodnika: ");
		imie = read.nextLine();
		imie = imie.trim();
		System.out.println("Podaj nazwisko zawodnika: ");
		nazwisko = read.nextLine();
		nazwisko = nazwisko.trim();

		p.insertZawodnik("Hubert", "Matan");
		p.insertZawodnik("Karol", "Draganik");

		List<Zawodnik> zawodnicy = p.selectZawodnicy();

		System.out.println("Lista zawodnik�w: ");
		for (Zawodnik z : zawodnicy)
			System.out.println(z);
		
		p.closeConnection();
	}
}
