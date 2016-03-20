package grafikaWazniak;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Klasa6 extends JFrame {
  JFrame okno = this;
  JTextField wynik = new JTextField(9);
  JTextField pole1 = new JTextField(9);
  JTextField pole2 = new JTextField(9);
  
  //do obs³ugi zdarzeñ czêsto u¿ywane s¹ anonimowe klasy wewnêtrzne
  //jeden egzemplarz bêdzie dzielony przez oba pola
  ActionListener sumowanie = new ActionListener() {
    public void actionPerformed(ActionEvent ev) {
      try {
        Integer w = Integer.parseInt(pole1.getText())+
                    Integer.parseInt(pole2.getText());
        wynik.setText(w.toString());
      } catch (NumberFormatException ex) {
        wynik.setText("B³¹d");
      }
    }
  };
  
  Klasa6() {
    super("Okno ZliczanieKlikniêæ");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());

    pole1.addActionListener(sumowanie);
    panel.add(pole1);
    panel.add(new JLabel("+"));
    panel.add(pole2);
    pole2.addActionListener(sumowanie);
    panel.add(new JLabel("="));
    wynik.setEditable(false);
    panel.add(wynik);
    
    //puste obramowanie odsuwa komponenty od krawêdzi
    panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
    add(panel);
    
    setSize(300,150);
    setVisible(true);
  }
  
  public static void main(String[] args) {
    //aby unikn¹æ zakleszczeñ, tworzenie GUI zawsze zlecamy dla w¹tku obs³ugi zdarzeñ
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Klasa6();
      }
    });
  }
}