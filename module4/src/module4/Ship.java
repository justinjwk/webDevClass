/*
 * File name : Ship.java 
 * Author : Justin Kim
 * This class is an abstract class to describe Ships.
 */
package module4;

/**
 *
 * @author Justin
 */
public abstract class Ship implements Contact {
    
    private int length;
    private int speed;
    private String name;
    private String type;
    
    public Ship() {
        length = 0;
        speed = 0;
        name = "";
        type = "";
    }
    
    public Ship(String name, String type, int speed, int length) {
        this.length = length;
        this.speed = speed;
        this.name = name;
        this.type = type;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public void setLength(int length) {
        // if length is negative number, then throw an exception
        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        else {
            this.length = length;
        }
        
    }
    
    public int getSpeed() {
        return this.speed;
    }
    
    public void setSpeed(int speed) {
        // if speed is negative number, then throw an exception
        if (speed < 0) {
            throw new IllegalArgumentException("Speed cannot be negative");
        }
        else {
            this.speed = speed;
        }
        
    }
    
    public void setSpeed(String speed) {
        this.speed = Integer.parseInt(speed);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String toString() {
        return ("Ship Name: " + this.getName() + ", Type: " + this.getType() +
                ", Speed: " + this.getSpeed() + " knots, Length: " + this.getLength() + " fts\n");
    }
}
