package lecture.net.client;
/** An interface for classes that can be polled to see
 *  if they've been interrupted. Used by HttpClient
 *  and WebClient to allow the user to interrupt a network
 *  download.
 *
 *  Taken from Core Web Programming from 
 *  Prentice Hall and Sun Microsystems Press,
 *  http://www.corewebprogramming.com/.
 *  &copy; 2001 Marty Hall and Larry Brown;
 *  may be freely used or adapted. 
 */

public interface Interruptible {
  public boolean isInterrupted();
}