/*
 * Main.java
 *
 * Created on September 28, 2007, 2:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jcombobox;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author evansrb1
 */
public class Main extends JFrame {
    
    private final DefaultListModel model = new DefaultListModel();
    private final JComboBox box;
    
    /** Creates a new instance of Main */
    public Main() {
        super("JComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        box = new JComboBox();
        add(new JScrollPane(box), BorderLayout.CENTER);
        box.setRenderer(new FoodRenderer());
    }
    
    private void addFood(Food food) {
        box.addItem(food);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.addFood(new Food("Coca Cola", "1.00", "12 oz Can of Coke", new ImageIcon(main.getClass().getResource("soda.gif"))));
        main.addFood(new Food("Sprite", "1.00", "12 oz Can of Sprint", new ImageIcon(main.getClass().getResource("soda.gif"))));        
        main.addFood(new Food("Blueberry Muffin", "1.50", "Blueberry Muffin", new ImageIcon(main.getClass().getResource("muffin.gif"))));                
        main.addFood(new Food("Banana Muffin", "1.50", "Banana Muffin", new ImageIcon(main.getClass().getResource("muffin.gif"))));                        
        main.addFood(new Food("Bran Muffin", "1.50", "Lowfat Bran Muffin", new ImageIcon(main.getClass().getResource("muffin.gif"))));                                
        main.addFood(new Food("Apple", "0.50", "Red Delicious", new ImageIcon(main.getClass().getResource("fruit.gif"))));                                
        main.addFood(new Food("IBC Root Beer", "1.20", "16 oz bottle", new ImageIcon(main.getClass().getResource("bottlesoda.gif"))));                                        
        main.addFood(new Food("Cheese Pizza", "5.20", "12 inch pizza", new ImageIcon(main.getClass().getResource("pizza.gif"))));                                                
        main.addFood(new Food("Veggie Pizza", "5.20", "Onions and Peppers, 12 inch pizza", new ImageIcon(main.getClass().getResource("pizza.gif"))));                                                        
        main.addFood(new Food("Submarine Sandwich", "2.50", "Roast Beef", new ImageIcon(main.getClass().getResource("sandwich.gif"))));                                                        
        
        
        main.pack();
        main.setVisible(true);
    }
    
}
