package strumienie;

import java.io.*;

public class KonwersjaStrumieni {
	public static void main(String[] args) throws IOException {
		String napis = "Test strumieni.\n����󜟿\n";

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		// OutputStream jest przekszta�cany na Writer
		Writer wr = new OutputStreamWriter(os);
		wr.write(napis);
		wr.close();

		ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
		// InputStream jest przekszta�cany na Reader
		Reader rd = new InputStreamReader(is);
		int i;
		while ((i = rd.read()) != -1)
			System.out.print((char) i);
		rd.close();
	}
}
