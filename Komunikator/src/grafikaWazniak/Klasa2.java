package grafikaWazniak;

import java.awt.*;
import javax.swing.*;

public class Klasa2 extends JFrame {
  Klasa2() {
    super("Okno BorderLayoutTest");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //G³ówne kontenery (JApplet, JDialog i JFrame) domyœlnie u¿ywaj¹ BorderLayout.
    //Natomiast obiekty JPanel domyœlnie u¿ywaj¹ FlowLayout.
    add(new JButton("CENTER")); //domyœlna pozycja to BorderLayout.CENTER
    add(BorderLayout.NORTH, new JButton("NORTH"));
    add(BorderLayout.SOUTH, new JButton("SOUTH"));
    add(BorderLayout.EAST, new JButton("EAST"));
    add(BorderLayout.WEST, new JButton("WEST"));

    setSize(300,150);
    setVisible(true);
  }
 
  public static void main(String[] args) {
    //aby unikn¹æ zakleszczeñ, tworzenie GUI zawsze zlecamy dla w¹tku obs³ugi zdarzeñ
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Klasa2();
      }
    });
  }
}