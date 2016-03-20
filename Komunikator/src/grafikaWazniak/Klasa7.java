package grafikaWazniak;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ZmianaWygl�duIZachowania implements ActionListener {
  JFrame ramka;
  String nazwa;
  ZmianaWygl�duIZachowania(JFrame ramka, String nazwa) {
    this.ramka = ramka;
    this.nazwa = nazwa;
  }
  
  public void actionPerformed(ActionEvent e) {
    try {
      UIManager.setLookAndFeel(nazwa);
      SwingUtilities.updateComponentTreeUI(ramka);
    } catch (Exception ex) {
      System.err.println("Nie uda�a si� zmiana na wygl�d: "+nazwa);
    }
  } 
}

public class Klasa7 extends JFrame {
  JButton mi�dzyplatformowy, systemu, gtk, windows, motif, metal; 
  
  Klasa7() {
    super("Okno Wygl�dIZachowanie");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(new JLabel("Wybierz wygl�d i zachowanie:"));
   
    mi�dzyplatformowy = new JButton("Mi�dzyplatformowy");
    mi�dzyplatformowy.addActionListener(
      new ZmianaWygl�duIZachowania(this, UIManager.getCrossPlatformLookAndFeelClassName()));
    panel.add(mi�dzyplatformowy);
    
    systemu = new JButton("Systemu operacyjnego");
    systemu.addActionListener(
      new ZmianaWygl�duIZachowania(this, UIManager.getSystemLookAndFeelClassName()));
    panel.add(systemu);
    
    metal = new JButton("Metal");
    metal.addActionListener(
      new ZmianaWygl�duIZachowania(this, "javax.swing.plaf.metal.MetalLookAndFeel"));
    panel.add(metal);

    windows = new JButton("Windows");
    windows.setToolTipText("Obecnie dost�pny jedynie w systemie Windows!");
    windows.addActionListener(
      new ZmianaWygl�duIZachowania(this, "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"));
    panel.add(windows);

    motif = new JButton("Motif");
    motif.addActionListener(
      new ZmianaWygl�duIZachowania(this, "com.sun.java.swing.plaf.motif.MotifLookAndFeel"));
    panel.add(motif);

    //nie ma go we wszystkich jre
    gtk = new JButton("GTK");
    gtk.setToolTipText("Niedost�pny w niekt�rych JRE!");
    gtk.addActionListener(
      new ZmianaWygl�duIZachowania(this,"com.sun.java.swing.plaf.gtk.GTKLookAndFeel"));
    panel.add(gtk);

    panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
    add(panel);
    setSize(260,250);
    setVisible(true);
  }
 
  public static void main(String[] args) {
    //aby unikn�� zakleszcze�, tworzenie GUI zawsze zlecamy dla w�tku obs�ugi zdarze�
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Klasa7();
      }
    });
  }
}