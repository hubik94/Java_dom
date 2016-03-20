package serializacja;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
	
	public static void main(String[] args) {
		try (FileInputStream fi = new FileInputStream("people.bin")) {
			
			ObjectInputStream os = new ObjectInputStream(fi);
			
			Person person1 = (Person)os.readObject();
			Person person2 = (Person)os.readObject();
			
			os.close();
			
			System.out.println(person1);
			System.out.println(person2);
			
		} catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku");
		} catch (IOException e) {
			System.out.println("IOException");
		} catch (ClassNotFoundException e) {
			System.out.println("Nie znaleziono klasy obiektu");
		}
	}

}
