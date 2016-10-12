/*
 * File name : Destroyer.java 
 * Author : Justin Kim
 * This class describes Destroyer which is extended from Ship.
 */
package module4;

/**
 *
 * @author Justin
 */
public class Destroyer extends Ship {
    
    private int numberMissile;
    
    public Destroyer(String name, String type, int speed, int length, int numberMissile) {
        super(name, type, speed, length);
        setNumberMissile(numberMissile);
    }
    
    public int getNumberMissile() {
        return this.numberMissile;
    }
    
    public void setNumberMissile(int numberMissile) {
         // if number of missile is negative number, then throw an exception
        if (numberMissile < 0) {
            throw new IllegalArgumentException("Number of missile cannot be negative");
        }
        else {
            this.numberMissile = numberMissile;
        }
        
    }
    
    public void setNumberMissile(String numberMissile) {
        try {
            int numMissileInt = Integer.parseInt(numberMissile);
            System.out.println("Parsing the String " + "\"" + numberMissile + "\", it's value is " + numMissileInt);
            this.numberMissile = numMissileInt;
        } catch (NumberFormatException nfe) {
            System.out.println("Unable to parse the String " + "\"" + numberMissile + "\"" + " Missiles set to 2");
            this.numberMissile = 2;
        }
    }
    
    public String toString() {
        return ("Destroyer Name: " + this.getName() + ", Type: " + this.getType() +
                ", Speed: " + this.getSpeed() + " knots, Length: " + this.getLength() + 
                " fts, Number of Missile: " + this.getNumberMissile());
    }
}
