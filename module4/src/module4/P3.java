/*
 * File name : P3.java 
 * Author : Justin Kim
 * This class describes P3 which is extended from Aircraft.
 */
package module4;

/**
 *
 * @author Justin
 */
public class P3 extends Aircraft {
    
    private int numberEngines;
    
    public P3(String name, String type, int speed, int length, int altitude, int numberEngines) {
        super(name, type, speed, length, altitude);
        setNumberEngines(numberEngines);
    }
    
    public int getNumberEngines() {
        return this.numberEngines;
    }
    
    public void setNumberEngines(int numberEngines) {
        // if number of engines is negative number, then throw an exception
        if (numberEngines < 0) {
            throw new IllegalArgumentException("Number of engine cannot be negative");
        }
        else {
            this.numberEngines = numberEngines;
        }
    }
    
    public String toString() {
        return ("P3 Name: " + this.getName() + ", Type: " + this.getType() +
                ", Speed: " + this.getSpeed() + " knots, Length: " + this.getLength() + 
                " fts, Altitude: " + this.getAltitude() + " fts, Number of Engines: " +
                this.getNumberEngines());
    }
}
