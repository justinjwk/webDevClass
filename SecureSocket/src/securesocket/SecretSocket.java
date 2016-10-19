package securesocket;

import javax.crypto.*;
import java.io.*;
import java.net.Socket;
import java.security.*;


public class SecretSocket {
    private Key key = null;
    private Cipher outCipher = null;
    private Cipher inCipher = null;
    private CipherInputStream cis = null;
    private CipherOutputStream cos = null;

    private Socket socket = null;

    private String algorithm = "DES";

    public SecretSocket(Socket socket, Key key)  {
        this.socket = socket;
        this.key = key;
        algorithm = key.getAlgorithm();
        initializeCipher();
    }

    private void initializeCipher() {
       try {
            outCipher = Cipher.getInstance(algorithm);
            outCipher.init(Cipher.ENCRYPT_MODE, key);
            inCipher = Cipher.getInstance(algorithm);
            inCipher.init(Cipher.DECRYPT_MODE, key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }



    public InputStream getInputStream() throws IOException {
        InputStream is = socket.getInputStream();
        cis = new CipherInputStream(is, inCipher);
        return cis;
    }



    public OutputStream getOutputStream() throws IOException {
        OutputStream os = socket.getOutputStream();
        cos = new CipherOutputStream(os, outCipher);
        return cos;
    }
}

