/*
 * Main.java
 * 
 * Created on Oct 13, 2007, 10:02:13 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binaryio;
import java.io.*;

/**
 *
 * @author evansrb1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataOutputStream out = null;
        DataInputStream in = null;        
        File file = new File("test.dat");
        try {
            file.createNewFile();
            out = new DataOutputStream(new FileOutputStream(file));
            for (int i=0; i < 10; i++) {
                out.writeInt(i);
            }
            out.flush();
            out.close();
            //
            in = new DataInputStream(new FileInputStream(file));
            System.out.println("The test.dat file contained the following int values");
            long sizeOfFile = file.length() / 4;  // 4 bytes per int
            for (long i=0; i < sizeOfFile; i++) {
                System.out.println(in.readInt());
            }
            in.close();
        } catch (IOException ioe) {
            System.err.println("Had problem with test.dat");
            System.err.println("Error was  " + ioe.getMessage());
            System.err.println("Stack trace: " + ioe.getStackTrace());
        }
    }

}
