package lecture.net.client;
import java.util.*;

/** This parses the input to get a host, port, and file, then
 *  passes these three values to the UriRetriever class to
 *  grab the URL from the Web.
 *
 *  Taken from Core Web Programming from 
 *  Prentice Hall and Sun Microsystems Press,
 *  http://www.corewebprogramming.com/.
 *  &copy; 2001 Marty Hall and Larry Brown;
 *  may be freely used or adapted. 
 */

public class UrlRetriever {
  public static void main(String[] args) {
    checkUsage(args);
    StringTokenizer tok = new StringTokenizer(args[0]);
    String protocol = tok.nextToken(":");
    checkProtocol(protocol);
    String host = tok.nextToken(":/");
    String uri;
    int port = 80;
    try {
      uri = tok.nextToken("");
      if (uri.charAt(0) == ':') {
        tok = new StringTokenizer(uri);
        port = Integer.parseInt(tok.nextToken(":/"));
        uri = tok.nextToken("");
      }
    } catch(NoSuchElementException nsee) {
      uri = "/";
    }
    UriRetriever uriClient = new UriRetriever(host, port, uri);
    uriClient.connect();
  }

  /** Warn user if the URL was forgotten. */
  
  private static void checkUsage(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: UrlRetriever <URL>");
      System.exit(-1);
    }
  }

  /** Tell user that this can only handle HTTP. */
  
  private static void checkProtocol(String protocol) {
    if (!protocol.equals("http")) {
      System.out.println("Don't understand protocol " + protocol);
      System.exit(-1);
    }
  }
}