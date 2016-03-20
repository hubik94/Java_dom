package grafikaWazniak;

import java.awt.*;
import javax.swing.*;

public class Klasa2 extends JFrame {
  Klasa2() {
    super("Okno BorderLayoutTest");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //G��wne kontenery (JApplet, JDialog i JFrame) domy�lnie u�ywaj� BorderLayout.
    //Natomiast obiekty JPanel domy�lnie u�ywaj� FlowLayout.
    add(new JButton("CENTER")); //domy�lna pozycja to BorderLayout.CENTER
    add(BorderLayout.NORTH, new JButton("NORTH"));
    add(BorderLayout.SOUTH, new JButton("SOUTH"));
    add(BorderLayout.EAST, new JButton("EAST"));
    add(BorderLayout.WEST, new JButton("WEST"));

    setSize(300,150);
    setVisible(true);
  }
 
  public static void main(String[] args) {
    //aby unikn�� zakleszcze�, tworzenie GUI zawsze zlecamy dla w�tku obs�ugi zdarze�
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Klasa2();
      }
    });
  }
}