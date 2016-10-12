/*
 * Main.java
 *
 * Created on September 27, 2007, 12:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gridbaglayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author evansrb1
 */
public class Main extends JFrame {
    
    private final JTextField jtf1 = new JTextField(20);
    private final JTextField jtf2 = new JTextField(20);    
    private final JTextField jtf3 = new JTextField(20);    
    private final JTextField jtf4 = new JTextField(20);    
    private final JTextField jtf5 = new JTextField(20);    
    private final JButton button = new JButton("Really Big Exit!");
    
    /** Creates a new instance of Main */
    public Main() {
        super("GridBagLayout");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor=GridBagConstraints.EAST;
        add(new JLabel("Name:"), gbc);
        add(new JLabel("Street:"), gbc);
        add(new JLabel("City:"), gbc);
        add(new JLabel("State:"), gbc);
        add(new JLabel("Zip:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(jtf1, gbc);
        gbc.gridy = GridBagConstraints.RELATIVE;
        add(jtf2, gbc);
        add(jtf3, gbc);
        add(jtf4, gbc);
        add(jtf5, gbc);

        // now gridy is one below the last value added
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.weighty = 1.0;        
        gbc.fill = GridBagConstraints.BOTH;
        add(button, gbc);
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Main();
    }
    
}
