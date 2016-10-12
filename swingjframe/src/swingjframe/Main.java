/*
 * Main.java
 *
 * Created on September 26, 2007, 11:07 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package swingjframe;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author evansrb1
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame jf1 = new JFrame("JFrame with no size");
        jf1.setLocationByPlatform(true);
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf1.setVisible(true);

        JFrame jf2 = new JFrame("JFrame with setSize()");
        jf2.setSize(250, 100);
        jf2.setLocationByPlatform(true);        
        jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf2.setVisible(true);
        
        JFrame jf3 = new JFrame("JFrame with pack()");
        JPanel jp = new JPanel();
        jp.setPreferredSize(new Dimension(250, 100));
        jf3.add(jp, BorderLayout.CENTER);
        jf3.pack();
        jf3.setLocationByPlatform(true);        
        jf3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        jf3.setVisible(true);
    }
    
}
