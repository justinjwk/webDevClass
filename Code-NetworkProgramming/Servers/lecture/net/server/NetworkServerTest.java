package lecture.net.server;
/** Taken from Core Web Programming from 
 *  Prentice Hall and Sun Microsystems Press,
 *  http://www.corewebprogramming.com/.
 *  &copy; 2001 Marty Hall and Larry Brown;
 *  may be freely used or adapted.
 */


public class NetworkServerTest {
  public static void main(String[] args) {
    int port = 8080;
    if (args.length > 0) {
      port = Integer.parseInt(args[0]);
    }
    NetworkServer nwServer = new NetworkServer(port, 3);
    nwServer.listen();
  }
}