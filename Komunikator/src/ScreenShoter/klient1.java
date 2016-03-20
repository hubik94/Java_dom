package ScreenShoter;
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
 
import javax.imageio.ImageIO;
 
public class klient1 {
   
    public static void main(String[] args) throws IOException {
        Socket ksocket = null; 
        Scanner read = new Scanner(System.in);
        try {
            int i=0;
            while(true){
            String t = read.nextLine();
                if(t.equals("shoot jpg"))
                {
            ksocket = new Socket("127.0.0.1", 4444);                                           
            BufferedImage imBuff = ImageIO.read(ksocket.getInputStream());         
            ImageIO.write(imBuff, "jpg", new File(i +".jpg"));                     
            System.out.println("otrzymano skrina \n"+ i);
           
            i++;
                }
                else if(t.equals("shoot png"))
            {
        ksocket = new Socket("127.0.0.1", 4444);                                           
        BufferedImage imBuff1 = ImageIO.read(ksocket.getInputStream());        
        ImageIO.write(imBuff1, "png", new File(i +".png"));                    
        System.out.println("otrzymano skrina \n "+ i);
       
        i++;
                }else if(t.equals("bye")) {System.exit(1);}
            }
           
        } catch (UnknownHostException e) {
            System.err.println("Nie znalaz³em hosta");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Nie mogê znaleŸæ po³¹czenia z hostem");
            System.exit(1);
        }
 
    }
 
}