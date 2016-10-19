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

/**
 *
 * @author evansrb1
 */
public class Main {

    
    
    /** Creates a new instance of Main */
    public Main() {
    }

    
    private static void writeToFile(PrintWriter p) {
        int l = 0;
        while (l < 10) {
            for (int i=0; i < 10; i++) {
                p.printf("[%2d] ", i+l);
            }
            p.println();
            l++;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedWriter bout = null;
        FileWriter out = null;
        PrintWriter pout = null;

        try {
            out = new FileWriter("text.txt");
            bout = new BufferedWriter(out);
            pout = new PrintWriter(bout);
            writeToFile(pout);
            System.out.println("Encoding: " + out.getEncoding());
            bout.close();
            bout = null;
        } catch (IOException ioe) {
            System.out.println("IO problem: " + ioe);
            System.out.println("details: " + ioe.getMessage());
            ioe.printStackTrace();
            try {
                if (bout != null) {
                    bout.close();
                }
            } catch (IOException ignored) {
            }
        }
    }
}
