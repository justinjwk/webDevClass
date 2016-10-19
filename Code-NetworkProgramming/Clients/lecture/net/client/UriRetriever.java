package lecture.net.client;

import java.net.*;
import java.io.*;

/** Retrieve a URL given the host, port, and file as three 
 *  separate command-line arguments. A later class 
 *  (UrlRetriever) supports a single URL instead.
 *
 *  Taken from Core Web Programming from 
 *  Prentice Hall and Sun Microsystems Press,
 *  http://www.corewebprogramming.com/.
 *  &copy; 2001 Marty Hall and Larry Brown;
 *  may be freely used or adapted. 
 */

public class UriRetriever extends NetworkClient {
	private String uri;

	public static void main(String[] args) {
		UriRetriever uriClient = new UriRetriever(args[0], Integer
				.parseInt(args[1]), args[2]);
		uriClient.connect();
	}

	public UriRetriever(String host, int port, String uri) {
		super(host, port);
		this.uri = uri;
	}

	/** Send one GET line, then read the results one line at a
	 *  time, printing each to standard output.
	 */

	// It is safe to use blocking IO (readLine), since
	// HTTP servers close connection when done, resulting
	// in a null value for readLine.
	protected void handleConnection(Socket uriSocket) throws IOException {
		PrintWriter out = new PrintWriter(uriSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(
							new InputStreamReader(
									uriSocket.getInputStream()));
		out.println("GET " + uri + " HTTP/1.0\r\n");
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println("> " + line);
		}
	}
}