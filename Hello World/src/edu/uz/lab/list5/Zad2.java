package edu.uz.lab.list5;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Zad2 {

	public static void main(String[] args) throws Exception {
		String adres;
		System.out.println("Podaj adres URL");
		Scanner odczyt = new Scanner(System.in);
		adres = odczyt.nextLine();
		try{
			URL adresUrl = new URL("http://" + adres);
			URLConnection conn = adresUrl.openConnection();	
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		}catch(MalformedURLException e){
			System.out.println("B��dny adres!");
		}
	}

}////SPR�BOWA� W DOMU SAMEMU
//////Wej�ci�wka to co na wyk�adzie i to co by�o na poprzednim i STRUMIENIE!!!!  WA�NIAK wyk�ad u niego klasy abstrakcyjne reprezentuj�ce strumienie
/////Jakie metody one oferuj�
