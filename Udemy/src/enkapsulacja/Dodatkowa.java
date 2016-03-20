package enkapsulacja;

public class Dodatkowa {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private int oblicz(){
		return 21;
	}
	
	protected void wypisz(){
		System.out.println("Twoje imie to: " + name + " masz " + oblicz() + " lat");
	}
	
	public Dodatkowa(){
		
	}
}
