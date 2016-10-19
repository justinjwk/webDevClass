/*
 * Main.java
 *
 * Created on October 9, 2007, 5:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package charoutput;
import java.io.*;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author evansrb1
 */
public class Main {

    
    
    /** Creates a new instance of Main */
    public Main() {
    }

    
    private static void readFromFile(BufferedReader bin) {
        String line;
        try {
            while ((line = bin.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ioe) {
            System.out.println("Had problems reading input file");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader bin = null;
        FileReader in = null;

        try {
            in = new FileReader(new File(Main.class.getResource("text.txt").toURI()));
            bin = new BufferedReader(in);
            readFromFile(bin);
            bin.close();
            bin = null;
        } catch (URISyntaxException ex) {
            System.out.println("Bad URI for file text.txt");
        } catch (IOException ioe) {
            System.out.println("IO problem: " + ioe);
            System.out.println("details: " + ioe.getMessage());
            ioe.printStackTrace();
            try {
                if (bin != null) {
                    bin.close();
                }
            } catch (IOException ignored) {
            }
        }
    }
}
