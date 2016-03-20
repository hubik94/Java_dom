package Dodatkowe.Nauka;

import java.util.Scanner;

public class Imie {

	public static void main(String[] args) {
		String imie, nazwisko, wiek;
		Scanner read = new Scanner(System.in);
		System.out.println("Podaj swoje imie:");
		imie = read.nextLine();
		System.out.println("Podaj swoje nazwisko:");
		nazwisko = read.nextLine();
		System.out.println("Podaj swój wiek:");
		wiek = read.nextLine();
		System.out.println("Witaj "+imie+" "+nazwisko+", masz "+wiek+" lat");
	}

}
