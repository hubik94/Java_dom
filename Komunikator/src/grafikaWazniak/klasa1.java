package grafikaWazniak;

import javax.swing.*;

public class klasa1 {
  private static void utw�rzGUI() {
    //tworzenie nowego okna 
    JFrame frame = new JFrame("Okno Witaj�wiecie");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //dodawanie etykiety z przywitaniem
    JLabel label = new JLabel("Witaj �wiecie!");
    frame.add(label);
    
    //ustalanie wymiar�w i wy�wietlanie okna
    //frame.pack();
    frame.setSize(300,150);
    frame.setVisible(true);
  }
  
  public static void main(String[] args) {
    //aby unikn�� zakleszcze� tworzenie GUI zawsze zlecamy dla w�tku obs�ugi zdarze�
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        utw�rzGUI();
      }
    });
  }
}