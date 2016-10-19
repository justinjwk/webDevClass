package securesocket;

/**
 *
 * @author evansrb1
 */
import java.io.*;
import java.net.Socket;
import java.security.Key;

public class SecretSocketClient {

    public SecretSocketClient() {
        try {
            Key key = KeyGen.getSecretKey();
            Socket s = new Socket("localhost", 4444);
            SecretSocket ss = new SecretSocket(s, key);
            OutputStream os = ss.getOutputStream();
            os.write("Hello World!".getBytes());
            os.flush();
            os.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new SecretSocketClient();
    }
}
