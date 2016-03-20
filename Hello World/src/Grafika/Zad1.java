package Grafika;

import javax.swing.*;

public class Zad1 {
	private static void UtworzGUI(){
		JFrame okno = new JFrame("Tytu³");
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel etykieta = new JLabel("Œrodek okna!");
		okno.add(etykieta);
		
		okno.setSize(150, 100);
		okno.setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				UtworzGUI();
			}
		});
	}

}
