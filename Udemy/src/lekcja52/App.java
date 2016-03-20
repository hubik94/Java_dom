package lekcja52;

public class App {

	public static void main(String[] args) {
		App app = new App();

		int value = 7;

		app.show(value);
		
		Person person = new Person("Hubert");
		System.out.println("1. " + person);
		
		app.show(person);
	}

	public void show(int value) {
		System.out.println(value);
	}
	
	public void show(Person person){
		System.out.println("2. " + person);
	}
}
