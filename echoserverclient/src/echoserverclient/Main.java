/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package echoserverclient;
import java.io.*;
import java.net.*;

/**
 *
 * @author evansrb1
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            System.out.println("Making the Socket...");
            echoSocket = new Socket("web6.jhuep.com", 20025);
            System.out.println("Making the PrintWriter...");            
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            System.out.println("Making the BufferedReader...");                        
            in = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: web6.jhuep.com");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: web6.jhuep.com.");
            System.exit(1);
        }
        System.out.println("Reading stdIn....");
	BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
	String userInput;
 
        String echo;
	while ((userInput=stdIn.readLine()) != null) {
	    out.println(userInput);
            echo = in.readLine();
            if (echo == null) {
                System.out.println("Disconnected!");
                break;
            } else {
                System.out.println("echo: " + echo);
            }
	}

	out.close();
	in.close();
	stdIn.close();
	echoSocket.close();
    }
}