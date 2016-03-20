package drugiUDP;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.*;

public class Grafika_Krzemek extends JFrame implements ActionListener {

	// private static final LayoutManager FlowLayout = null;
	protected JTextArea pole;
	protected JTextField pisz;
	protected JButton button;
	protected JScrollPane scroll;
	protected JTextField port;
	protected JButton port1;

	JFrame okno;
	public int pport;
	static DatagramSocket sock = null;

	public Grafika_Krzemek() {
		super("Komunikator");
		okno = this;
		// setLayout(FlowLayout);

		okno.pack();
		setLayout(new java.awt.FlowLayout(10, 10, 10));
		pisz = new JTextField(15);
		pisz.setVisible(true);
		pisz.setBounds(5, 5, 100, 100);
		okno.add(pisz);
		okno.setSize(500, 500);
		button = new JButton("Wyslij");
		okno.add(button);
		button.setVisible(true);
		button.setBounds(5, 5, 100, 100);
		pole = new JTextArea(10, 30);
		pole.setVisible(true);
		try {
			sock = new DatagramSocket(7778);
		} catch (SocketException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		okno.add(pole);

		// Guzik wysy³a tekst do okna
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String buffor = pole.getText();
				pole.setText(buffor + pisz.getText() + "\n");

				String buf = pisz.getText();
				byte[] b = buf.getBytes();

				InetAddress host1 = null;
				try {
					host1 = InetAddress.getByName("localhost");
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DatagramPacket dp = new DatagramPacket(b, b.length, host1, pport);
				try {
					sock.send(dp);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		// pole podania portu
		port = new JTextField(10);
		port.setVisible(true);
		port.setBounds(50, 100, 80, 80);
		okno.add(port);

		scroll = new JScrollPane(pole);
		// pole.setText("podaj port \n");
		// port.setText("podaj port");
		port1 = new JButton("PORT");
		port1.setVisible(true);
		okno.add(port1);
		// wybieramy port
		port1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String buff = port.getText();
				pport = Integer.parseInt(buff);

			}
		});
		okno.add(scroll);
		pole.setEditable(false);

	}

	public void otrzymaj() {
		try {

			byte[] buffer = new byte[65535];
			DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
			while (true) {
				sock.receive(incoming);
				byte[] data = incoming.getData();
				String s = new String(data, 0, incoming.getLength());
				String buffor = pole.getText();
				pole.setText(buffor
						+ (incoming.getAddress().getHostAddress() + " : " + incoming.getPort() + " : " + s + "\n"));
				if (s.equals("Bye")) {
					System.out.println("Program zakoñczy³ dzia³anie!");
					break;
				}

			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Grafika_Krzemek okno = new Grafika_Krzemek();
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.setVisible(true);
		okno.otrzymaj();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}