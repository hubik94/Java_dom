package mojKomunikator;

import java.io.*;
import java.net.*;

public class Serwer {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(7777);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            new Pisarz(clientSocket).start();
            new Czytelnik(clientSocket).start();
            while(true){}
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        clientSocket.close();
        serverSocket.close();
	}

}
