package komunikator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Czytelnik extends Thread {

	Socket socket = null;

	public Czytelnik(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String temp;
				while ((temp = socketIn.readLine()) != null)
					System.out.println(socket.getInetAddress() + " : " + temp);
				if (temp.equals("exit")) {
					socketIn.close();
					break;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}