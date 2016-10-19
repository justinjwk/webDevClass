package lecture.net.client;
import java.net.*;
import java.io.*;

/** A starting point for network clients. You'll need to
 *  override handleConnection, but in many cases connect can 
 *  remain unchanged.
 *
 *  Taken from Core Web Programming from 
 *  Prentice Hall and Sun Microsystems Press,
 *  http://www.corewebprogramming.com/.
 *  &copy; 2001 Marty Hall and Larry Brown;
 *  may be freely used or adapted. 
 */

public class NetworkClient {
  protected String host;
  protected int port;

  /** Register host and port. The connection won't
   *  actually be established until you call
   *  connect.
   */
  
  public NetworkClient(String host, int port) {
    this.host = host;
    this.port = port;
  }

  /** Establishes the connection, then passes the socket
   *  to handleConnection.
   */
  
  public void connect() {
    try {
      Socket client = new Socket(host, port);
      handleConnection(client);
    } catch(UnknownHostException uhe) {
      System.out.println("Unknown host: " + host);
      uhe.printStackTrace();
    } catch(IOException ioe) {
      System.out.println("IOException: " + ioe);
      ioe.printStackTrace();
    } 
  }

  /** This is the method you will override when
   *  making a network client for your task.
   *  The default version sends a single line
   *  ("Generic Network Client") to the server,
   *  reads one line of response, prints it, then exits.
   */
  
  protected void handleConnection(Socket client)
    throws IOException {
	  InputStream sockIn = client.getInputStream();
	  PrintWriter out = new PrintWriter(client.getOutputStream(), true);
	  BufferedReader in = new BufferedReader(new InputStreamReader(sockIn));
      out.println("Generic Network Client");
	  System.out.println("Generic Network Client:\n" +
			  				"Made connection to " + host +
			  				" and got '" + in.readLine() + 
			  				"' in response");
	  client.close();
  }

  /** The hostname of the server we're contacting. */
  
  public String getHost() {
    return(host);
  }

  /** The port connection will be made on. */
  
  public int getPort() {
    return(port);
  }
}