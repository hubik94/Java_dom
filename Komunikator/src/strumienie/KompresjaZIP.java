package strumienie;

import java.io.*;
import java.util.zip.*;

public class KompresjaZIP {
  public static void main(String[] args) throws IOException {
    // wersja dla Linuxa
    String nazwaPliku = "/tmp/io_test.zip";
    // wersja dla Windows
    //String nazwaPliku = "c:\\io_test.zip";
    int x;

    ZipOutputStream zos = new ZipOutputStream(
                            new BufferedOutputStream(
                              new FileOutputStream(nazwaPliku)));
    for (int i = 1; i < args.length; i++) {
      System.out.println("Zapisywanie " + args[i]);
      BufferedInputStream in = new BufferedInputStream(new FileInputStream(args[0]+args[i]));
      zos.putNextEntry(new ZipEntry(args[i]));
      while ( (x = in.read()) != -1 )
        zos.write(x);
      in.close();
    }
    zos.close();
    
    ZipInputStream zis = new ZipInputStream(
                           new BufferedInputStream(
                             new FileInputStream(nazwaPliku)));
    ZipEntry ze;
    while ( (ze = zis.getNextEntry()) != null ) {
      System.out.println();
      System.out.println("Odczytywanie: " + ze);
      while ( (x = zis.read()) != -1 )
        System.out.write(x);
    }
    System.out.flush();
    zis.close();
  }
}