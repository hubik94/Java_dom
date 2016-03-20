package generic.Wildcards;

import java.util.ArrayList;

class Machine {

	String name;
	int age;

	public Machine(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Your name is " + name + " and your age is " + age;
	}

	public void start() {
		System.out.println("Machine launched");
	}
}

class Camera extends Machine {

	int mp;

	public Camera(String name, int age, int mp) {
		super(name, age);
		this.mp = mp;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Your name is " + name + " your age is " + age + " and yours mp is " + mp;
	}

	public void snap() {
		System.out.println("Camera took photo");
	}
}

public class Glowna {
	public static void main(String[] args) {

		ArrayList<Machine> list = new ArrayList<Machine>();
		list.add(new Machine("Hubert", 21));
		list.add(new Machine("Andrzej", 25));

		ArrayList<Camera> list2 = new ArrayList<Camera>();
		list2.add(new Camera("Zuzia", 20, 8));
		list2.add(new Camera("Ela", 48, 12));

		// showList(list);
		// showList(list2);
		showList2(list2);
	}

	public static void showList(ArrayList<? extends Machine> list) {
		for (Machine value : list) {
			System.out.println(value);
			value.start();
		}
	}

	public static void showList2(ArrayList<? super Camera> list) {
		for (Object value : list) {
			System.out.println(value);
		}
	}

	public static void showList3(ArrayList<?> list) {
		for (Object value : list) {
			System.out.println(value);
		}
	}
}
