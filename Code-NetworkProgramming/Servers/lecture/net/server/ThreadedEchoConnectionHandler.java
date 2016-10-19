package lecture.net.server;
import java.io.IOException;
import java.net.Socket;

/** A simple HTTP server that generates a Web page showing all
 *  of the data that it received from the Web client (usually
 *  a browser). To use this server, start it on the system of
 *  your choice, supplying a port number if you want something
 *  other than port 8088. Call this system server.com. Next,
 *  start a Web browser on the same or a different system, and
 *  connect to http://server.com:8088/whatever. The resultant
 *  Web page will show the data that your browser sent. For 
 *  debugging in servlet or CGI programming, specify 
 *  http://server.com:8088/whatever as the ACTION of your HTML
 *  form. You can send GET or POST data; either way, the
 *  resultant page will show what your browser sent.
 *
 *  Taken from Core Web Programming from 
 *  Prentice Hall and Sun Microsystems Press,
 *  http://www.corewebprogramming.com/.
 *  &copy; 2001 Marty Hall and Larry Brown;
 *  may be freely used or adapted. 
 */

public class ThreadedEchoConnectionHandler extends EchoConnectionHandler implements Runnable {
  protected int maxRequestLines = 50;

  public ThreadedEchoConnectionHandler() {
    super();
	this.serverName = "ThreadedEchoConnectionHandler";
  }

  /** Overrides the NetworkServer handleConnection method to 
   *  read each line of data received, save it into an array
   *  of strings, then send it back embedded inside a PRE 
   *  element in an HTML page.
   */
  public void handleConnection(Socket server)
      throws IOException{
	  System.out.println("In TEC handleConnection");
	  ConnectionThread processSocket = new ConnectionThread(this, server);
	  processSocket.start();
  }
  
  public void run() {
	  ConnectionThread currThread = (ConnectionThread)Thread.currentThread();
	  Socket server = currThread.getSocket();
	  try {
		  processRequest(server);
	  } catch(IOException ioe) {
		  //
	  }
  }
   
  private class ConnectionThread extends Thread {
	  private Socket socket;
	  
	  public ConnectionThread(Runnable r, Socket s) {
		  super(r);
		  socket = s;
	  }
	  
	  public Socket getSocket() {
		  return socket;
	  }
  }
	  
  public static void main(String[] args) {
		int port = 8088;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		}
		ThreadedEchoConnectionHandler handler = new ThreadedEchoConnectionHandler();
		RFSNetworkServer nwServer = new RFSNetworkServer(port, 0, handler);
		nwServer.listen();
  }
}