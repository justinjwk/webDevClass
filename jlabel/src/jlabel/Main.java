/*
 * Main.java
 *
 * Created on September 27, 2007, 1:52 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jlabel;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author evansrb1
 */
public class Main extends JFrame {
    
    JLabel simple = new JLabel ("Text Only", JLabel.CENTER);
    JLabel textAndIcon;
    JLabel html = new JLabel("<html>This is <b>HTML</b><br>multiple lines<br>work too!</html");
    /** Creates a new instance of Main */
    public Main() {
        super("JLabels");
        Icon icon = new ImageIcon(getClass().getResource("duke.gif"));
        textAndIcon = new JLabel("Duke", icon, JLabel.CENTER);
        add(simple, BorderLayout.NORTH);
        add(textAndIcon, BorderLayout.CENTER);
        add(html, BorderLayout.SOUTH);        
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
    
}
