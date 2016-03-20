package fileReader.bufferedReaderJava7;

import java.io.File;

class Temp implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("Closing");
		
	}
	
}

public class Glowna {
	public static void main(String[] args) {
		File file = new File("text");
		try(Temp tmp = new Temp()){
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
