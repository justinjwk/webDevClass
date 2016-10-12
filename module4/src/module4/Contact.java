/*
 * File name : Contact.java 
 * Author : Justin Kim
 * This class is an interface class for Contact
 */
package module4;

/**
 *
 * @author Justin
 */
public interface Contact {
    
    int getLength();
    void setLength(int lengh);
    
    int getSpeed();
    void setSpeed(int speed);
    void setSpeed(String speed);
    
    String getName();
    void setName(String name);
    
    String getType();
    void setType(String type);
    
    String toString();
}
