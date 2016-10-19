package lecture.net.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Basic code example for setting up a java socket and
 * implementing the time service protocol.  Note that 
 * exceptions are not "handled" per se as they should be, 
 * they just echo output to the console.
 * 
 * Richard Spiegel - Instructor
 * Distributed Development on the World Wide Web - 605.481
 * The Johns Hopkins University
 * Engineering and Applied Science Programs for Professionals
 */
public class BasicTimeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// supply host and port for time service provider
		String host = "time-A.timefreq.bldrdoc.gov";
		int port = 13;
		Socket s = null;
		try {
			s = new Socket(host, port);
			// can use BufferedReader because time service protocol closes
			// the socket when done and causes a null to be issued to the 
			// blocking readLine method
			BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String line = null;
			while ((line = r.readLine()) != null) {
				System.out.println("From server>" + line);
			}
			System.out.println("Socket closed by server");
			s.close();
		} catch (UnknownHostException une) {
			System.out.println("Cannot find host = " + host);
		} catch (IOException ioe) {
			System.out.println("IOException caught" + ioe.getMessage());
		} finally {
			// if socket cannot be closed, just deassign it and
			// make it eligible for garbage collection
			s = null;
		}
	}

}
