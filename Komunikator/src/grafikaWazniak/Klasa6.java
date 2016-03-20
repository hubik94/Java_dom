package grafikaWazniak;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Klasa6 extends JFrame {
  JFrame okno = this;
  JTextField wynik = new JTextField(9);
  JTextField pole1 = new JTextField(9);
  JTextField pole2 = new JTextField(9);
  
  //do obs�ugi zdarze� cz�sto u�ywane s� anonimowe klasy wewn�trzne
  //jeden egzemplarz b�dzie dzielony przez oba pola
  ActionListener sumowanie = new ActionListener() {
    public void actionPerformed(ActionEvent ev) {
      try {
        Integer w = Integer.parseInt(pole1.getText())+
                    Integer.parseInt(pole2.getText());
        wynik.setText(w.toString());
      } catch (NumberFormatException ex) {
        wynik.setText("B��d");
      }
    }
  };
  
  Klasa6() {
    super("Okno ZliczanieKlikni��");
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
    
    //puste obramowanie odsuwa komponenty od kraw�dzi
    panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
    add(panel);
    
    setSize(300,150);
    setVisible(true);
  }
  
  public static void main(String[] args) {
    //aby unikn�� zakleszcze�, tworzenie GUI zawsze zlecamy dla w�tku obs�ugi zdarze�
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Klasa6();
      }
    });
  }
}