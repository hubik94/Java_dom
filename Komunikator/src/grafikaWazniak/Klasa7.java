package grafikaWazniak;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ZmianaWygl¹duIZachowania implements ActionListener {
  JFrame ramka;
  String nazwa;
  ZmianaWygl¹duIZachowania(JFrame ramka, String nazwa) {
    this.ramka = ramka;
    this.nazwa = nazwa;
  }
  
  public void actionPerformed(ActionEvent e) {
    try {
      UIManager.setLookAndFeel(nazwa);
      SwingUtilities.updateComponentTreeUI(ramka);
    } catch (Exception ex) {
      System.err.println("Nie uda³a siê zmiana na wygl¹d: "+nazwa);
    }
  } 
}

public class Klasa7 extends JFrame {
  JButton miêdzyplatformowy, systemu, gtk, windows, motif, metal; 
  
  Klasa7() {
    super("Okno Wygl¹dIZachowanie");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(new JLabel("Wybierz wygl¹d i zachowanie:"));
   
    miêdzyplatformowy = new JButton("Miêdzyplatformowy");
    miêdzyplatformowy.addActionListener(
      new ZmianaWygl¹duIZachowania(this, UIManager.getCrossPlatformLookAndFeelClassName()));
    panel.add(miêdzyplatformowy);
    
    systemu = new JButton("Systemu operacyjnego");
    systemu.addActionListener(
      new ZmianaWygl¹duIZachowania(this, UIManager.getSystemLookAndFeelClassName()));
    panel.add(systemu);
    
    metal = new JButton("Metal");
    metal.addActionListener(
      new ZmianaWygl¹duIZachowania(this, "javax.swing.plaf.metal.MetalLookAndFeel"));
    panel.add(metal);

    windows = new JButton("Windows");
    windows.setToolTipText("Obecnie dostêpny jedynie w systemie Windows!");
    windows.addActionListener(
      new ZmianaWygl¹duIZachowania(this, "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"));
    panel.add(windows);

    motif = new JButton("Motif");
    motif.addActionListener(
      new ZmianaWygl¹duIZachowania(this, "com.sun.java.swing.plaf.motif.MotifLookAndFeel"));
    panel.add(motif);

    //nie ma go we wszystkich jre
    gtk = new JButton("GTK");
    gtk.setToolTipText("Niedostêpny w niektórych JRE!");
    gtk.addActionListener(
      new ZmianaWygl¹duIZachowania(this,"com.sun.java.swing.plaf.gtk.GTKLookAndFeel"));
    panel.add(gtk);

    panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
    add(panel);
    setSize(260,250);
    setVisible(true);
  }
 
  public static void main(String[] args) {
    //aby unikn¹æ zakleszczeñ, tworzenie GUI zawsze zlecamy dla w¹tku obs³ugi zdarzeñ
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Klasa7();
      }
    });
  }
}