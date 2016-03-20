package komunikator;

import java.io.*;
import java.net.*;

public class KomunikatorKlient {
	public static void main(String[] args) {
		Socket kkSocket = null;
		try {
			kkSocket = new Socket("127.0.0.1", 4444);
			new Pisarz(kkSocket).start();
			new Czytelnik(kkSocket).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
