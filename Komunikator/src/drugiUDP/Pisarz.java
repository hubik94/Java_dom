package drugiUDP;

import java.net.*;
import java.io.*;

public class Pisarz extends Thread {

	DatagramSocket sock = null;
	private int port;
	private String s1;

	public Pisarz(DatagramSocket sock, int port, String s1) {
		super();
		this.sock = sock;
		this.port = port;
		this.s1 = s1;
	}

	public void run() {
		//BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		try {
			InetAddress host = InetAddress.getByName("localhost");

			while (true) {
				//s = cin.readLine();
				byte[] b = s1.getBytes();

				DatagramPacket dp = new DatagramPacket(b, b.length, host, port);
				sock.send(dp);
				if (s1.equals("Bye")) {
					break;
				}
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}
