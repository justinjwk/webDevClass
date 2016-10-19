package lecture.net.client;

/** Takes a string of the form "user@host" and
 *  separates it into the "user" and "host" parts.
 *
 *  Taken from Core Web Programming from 
 *  Prentice Hall and Sun Microsystems Press,
 *  http://www.corewebprogramming.com/.
 *  &copy; 2001 Marty Hall and Larry Brown;
 *  may be freely used or adapted. 
 *  
 *  Updated in 2007, replacing StringTokenizer which
 *  has been deprecated with the String.split() method.
 *  Richard Spiegel
 */

public class MailAddress {
	private String username, hostname;

	public MailAddress(String emailAddress) {
		String[] temp = emailAddress.split("@");
		if (temp.length == 2) {
			this.username = temp[0];
			this.hostname = temp[1];
		} else {
			System.out.println("Illegal email address");
			System.exit(-1);
		}
	}

	public String getUsername() {
		return (username);
	}

	public String getHostname() {
		return (hostname);
	}
}