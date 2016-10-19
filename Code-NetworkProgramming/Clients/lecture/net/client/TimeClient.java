package lecture.net.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TimeClient extends NetworkClient {
	
	public TimeClient(String host, int port) {
		super(host, port);
	}

	/** This version reads and echos the response from the 
	 *  server one line at a time until there is no more input 
	 *  (line is null).  Then it closes the stream.  
	 */
	protected void handleConnection(Socket client) 
										throws IOException {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String line = null;
			while ((line = in.readLine()) != null) {
				System.out.println("From Server>" + line);
			} 
			System.out.println("Server closed socket");
		} catch (IOException e) {
			System.out.println("MORE TO BE DONE");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String host = "time-A.timefreq.bldrdoc.gov";
		if (args.length > 0)
			host = args[0];
		int port = 13;
		if (args.length > 1)
			port = Integer.parseInt(args[1]);
		TimeClient timeClient = new TimeClient(host, port);
		timeClient.connect();
	}
}
