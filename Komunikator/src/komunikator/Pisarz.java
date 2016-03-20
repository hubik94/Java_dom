package komunikator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;

public class Pisarz extends Thread {
	Socket socket;

	public Pisarz(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		try {
			PrintWriter printer = new PrintWriter(socket.getOutputStream());
			while ((line = reader.readLine()) != null)
				printer.print(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
