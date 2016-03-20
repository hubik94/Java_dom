package skaner.domowe;

import java.net.*;
import java.io.*;

public class SkanerPortow {
	public static void main(String[] args) {
		for (int port = 1; port < 100; port++) {
			try {
				Socket s = new Socket("127.0.0.1", port);
				System.out.println("Otwarty port " + port);
				s.close();
			} catch (IOException e) {
			}
		}
	}
}
