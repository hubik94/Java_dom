package lekcja51;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
	
	public static void main(String[] args) {
		try (ObjectInputStream os = new ObjectInputStream(new FileInputStream("people.bin"));) {
			
			Person people = (Person)os.readObject();
			
			System.out.println(people);
			
			os.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku");
		} catch (IOException e) {
			System.out.println("IOException");
		} catch (ClassNotFoundException e) {
			System.out.println("Nie znaleziono klasy obiektu");
		}
	}

}