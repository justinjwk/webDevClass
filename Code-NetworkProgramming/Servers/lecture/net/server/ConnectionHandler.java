package lecture.net.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionHandler {

	/** This is the method that provides the behavior to the
	 *  server, since it determines what is done with the
	 *  resulting socket. <B>Override this method in servers 
	 *  you write.</B>
	 *  <P>
	 *  This generic version simply reports the host that made
	 *  the connection, shows the first line the client sent,
	 *  and sends a single line in response.
	 */
	public void handleConnection(Socket server) throws IOException {
		processRequest(server);
	}
	
	public void processRequest(Socket server) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
		PrintWriter out = new PrintWriter(server.getOutputStream(), true);
		System.out.println("Generic Network Server: got connection from "
				+ server.getInetAddress().getHostName() + "\n"
				+ "with first line '" + in.readLine() + "'");
		out.println("Generic Network Server");
		server.close();	
	}
	
	public static void main(String[] args) {
		int port = 8088;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		}
		ConnectionHandler handler = new ConnectionHandler();
		RFSNetworkServer nwServer = new RFSNetworkServer(port, 0, handler);
		nwServer.listen();
	}
}
