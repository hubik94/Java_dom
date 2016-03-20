package drugiUDP;

import java.io.*;
import java.net.*;

public class Czytelnik extends Thread {

	DatagramSocket sock = null;
	private int port;
	public int p;
	private String s;

	public Czytelnik(DatagramSocket sock, int port) {
		super();
		this.sock = sock;
		this.port = port;
	}

	public void run() {
		try {

			byte[] buffer = new byte[65535];
			DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
			while (true) {
				sock.receive(incoming);
				byte[] data = incoming.getData();
				s = new String(data, 0, incoming.getLength());

				System.out.println(incoming.getAddress().getHostAddress() + " : " + incoming.getPort() + " : " + s);
				if (s.equals("Bye")) {
					System.out.println("Program zakoñczy³ dzia³anie!");
					break;
				}
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}
