package lekcja51;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 3748436598017597743L;
	private transient int id; /// nie serializuje tej warto�ci
	private String name;

	private static int count;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Person.count = count;
	}

	@Override
	public String toString() {
		return "Person [name = " + name + ", count = " + count + " ]";
	}
}
