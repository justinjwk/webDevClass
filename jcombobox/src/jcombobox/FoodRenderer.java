/*
 * FoodRenderer.java
 *
 * Created on September 28, 2007, 2:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jcombobox;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author evansrb1
 */
public class FoodRenderer extends DefaultListCellRenderer {
    
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus) {
        JLabel renderer = (JLabel)(super.getListCellRendererComponent(list, value, index, isSelected, hasFocus));
        if (value instanceof Food) {
            Food food = (Food)value;
            renderer.setText(food.getName() + " ($" + food.getCost()+ ")");
            renderer.setIcon(food.getIcon());
            renderer.setToolTipText(food.getDescription());
        }
        return renderer;
    }
    
    /**
     * Creates a new instance of FoodRenderer
     */
    public FoodRenderer() {
    }
    
}
