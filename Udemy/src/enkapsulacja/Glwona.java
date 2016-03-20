package enkapsulacja;

public class Glwona {
	public static void main(String[] args) {
		String name;
		Dodatkowa dod = new Dodatkowa();
		dod.setName("Hubert");
		name = dod.getName();
		//System.out.println(name);
		dod.wypisz();
	}
}
