/*
 * Food.java
 *
 * Created on September 28, 2007, 2:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jcombobox;

import javax.swing.Icon;

/**
 *
 * @author evansrb1
 */
public class Food {
    private String name;
    private String cost;
    private String description;
    private Icon icon;
    
    /** Creates a new instance of Food */
    public Food() {
    }

    public Food(String name, String cost, String description, Icon icon) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.icon = icon;
    }

    public String toString() {
        return name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
    
    
    
}
