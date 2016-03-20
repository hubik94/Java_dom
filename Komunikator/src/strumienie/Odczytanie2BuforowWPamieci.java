package strumienie;

import java.io.*;

public class Odczytanie2BuforowWPamieci {
	public static void main(String[] args) throws IOException {
		String daneDlaBufora1 = "Dane dla bufora 1.\n����󜟿\n";
		String daneDlaBufora2 = "Dane dla bufora 2.\n����󜟿\n";

		// getBytes() daje tablic� bajt�w reprezentuj�cych kolejne znaki napisu
		// w domy�lnym dla danej platformy kodowaniu znak�w (s� te� wersje
		// przeci��one)
		ByteArrayInputStream is1 = new ByteArrayInputStream(daneDlaBufora1.getBytes());
		ByteArrayInputStream is2 = new ByteArrayInputStream(daneDlaBufora2.getBytes());

		SequenceInputStream seq = new SequenceInputStream(is1, is2);
		Reader rd = new InputStreamReader(seq);
		int i;
		while ((i = rd.read()) != -1)
			System.out.print((char) i);
	}
}