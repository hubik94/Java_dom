package lekcja46;

public class Robot {
	private int id;
	
	private class Brain{
		public void think(){
			System.out.println("Robot " + id + " is thinking");
		}
	}

	static class Battery{
		public void charge(){
			System.out.println("Battery charging...");
		}
	}
	
	public Robot(int id) {
		this.id = id;
	}
	
	public void start(){
		System.out.println("Starting robot " + id);
		Brain brain = new Brain();
		brain.think();
		
		final String name = "robert";
		
		class Temp{
			public void doSomething(){
				System.out.println("Id is: " + id);
				System.out.println("My name is: " + name); //do lokalnej zmiennej mo�e si� odwo�ywa� tylko je�eli jest final
				//do zmiennych g��wnej klasy odwo�uje si� normalnie
			}
		}
		
		Temp temp = new Temp();
		temp.doSomething();
	}
}
