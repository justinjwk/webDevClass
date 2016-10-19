package securesocket;

/**
 *
 * @author evansrb1
 */
import java.io.*;
import java.net.Socket;
import java.security.Key;

public class SocketHandler implements Runnable {
    private Socket s = null;
    private SecretSocket ss = null;
    private InputStream in = null;

    public SocketHandler(Socket s) {
        this.s = s;
        Key key = KeyGen.getSecretKey();
        this.ss = new SecretSocket(s, key);
        try {
            in = ss.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void run() {
        boolean bool = true;
        while (bool) {
            bool = listen();
        }
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean listen() {
       int aByte;
       try {
            while ((aByte = in.read()) >= 0) {
                System.out.println((char)aByte);
            }
        } catch (IOException e) {
            System.out.println("returning false...");
        }
        return false;
    }
}
