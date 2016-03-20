package mojKomunikator;

import java.io.*;
import java.net.*;

public class Klient {

	public static void main(String[] args) throws IOException {
		Socket kkSocket = null;
		try {
			kkSocket = new Socket("localhost", 7777);
			new Pisarz(kkSocket).start();
			new Czytelnik(kkSocket).start();
			while(true){}
		} catch (UnknownHostException e) {
			System.err.println("Nie znalaz³em hosta");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Nie mogê znaleŸæ po³¹czenia z hostem");
			System.exit(1);
		}
		kkSocket.close();
	}

}