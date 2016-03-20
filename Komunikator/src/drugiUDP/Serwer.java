//package drugiUDP;
//
//import java.net.*;
//
//public class Serwer {
//
//	public static void main(String[] args) {
//		DatagramSocket sock = null;
//		int port = 7777;
//		int port2 = 8888;
//		try {
//			sock = new DatagramSocket(port);
//		} catch (SocketException e) {
//			e.printStackTrace();
//		}
//		new Czytelnik(sock, port).start();
//		new Pisarz(sock, port2).start();
//		while(true){}
//	}
//}
