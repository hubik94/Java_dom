package program.glowny;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import baza.dane.Zawodnik;
import sun.font.CreatedFontTracker;

public class Program {
	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:Program.db";

	private Connection conn;
	private Statement stat;

	public Program() {
		try {
			Class.forName(Program.DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("Brak sterownika JDBC");
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(DB_URL);
			stat = conn.createStatement();
		} catch (SQLException e) {
			System.err.println("Problem z otwarciem po³¹czenia");
			e.printStackTrace();
		}
		stworzTabele();
	}

	public boolean stworzTabele() {
		String createZawodnicy = "CREATE TABLE IF NOT EXISTS zawodnicy (id_zawodnika INTEGER PRIMARY KEY AUTOINCREMENT, imie varchar(100), nazwisko varchar(100)";
		try {
			stat.execute(createZawodnicy);
		} catch (SQLException e) {
			System.err.println("B³¹d przy tworzeniu tabeli");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean insertZawodnik(String imie, String nazwisko) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("insert into zawodnicy values(NULL, ?, ?);");
			prepStmt.setString(1, imie);
			prepStmt.setString(2, nazwisko);
			prepStmt.execute();
		} catch (SQLException e) {
			System.err.println("B³¹d przy dodawaniu zawodnika");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Zawodnik> selectZawodnicy() {
		List<Zawodnik> zawodnicy = new LinkedList<Zawodnik>();
		try {
			ResultSet result = stat.executeQuery("SELECT * FROM zawodnicy");
			int id;
			String imie, nazwisko;
			while (result.next()) {
				id = result.getInt("id_zawodnika");
				imie = result.getString("imie");
				nazwisko = result.getString("nazwisko");
				zawodnicy.add(new Zawodnik(id, imie, nazwisko));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return zawodnicy;
	}

	public void closeConnection(){
		try{
			conn.close();
		}catch(SQLException e){
			System.err.println("Problem z zamkniêciem po³¹czenia");
			e.printStackTrace();
		}
	}
	/*
	 * String imie, nazwisko; Scanner read = new Scanner(System.in);
	 * System.out.println("Podaj imiê zawodnika: "); imie = read.nextLine();
	 * imie = imie.trim(); System.out.println("Podaj nazwisko zawodnika: ");
	 * nazwisko = read.nextLine(); nazwisko = nazwisko.trim(); Zawodnik zaw =
	 * new Zawodnik(imie, nazwisko); zaw.wypiszDane();
	 */

}