/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module4;

/**
 *
 * @author Justin
 */
public class Test {
    
    public static void main(String[] args) {
        String s = "Hello World!";
        byte data[] = s.getBytes();
        for(int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
    }
    
}
