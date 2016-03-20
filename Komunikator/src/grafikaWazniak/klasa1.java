package grafikaWazniak;

import javax.swing.*;

public class klasa1 {
  private static void utwórzGUI() {
    //tworzenie nowego okna 
    JFrame frame = new JFrame("Okno WitajŒwiecie");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //dodawanie etykiety z przywitaniem
    JLabel label = new JLabel("Witaj œwiecie!");
    frame.add(label);
    
    //ustalanie wymiarów i wyœwietlanie okna
    //frame.pack();
    frame.setSize(300,150);
    frame.setVisible(true);
  }
  
  public static void main(String[] args) {
    //aby unikn¹æ zakleszczeñ tworzenie GUI zawsze zlecamy dla w¹tku obs³ugi zdarzeñ
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        utwórzGUI();
      }
    });
  }
}