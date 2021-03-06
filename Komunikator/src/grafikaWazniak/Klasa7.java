package grafikaWazniak;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ZmianaWygląduIZachowania implements ActionListener {
  JFrame ramka;
  String nazwa;
  ZmianaWygląduIZachowania(JFrame ramka, String nazwa) {
    this.ramka = ramka;
    this.nazwa = nazwa;
  }
  
  public void actionPerformed(ActionEvent e) {
    try {
      UIManager.setLookAndFeel(nazwa);
      SwingUtilities.updateComponentTreeUI(ramka);
    } catch (Exception ex) {
      System.err.println("Nie udała się zmiana na wygląd: "+nazwa);
    }
  } 
}

public class Klasa7 extends JFrame {
  JButton międzyplatformowy, systemu, gtk, windows, motif, metal; 
  
  Klasa7() {
    super("Okno WyglądIZachowanie");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(new JLabel("Wybierz wygląd i zachowanie:"));
   
    międzyplatformowy = new JButton("Międzyplatformowy");
    międzyplatformowy.addActionListener(
      new ZmianaWygląduIZachowania(this, UIManager.getCrossPlatformLookAndFeelClassName()));
    panel.add(międzyplatformowy);
    
    systemu = new JButton("Systemu operacyjnego");
    systemu.addActionListener(
      new ZmianaWygląduIZachowania(this, UIManager.getSystemLookAndFeelClassName()));
    panel.add(systemu);
    
    metal = new JButton("Metal");
    metal.addActionListener(
      new ZmianaWygląduIZachowania(this, "javax.swing.plaf.metal.MetalLookAndFeel"));
    panel.add(metal);

    windows = new JButton("Windows");
    windows.setToolTipText("Obecnie dostępny jedynie w systemie Windows!");
    windows.addActionListener(
      new ZmianaWygląduIZachowania(this, "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"));
    panel.add(windows);

    motif = new JButton("Motif");
    motif.addActionListener(
      new ZmianaWygląduIZachowania(this, "com.sun.java.swing.plaf.motif.MotifLookAndFeel"));
    panel.add(motif);

    //nie ma go we wszystkich jre
    gtk = new JButton("GTK");
    gtk.setToolTipText("Niedostępny w niektórych JRE!");
    gtk.addActionListener(
      new ZmianaWygląduIZachowania(this,"com.sun.java.swing.plaf.gtk.GTKLookAndFeel"));
    panel.add(gtk);

    panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
    add(panel);
    setSize(260,250);
    setVisible(true);
  }
 
  public static void main(String[] args) {
    //aby uniknąć zakleszczeń, tworzenie GUI zawsze zlecamy dla wątku obsługi zdarzeń
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Klasa7();
      }
    });
  }
}