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
			System.out.println("B³êdny adres!");
		}
	}

}////SPRÓBOWAÆ W DOMU SAMEMU
//////Wejœciówka to co na wyk³adzie i to co by³o na poprzednim i STRUMIENIE!!!!  WA¯NIAK wyk³ad u niego klasy abstrakcyjne reprezentuj¹ce strumienie
/////Jakie metody one oferuj¹
