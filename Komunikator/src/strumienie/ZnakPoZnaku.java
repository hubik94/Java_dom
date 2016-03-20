package strumienie;

import java.io.FileReader;
import java.io.IOException;

public class ZnakPoZnaku {
	public static void main(String[] args) throws IOException {
		// wersja dla Linuxa
		FileReader rd = new FileReader("/tmp/io_test.txt");
		// wersja dla Windows
		// FileReader rd = new FileReader("c:\\io_test.txt");
		try {
			int i;
			// Reader.read() Daje wartoœæ z przedzia³u 0 to 65535,
			// je¿eli odczyt siê powiód³ lub -1 jak nie
			while ((i = rd.read()) != -1)
				System.out.print((char) i);
		} finally {
			rd.close();
		}
	}
}