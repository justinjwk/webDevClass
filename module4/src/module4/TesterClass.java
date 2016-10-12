/*
 * File name : TestClass.java 
 * Author : Justin Kim
 * This class is for testing each classes.
 */

package module4;

import java.util.*;

/**
 *
 * @author Justin
 */
public class TesterClass {
    
    public static void main(String[] args) {
        
        // Create 2 Destroyers
        Destroyer nicholson = new Destroyer("Nicholson", "Destroyer", 100, 50, 20);
        Destroyer hayler = new Destroyer("Hayler", "Destroyer", 110, 45, 15);
        
        // Display 2 Destroyers
        System.out.println(nicholson.toString());
        System.out.println(hayler.toString());
        System.out.println("==================================================="
                + "===================================================");
        
        // test when the length is a negative number
        nicholson.setLength(-100);
        
        // Set missile number with a String "Foo"
        hayler.setNumberMissile("Foo");
        // Display after
        System.out.println(hayler.toString());
        System.out.println("==================================================="
                + "===================================================");
        
        // Create 2 Submarines
        Submarine seawolf = new Submarine("Seawolf", "Submarine", 50, 30, 10);
        Submarine uboat = new Submarine("Uboat", "Submarine", 45, 25, 8);
        
        // Display 2 Submarines
        System.out.println(seawolf.toString());
        System.out.println(uboat.toString());
        System.out.println("==================================================="
                + "===================================================");
        
        // Set torpedos number with a String "Foo"
        uboat.setNumberTorpedos("Foo");
        // Display after
        System.out.println(uboat.toString());
        System.out.println("==================================================="
                + "===================================================");
        
        // Create 2 P3s
        P3 falcon = new P3("Falcon", "P3", 200, 15, 15000, 1);
        P3 eagle = new P3("Eagle", "P3", 300, 20, 20000, 2);
        
        // Display 2 P3s
        System.out.println(falcon.toString());
        System.out.println(eagle.toString());
        System.out.println("==================================================="
                + "===================================================");
     
        // Make a collection of Destoryers
        List<Destroyer> destroyerList = new ArrayList<Destroyer>();
        destroyerList.add(nicholson);
        destroyerList.add(hayler);
        
        // Make a collection of Submarines
        List<Submarine> submarineList = new ArrayList<Submarine>();
        submarineList.add(seawolf);
        submarineList.add(uboat);
        
        // Make a collection that holds all Ships
        List<Ship> shipList = new ArrayList<Ship>();
        shipList.add(nicholson);
        shipList.add(hayler);
        shipList.add(seawolf);
        shipList.add(uboat);
        
        // Make a collection of all Contacts
        List<Contact> contactList = new ArrayList<Contact>();
        contactList.add(nicholson);
        contactList.add(hayler);
        contactList.add(seawolf);
        contactList.add(uboat);
        contactList.add(falcon);
        contactList.add(eagle);
        
        // Print out the list of Contacts
        System.out.println("------------------------------------   Collection"
                + " of Contacts   --------------------------------------");
        for(Contact c : contactList) {
            System.out.println(c.toString());
        }
        System.out.println("==================================================="
                + "===================================================");
                
                
    
    }
}
