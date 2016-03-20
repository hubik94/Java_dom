package komunikator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class KomunikatorServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(4444);
			Socket clientSocket = serverSocket.accept();
			new Pisarz(clientSocket).start();
			new Czytelnik(clientSocket).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
