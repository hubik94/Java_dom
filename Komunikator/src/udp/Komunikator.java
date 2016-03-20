package udp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.text.Caret;


public class Komunikator extends JFrame implements ActionListener{

	JButton bWyslij;
	JLabel lWyswietlWyslanie;
	JTextField tWprowadzanie;
	JTextArea OknoDialogowe;
	
	JMenuBar menuBar;
	JMenu menuPlik, menuNarzedzia, menuPomoc;
	JMenuItem mZapisz, mWyjscie, mCzcionka, mWielkosc, mKolor, mOProgramie;
	
	
	public Komunikator() {
		setSize(800, 540);
		setTitle("Komunikator");
		setLayout(null);
		bWyslij = new JButton("Wyœlij");
		bWyslij.setBounds(620, 400, 150, 25);
		add(bWyslij);
		bWyslij.addActionListener(this);
		
		lWyswietlWyslanie = new JLabel("Status");
		lWyswietlWyslanie.setBounds(620, 430, 150, 25);
		lWyswietlWyslanie.setForeground(Color.BLACK);
		lWyswietlWyslanie.setFont(new Font("SansSerif", 16, 16));
		add(lWyswietlWyslanie);
		
		tWprowadzanie = new JTextField ("");
		tWprowadzanie.setBounds(20, 400, 580, 26);
		add(tWprowadzanie);
		tWprowadzanie.addActionListener(this);
		
		OknoDialogowe = new JTextArea();
		JScrollPane ScrollPane = new JScrollPane(OknoDialogowe);
		ScrollPane.setBounds(20,20,580,360);
		ScrollPane.setBorder(BorderFactory.createLineBorder(Color.black));
		OknoDialogowe.setEditable(false);
		add(ScrollPane);
		
		menuBar = new JMenuBar();
		menuPlik = new JMenu("Plik");
			
		menuNarzedzia = new JMenu("Narzêdzia");
		menuPomoc = new JMenu("Pomoc");
		setJMenuBar(menuBar);
		
		menuBar.add(menuPlik);
			mZapisz = new JMenuItem("Zapisz");
			menuPlik.add(mZapisz);
			mZapisz.addActionListener(this);
			mWyjscie = new JMenuItem("Wyjœcie");
			menuPlik.addSeparator();
			menuPlik.add(mWyjscie);
			mWyjscie.addActionListener(this);
			mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
			
		menuBar.add(menuNarzedzia);
			mCzcionka = new JMenu("Czcionka");
				mWielkosc = new JMenuItem("Wielkoœæ");
				mWielkosc.addActionListener(this);
				mKolor = new JMenuItem("Kolor");
				mKolor.addActionListener(this);
				mCzcionka.add(mWielkosc);
				mCzcionka.add(mKolor);
			menuNarzedzia.add(mCzcionka);
		
		menuBar.add(menuPomoc);
			mOProgramie = new JMenuItem("O Programie");
			menuPomoc.add(mOProgramie);
			mOProgramie.addActionListener(this);
			
		
		
		
	}
public static void main (String[] args) {
	Komunikator okno = new Komunikator();
	okno.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
	okno.setVisible(true);
	
}
final Timer status = new Timer(3000, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    	lWyswietlWyslanie.setForeground(Color.BLACK);
		lWyswietlWyslanie.setText("Status");
    }
});

@Override

public void actionPerformed(ActionEvent e) 
{	
	
	Object zrodlo = e.getSource();
	if (zrodlo == bWyslij || zrodlo==tWprowadzanie)	
	{	
		lWyswietlWyslanie.setForeground(Color.GREEN);
		lWyswietlWyslanie.setText("Wys³ano...");
		String tekst = tWprowadzanie.getText();
		
		OknoDialogowe.append(tekst + "\n");
		tWprowadzanie.setText("");
		status.start();
	}else if(zrodlo == mWyjscie)
	{
		int odp = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz zamkn¹æ program?", "Pytanie", JOptionPane.YES_NO_OPTION);
		if (odp == JOptionPane.YES_OPTION)
			dispose();
	}else if(zrodlo == mWielkosc)
	{
		tWprowadzanie.setFont(new Font("SansSerif", 16, 30));
	}else if(zrodlo == mKolor)
	{
		dispose();
	}else if(zrodlo == mOProgramie)
	{
		JOptionPane.showMessageDialog(this, "Komunikator\n version: 1.2\n Twórca: Bambus");
	}else if(zrodlo == mZapisz)
	{
		JFileChooser fc = new JFileChooser();
		if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File plik = fc.getSelectedFile();
			JOptionPane.showMessageDialog(null, "Wybrany plik to " + plik);
		}
	}
	
}
}
