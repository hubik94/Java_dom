package serializacjaTablice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteObject {
	public static void main(String[] args) {
		System.out.println("Writting objects...");

		Person[] people = {new Person(21, "Sue"), new Person(3, "Mark"), new Person(7, "Bob")};
		
		ArrayList<Person> peopleList = new ArrayList<Person>(Arrays.asList(people));
		
		for(Person person : people){
			System.out.println(person);
		}

		try (FileOutputStream fs = new FileOutputStream("people.bin")) {

			ObjectOutputStream os = new ObjectOutputStream(fs);

			os.writeObject(people);			//zapisuje tablic� Person do pliku na raz
			
			os.writeObject(peopleList);		//zapisuje ArrayList do pliku
			
			os.writeInt(peopleList.size());
			
			for(Person person : peopleList){	//zapisuje tablic� po kolei do pliku
				os.writeObject(person);
			}
			
			os.close();

		} catch (FileNotFoundException e) {
			System.out.println("nie mo�na znale�� pliku");
		} catch (IOException e) {
			System.out.println("IOException");
		}

	}
}
