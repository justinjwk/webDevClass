/*
 *  File name : Submarine.java 
 * Author : Justin Kim
 * This class is an abstract class that is extended from Ship.
 */
package module4;

/**
 *
 * @author Justin
 */
public class Submarine extends Ship {
    
    private int numberTorpedos;
    
    public Submarine(String name, String type, int speed, int length, int numberTorpedos) {
        super(name, type, length, speed);
        setNumberTorpedos(numberTorpedos);
    }
    
    public int getNumberTorpedos() {
        return this.numberTorpedos;
    }
    
    public void setNumberTorpedos(int numberTorpedos) {
        // if number of torpedos is negative number, then throw an exception
        if (numberTorpedos < 0) {
            throw new IllegalArgumentException("Number of torpedo cannot be negative");
        }
        else {
            this.numberTorpedos = numberTorpedos;
        }
        
    }
    
    public void setNumberTorpedos(String numberTorpedos) {
        try {
            int numTorpedosInt = Integer.parseInt(numberTorpedos);
            System.out.println("Parsing the String " + "\"" + numberTorpedos + "\", it's value is " + numTorpedosInt);
            this.numberTorpedos = numTorpedosInt;
        } catch (NumberFormatException nfe) {
            System.out.println("Unable to parse the String " + "\"" + numberTorpedos + "\"" + " Torpedos set to 2");
            this.numberTorpedos = 2;
        }
    }
    
    public String toString() {
        return ("Submarine Name: " + this.getName() + ", Type: " + this.getType() +
                ", Speed: " + this.getSpeed() + " knots, Length: " + this.getLength() + 
                " fts, Number of Torpedos: " + this.getNumberTorpedos());
    }
}
