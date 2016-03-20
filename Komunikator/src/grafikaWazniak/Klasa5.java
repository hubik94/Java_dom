package grafikaWazniak;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Klasa5 extends JFrame {
  Integer licznikKlikniêæ = 0;
  JLabel etykieta;
 
  class ZwiêkszanieLicznika implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      //obiekt klasy wewnêtrznej ma dostêp do sk³adowych obiektu klasy otaczaj¹cej
      licznikKlikniêæ++;
      etykieta.setText("Dotychczas klikn¹³eœ " +
                       licznikKlikniêæ +
                       (licznikKlikniêæ == 1 ? " raz" : " razy"));
    }
  }
 
  Klasa5() {
    super("Okno ZliczanieKlikniêæ");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 0));

    JButton przycisk = new JButton("Kliknij");
    przycisk.addActionListener(new ZwiêkszanieLicznika());
    panel.add(przycisk);
   
    etykieta = new JLabel("Jeszcze nie klikniêto ani razu");
    panel.add(new JPanel());//pusty panel zapewnia odstêp
    panel.add(etykieta);
    //puste obramowanie odsuwa komponenty od krawêdzi
    panel.setBorder(BorderFactory.createEmptyBorder(30,60,10,60));
    add(panel);
    
    setSize(300,150);
    setVisible(true);
  }
 
  public static void main(String[] args) {
    //aby unikn¹æ zakleszczeñ, tworzenie GUI zawsze zlecamy dla w¹tku obs³ugi zdarzeñ
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Klasa5();
      }
    });
  }
}