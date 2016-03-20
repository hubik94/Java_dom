package ScreenShoter;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

/**
 * Remote desktop server class. Server works asynchronously and starts threads
 * implemented as instances of statically nested class. Screenshots in form of
 * JPG documents are served to the client.
 * 
 * @author Andrzej Marciniak
 */
public class TCPRemoteDesktopServer {

	/**
	 * Class providing service of remote desktop for a single TCP request.
	 *
	 */
	private static class ServiceThread extends Thread {
		private Socket client;

		public ServiceThread(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {
			OutputStream out;
			try {
				out = client.getOutputStream();
				ByteArrayOutputStream memBuffer = new ByteArrayOutputStream();// buffer
																				// in
																				// memory
				Robot robot = new Robot();
				BufferedImage screenShot = robot
						.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));// creating
																											// screenshot
				ImageIO.write(screenShot, "JPG", memBuffer);// writing to buffer
															// in memory
				byte buffer[] = memBuffer.toByteArray();
				out.write(buffer); // sending data to requester
				System.out.println("Screenshot of " + buffer.length + " bytes sent to: " + client.getInetAddress());
				out.close();
				client.close();
			} catch (IOException e) {
				System.err.println("Streaming problem.");
				System.exit(1);
			} catch (AWTException e) {
				System.err.println("Problem with image capturing.");
				System.exit(1);
			}
		}

	}

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		boolean listening = true; // needed for if condition (unreacheable code
									// otherwise)

		try {
			serverSocket = new ServerSocket(4444);
		} catch (IOException e) {
			System.err.println("Unavailable listening port: 4444.");
			System.exit(1);
		}
		try {
			while (listening) {
				clientSocket = serverSocket.accept();
				new ServiceThread(clientSocket).start();
			}
			serverSocket.close();
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}

	}

}