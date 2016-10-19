package lecture.net.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static int port = 8080;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			Socket sock = server.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(sock
					.getInputStream()));
			PrintWriter pr = new PrintWriter(sock.getOutputStream(), true);
			System.out.println("Server up and got following message from client...\n"
							+ br.readLine());
			pr.println("Connection to simple server a success\n");
			server.close();
		} catch (Exception e) {
			System.out.println("Exception caught = " + e);
		} finally {
			server = null;
		}
	}

}
