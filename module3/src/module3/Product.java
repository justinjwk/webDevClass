/*
 * File name : Product.java 
 * Author : Justin Kim
 * This class takes integers as arguments and returns the product of the two integers
 */
package module3;

/**
 *
 * @author Justin
 */
public class Product {
    
    /*
        This method receives two integers and return its product
    */
    public static int getProduct(int numA, int numB) {
        return numA * numB;
    }
    
    public static void main(String[] args) {
        
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int product = getProduct(a, b);
        
        // if the result is a negative number, print it out in parenthesis
        if (product < 0) {
            System.out.println("The product of " + a + " and " + b + " is (" + product + ")");
        }
        else {
            System.out.println("The product of " + a + " and " + b + " is " + product);
        }
    }
    
}


