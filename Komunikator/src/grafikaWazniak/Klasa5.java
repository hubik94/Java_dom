package grafikaWazniak;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Klasa5 extends JFrame {
  Integer licznikKlikni�� = 0;
  JLabel etykieta;
 
  class Zwi�kszanieLicznika implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      //obiekt klasy wewn�trznej ma dost�p do sk�adowych obiektu klasy otaczaj�cej
      licznikKlikni��++;
      etykieta.setText("Dotychczas klikn��e� " +
                       licznikKlikni�� +
                       (licznikKlikni�� == 1 ? " raz" : " razy"));
    }
  }
 
  Klasa5() {
    super("Okno ZliczanieKlikni��");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 0));

    JButton przycisk = new JButton("Kliknij");
    przycisk.addActionListener(new Zwi�kszanieLicznika());
    panel.add(przycisk);
   
    etykieta = new JLabel("Jeszcze nie klikni�to ani razu");
    panel.add(new JPanel());//pusty panel zapewnia odst�p
    panel.add(etykieta);
    //puste obramowanie odsuwa komponenty od kraw�dzi
    panel.setBorder(BorderFactory.createEmptyBorder(30,60,10,60));
    add(panel);
    
    setSize(300,150);
    setVisible(true);
  }
 
  public static void main(String[] args) {
    //aby unikn�� zakleszcze�, tworzenie GUI zawsze zlecamy dla w�tku obs�ugi zdarze�
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Klasa5();
      }
    });
  }
}