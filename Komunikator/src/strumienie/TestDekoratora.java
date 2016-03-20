package strumienie;

import java.io.*;

public class TestDekoratora {
	public static void main(String[] args) throws IOException {
		// wersja dla Linuxa
		String nazwaPliku = "/tmp/io_test.txt";
		// wersja dla Windows
		// String nazwaPliku = "c:\\io_test.txt";

		DataOutputStream os = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nazwaPliku)));
		os.writeBoolean(true);
		os.writeInt(1234567890);
		os.writeDouble(Math.PI);
		os.writeUTF("Test strumieni.\n¹æê³ñóœŸ¿\n");
		os.close();// wykonuje flush()

		DataInputStream is = new DataInputStream(new BufferedInputStream(new FileInputStream(nazwaPliku)));
		Boolean b = is.readBoolean();
		Integer i = is.readInt();
		Double d = is.readDouble();
		String str = is.readUTF();
		is.close();

		System.out.printf("Odczytano: b=%s, i=%s, d=%s, str=%s", b, i, d, str);
	}
}