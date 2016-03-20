package serializacjaTablice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadObject {
	
	public static void main(String[] args) {
		try (FileInputStream fi = new FileInputStream("people.bin")) {
			
			ObjectInputStream os = new ObjectInputStream(fi);
			
			Person[] people = (Person[])os.readObject();
			
			@SuppressWarnings("unchecked")
			ArrayList<Person> peopleList = (ArrayList<Person>)os.readObject();
			
			for(Person person : people){
				System.out.println(person);
			}
			
			for(Person person : peopleList){
				System.out.println(person);
			}
			
			int num = os.readInt();
			for(int i=0; i < num; i++){
				Person person = (Person)os.readObject();
				System.out.println(person);
			}
			
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
