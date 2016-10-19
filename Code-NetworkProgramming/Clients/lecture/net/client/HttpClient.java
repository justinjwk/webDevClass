package lecture.net.client;

import java.net.*;
import java.io.*;
import javax.swing.*;

/** The underlying network client used by WebClient. 
 *
 *  Taken from Core Web Programming from 
 *  Prentice Hall and Sun Microsystems Press,
 *  http://www.corewebprogramming.com/.
 *  &copy; 2001 Marty Hall and Larry Brown;
 *  may be freely used or adapted.
 */

public class HttpClient extends NetworkClient {
	private String requestLine;
	private String[] requestHeaders;
	private JTextArea outputArea;
	private Interruptible app;

	public HttpClient(String host, int port, String requestLine,
			String[] requestHeaders, JTextArea outputArea, Interruptible app) {
		super(host, port);
		this.requestLine = requestLine;
		this.requestHeaders = requestHeaders;
		this.outputArea = outputArea;
		this.app = app;
		if (checkHost(host)) {
			connect();
		}
	}

	protected void handleConnection(Socket uriSocket) throws IOException {
		try {
			PrintWriter out = new PrintWriter(uriSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
								new InputStreamReader(
										uriSocket.getInputStream()));
			outputArea.setText("");
			out.println(requestLine);
			for (int i = 0; i < requestHeaders.length; i++) {
				if (requestHeaders[i] == null) {
					break;
				} else {
					out.println(requestHeaders[i]);
				}
			}
			out.println();
			String line;
			while ((line = in.readLine()) != null && !app.isInterrupted()) {
				outputArea.append(line + "\n");
			}
			if (app.isInterrupted()) {
				outputArea.append("---- Download Interrupted ----");
			}
		} catch (Exception e) {
			outputArea.setText("Error: " + e);
		}
	}

	private boolean checkHost(String host) {
		try {
			InetAddress.getByName(host);
			return (true);
		} catch (UnknownHostException uhe) {
			outputArea.setText("Bogus host: " + host);
			return (false);
		}
	}
}