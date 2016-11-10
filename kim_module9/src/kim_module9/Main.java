/*
 * Main.java
 * 
 * Created on Oct 13, 2007, 12:59:04 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kim_module9;
import java.io.*;
import java.net.*;

/**
 *
 * @author evansrb1
 */
public class Main {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
    
        final int PORT_NUM = 20006;
        
        try {
            serverSocket = new ServerSocket(PORT_NUM);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + PORT_NUM);
            System.exit(1);
        }

        Socket clientSocket = null;
        while (true) {
            clientSocket = serverSocket.accept();
            ClientThread thread = new ClientThread(clientSocket);
            thread.start();
        }
    }
}