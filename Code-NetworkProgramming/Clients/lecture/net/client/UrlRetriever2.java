package lecture.net.client;
import java.net.*;
import java.io.*;

/** Read a remote file using the standard URL class
 *  instead of connecting explicitly to the HTTP server.
 *
 *  Taken from Core Web Programming from 
 *  Prentice Hall and Sun Microsystems Press,
 *  http://www.corewebprogramming.com/.
 *  &copy; 2001 Marty Hall and Larry Brown;
 *  may be freely used or adapted. 
 */

public class UrlRetriever2 {
  public static void main(String[] args) {
    checkUsage(args);
    try {
      URL url = new URL(args[0]);
      BufferedReader in = new BufferedReader(
        new InputStreamReader(url.openStream()));
      String line;
      while ((line = in.readLine()) != null) {
        System.out.println("> " + line);
     }
      in.close();
    } catch(MalformedURLException mue) { // URL constructor
        System.out.println(args[0] + "is an invalid URL: " + mue);
    } catch(IOException ioe) { // Stream constructors
      System.out.println("IOException: " + ioe);
    }
  }

  private static void checkUsage(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: UrlRetriever2 <URL>");
      System.exit(-1);
    }
  }
}