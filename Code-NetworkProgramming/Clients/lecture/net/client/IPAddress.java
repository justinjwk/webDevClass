package lecture.net.client;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddress {

	/**
	 * Basic code example for demonstrating use of the java
	 * InetAddress object for accessing machine information
	 * on the internet.
	 * 
	 * Richard Spiegel - Instructor
	 * Distributed Development on the World Wide Web - 605.481
	 * The Johns Hopkins University
	 * Engineering and Applied Science Programs for Professionals
	 */
	public static void main(String[] args) {
		try {
			// note static call to get InetAddress object.  
			// no constructor call used.
			InetAddress localAddr = InetAddress.getLocalHost();
			System.out.println("Local host = " + localAddr.getHostName());
			System.out.println("Local host ip = " + localAddr.getHostAddress());
			InetAddress[] extAddr = InetAddress.getAllByName("www.google.com");
			for (int i = 0; i < extAddr.length; i++)
				System.out.println("Address[" + i + "]=" + extAddr[i].getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println("Cannot find host name");
		}

	}

}
