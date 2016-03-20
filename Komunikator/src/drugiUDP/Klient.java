//package drugiUDP;
//
//import java.net.*;
//
//public class Klient {
//	
//	public Klient(){
//		
//	}
//
//	public static void main(String[] args) {
//		DatagramSocket sock = null;
//		int port = 7777;
//		int port2 = 8888;
//		try {
//			sock = new DatagramSocket(port2);
//		} catch (SocketException e) {
//			e.printStackTrace();
//		}
//		new Czytelnik(sock, port2).start();
//		new Pisarz(sock, port).start();
//		while(true){}
//	}
//}
