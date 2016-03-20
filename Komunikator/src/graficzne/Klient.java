package graficzne;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Klient extends JFrame implements ActionListener {
	public JFrame okno;
	public JTextField pole;
	public JButton button;
	public JTextArea textArea;
	public JScrollPane scroll = new JScrollPane();
	byte[] serwer, klient;
	DatagramSocket dsSerwer, dsKlient;

	public static void main(String[] args) {
		Klient klient = new Klient();
	}

	public Klient() {
		this.setTitle("Klient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		okno = this;
		pole = new JTextField(20);

		button = new JButton("Wyœlij!");
		button.addActionListener(this);

		textArea = new JTextArea(5, 20);
		scroll = new JScrollPane(textArea);

		setLayout(new FlowLayout());
		add(pole);
		add(button);
		add(scroll);
		okno.pack();
		setVisible(true);

		klient = new byte[1024];
		serwer = new byte[1024];

		try {
			dsKlient = new DatagramSocket();
			dsSerwer = new DatagramSocket(8888);
			while (true) {
				DatagramPacket dp = new DatagramPacket(serwer, serwer.length);
				dsSerwer.receive(dp);
				String msg = new String(dp.getData(), 0, dp.getLength());
				textArea.append("\nSerwer: " + msg);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String bufor = pole.getText();
		klient = bufor.getBytes();
		try {
			DatagramPacket send = new DatagramPacket(klient, klient.length, InetAddress.getLocalHost(), 7777);
			dsKlient.send(send);
			textArea.append("\nJa: " + bufor);

		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
