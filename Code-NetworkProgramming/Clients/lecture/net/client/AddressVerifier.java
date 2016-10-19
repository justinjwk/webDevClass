package lecture.net.client;
import java.net.*;  
import java.io.*;

/** Given an e-mail address of the form user@host,
 *  connect to port 25 of the host and issue an
 *  'expn' request for the user. Print the results.
 *
 *  Taken from Core Web Programming from 
 *  Prentice Hall and Sun Microsystems Press,
 *  http://www.corewebprogramming.com/.
 *  &copy; 2001 Marty Hall and Larry Brown;
 *  may be freely used or adapted. 
 */

public class AddressVerifier extends NetworkClient {
  private String username;

  public static void main(String[] args) {

    MailAddress address = new MailAddress("rfs@apl.jhu.edu");
    AddressVerifier verifier
      = new AddressVerifier(address.getUsername(),
                            address.getHostname(), 25);
    verifier.connect();
  }

  public AddressVerifier(String username, String hostname,
                         int port) {
    super(hostname, port);
    this.username = username;
  }

  /** NetworkClient, the parent class, automatically establishes
   *  the connection and then passes the Socket to
   *  handleConnection. This method does all the real work
   *  of talking to the mail server.
   */
  
  // You can't use readLine, because it blocks. Blocking I/O 
  // by readLine is only appropriate when you know how many 
  // lines to read. Note that mail servers send a varying 
  // number of lines when you first connect or send no line 
  // closing the connection (as HTTP servers do), yielding 
  // null for readLine. Also, we'll assume that 1000 bytes 
  // is more than enough to handle any server welcome 
  // message and the actual EXPN response.
  
  protected void handleConnection(Socket client) {
    try {
      PrintWriter out = new PrintWriter(client.getOutputStream(), true);
      InputStream in = client.getInputStream();
      byte[] response = new byte[1000];
      // Clear out mail server's welcome message.
      in.read(response);
      out.println("EXPN " + username);
      // Read the response to the EXPN command.
      int numBytes = in.read(response);
      // The 0 means to use normal ASCII encoding.
      System.out.write(response, 0, numBytes);
      out.println("QUIT");
      client.close();
    } catch(IOException ioe) {
      System.out.println("Couldn't make connection: " + ioe);
    }
  }
  
  /** If the wrong arguments, thn warn user. */
  
  public static void usage() {
    System.out.println ("You must supply an email address " +
       "of the form 'username@hostname'.");
    System.exit(-1);
  }
}