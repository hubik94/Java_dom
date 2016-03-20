package grafikaWazniak;

import java.awt.*;
import javax.swing.*;

public class Klasa3 extends JFrame {
  Klasa3() {
    super("Okno FlowLayoutTest");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    setLayout(new FlowLayout());
    add(new JButton("Psk."));
    add(new JButton("Przycisk"));
    add(new JButton("D³ugi przycisk"));
    add(new JButton("B. d³ugi przycisk"));
    add(new JButton("Bardzo d³ugi przycisk"));
    add(new JButton("Bardzo bardzo d³ugi przycisk"));
    setSize(300,150);
    setVisible(true);
  }
 
  public static void main(String[] args) {
    //aby unikn¹æ zakleszczeñ, tworzenie GUI zawsze zlecamy dla w¹tku obs³ugi zdarzeñ
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Klasa3();
      }
    });
  }
}