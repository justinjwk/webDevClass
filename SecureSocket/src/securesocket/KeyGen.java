package securesocket;

import javax.crypto.*;
import java.io.*;
import java.security.*;

/**
 *
 * @author evansrb1
 */
public class KeyGen {
    int foo = 1;
    KeyGenerator kg = null;
    public static final String KEY_FILE = "secret.key";
    public static final String ALGORITHM = "DES";

    public KeyGen() {
        try {
            kg = KeyGenerator.getInstance(ALGORITHM);
            Key key = kg.generateKey();
            writeKey(KEY_FILE, key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    private void writeKey(String filename, Object o) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            oos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Key getSecretKey() {
//        Security.addProvider(new SunJCE());
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(KEY_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Key key = null;
        try {
            ObjectInputStream ois = null;
            ois = new ObjectInputStream(fis);
            key = null;
            key = (Key) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("key = " + key);
        return key;
    }

      public static void main(String[] args) {
        KeyGen gen = new KeyGen();
        gen.getSecretKey();
    }
}
