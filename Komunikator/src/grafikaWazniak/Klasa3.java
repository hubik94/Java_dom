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
    add(new JButton("D�ugi przycisk"));
    add(new JButton("B. d�ugi przycisk"));
    add(new JButton("Bardzo d�ugi przycisk"));
    add(new JButton("Bardzo bardzo d�ugi przycisk"));
    setSize(300,150);
    setVisible(true);
  }
 
  public static void main(String[] args) {
    //aby unikn�� zakleszcze�, tworzenie GUI zawsze zlecamy dla w�tku obs�ugi zdarze�
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Klasa3();
      }
    });
  }
}