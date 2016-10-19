package lecture.net.client;
/** Make simple connection to host and port specified. 
 *
 *  Taken from Core Web Programming from 
 *  Prentice Hall and Sun Microsystems Press,
 *  http://www.corewebprogramming.com/.
 *  &copy; 2001 Marty Hall and Larry Brown;
 *  may be freely used or adapted.
 */

public class NetworkClientTest {
  public static void main(String[] args) {
    String host = "localhost";
    int port = 80;    
    if (args.length > 0) {
      host = args[0];
    }
    if (args.length > 1) {
      port = Integer.parseInt(args[1]);
    }
    NetworkClient nwClient = new NetworkClient(host, port);
    nwClient.connect();
  }
}