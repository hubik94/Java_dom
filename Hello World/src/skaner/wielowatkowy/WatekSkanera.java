package skaner.wielowatkowy;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class WatekSkanera extends Thread {

	private String adres;
	private int port;
	ThreadGroup gr;

	public WatekSkanera(ThreadGroup g, String adres, int port) {
		super(g, "skanerki");
		this.adres = adres;
		this.port = port;
		gr = g;
	}

	@Override
	public void run() {
		Socket socket = null;
		try {
			socket = new Socket(adres, port);
			MultiSkaner.tablicaWynikow[port] = port;
			socket.close();
		} catch (UnknownHostException e) {
			System.err.println("Nieznany host");
		} catch (IOException e) {
		}
	}
}