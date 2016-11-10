/*
 * ClientThread.java
 * 
 * Created on Nov 4, 2007, 2:11:49 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author evansrb1
 */
public class ClientThread extends Thread {

    private final Socket socket;
    public ClientThread(Socket clientSocket) {
        this.socket = clientSocket;
    }
    public void run () {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("Welcome to Beartooth Hiking Company Server\n\rType \"bye\" to disconnect\n\r");
            String outputLine = null;
            while (!socket.isClosed()) {
                outputLine = in.readLine();
                if (outputLine == null) {
                    break;
                }
                if (outputLine.equalsIgnoreCase("bye")) {
                    break;
                } else {
                    String inputs[] = outputLine.split(":");
                    if(inputs.length != 5) {
                        System.out.println("Input should have 5 values like begin_year:begin_month:begin_day:hike:duration");
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
