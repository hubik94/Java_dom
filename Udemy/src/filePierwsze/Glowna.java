package filePierwsze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Glowna {
	public static void main(String[] args) {
		String fileName="C:\\Users\\hubik_000\\Desktop\\text.txt";
		
		File textFile = new File(fileName);
		Scanner in = null;
		try {
			in = new Scanner(textFile);
		} catch (FileNotFoundException e) {
			System.out.println("Nie mo�na otworzy� pliku");
		}
			
		StringBuilder sb = new StringBuilder();
		int value = in.nextInt();
		System.out.println("Warto�� to: " + value);
		
		in.nextLine();  //powoduje �e w p�tli nie zczytuje "dodatkowej" linii po nextInt
		
		while(in.hasNextLine()){
			sb.append(in.nextLine()+"\n");
		}
		System.out.println(sb);
		in.close();
	}
}
