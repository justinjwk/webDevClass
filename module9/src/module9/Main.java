/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module9;

/**
 *
 * @author Justin
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Module9 module = new Module9();
        
        Thread t = new Thread(module);
        
        t.start();        
    }
}
