package mojKomunikator;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Pisarz extends Thread {

	Socket socket = null;
	String fromUser;
	Scanner read = new Scanner(System.in);
	
	public Pisarz(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run() {
		try {
			PrintWriter printer = new PrintWriter(socket.getOutputStream());
			while (true) {
				fromUser = read.nextLine();
				printer.println(fromUser);
				printer.flush();
				if(fromUser.equals("bye")){
					printer.close();
					System.out.println("Nast�pi�o roz��czenie!");
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("Nie uda�o si� wys�a� tekstu");
		}
	System.exit(0);
	}
}
