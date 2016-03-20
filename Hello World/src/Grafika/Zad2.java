package Grafika;

import javax.swing.*;
import java.awt.*;

public class Zad2 extends JFrame{
	Zad2(){
		super("Okno BorderLayoutTest");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new JButton("CENTER"));
		add(BorderLayout.NORTH, new JButton("North"));
		add(BorderLayout.SOUTH, new JButton("South"));
		add(BorderLayout.WEST, new JButton("West"));
		add(BorderLayout.EAST, new JButton("East"));
		
		setSize(300, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Zad2();				
			}
		});
	}

}
