package grafikaWazniak;

import java.awt.*;
import javax.swing.*;

public class Klasa4 extends JFrame {
  Klasa4() {
    super("Okno GridLayoutTest");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    setLayout(new GridLayout(3,2));
    add(new JButton("P1"));
    add(new JButton("P2"));
    add(new JButton("P3"));
    add(new JButton("P4"));
    add(new JButton("Bardzo d�ugi przycisk"));
    setSize(300,150);
    setVisible(true);
  }
 
  public static void main(String[] args) {
    //aby unikn�� zakleszcze�, tworzenie GUI zawsze zlecamy dla w�tku obs�ugi zdarze�
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Klasa4();
      }
    });
  }
}