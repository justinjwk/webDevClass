package securesocket;

/**
 *
 * @author evansrb1
 */
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class SecretSocketServer {

    public static void main(String[] args) {
        new SecretSocketServer();
    }

    public SecretSocketServer() {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(4444);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true) {
            try {
               System.out.println("Waiting...");
               Socket s = ss.accept();
               SocketHandler h = new SocketHandler(s);
               Thread t = new Thread(h);
               t.start();
            }  catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
