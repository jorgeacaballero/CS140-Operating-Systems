/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz_2_control_threads;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author jorgecaballero
 */
public class Quiz_2_control_threads {

    static LinkedList cola = new LinkedList();
    public static void main(String[] args) {
        Cashier caja1 = new Cashier(1);
        Cashier caja2 = new Cashier(2);
        
        for (int i = 100; i > 0; i--) {
            Random rand = new Random();
            Client c = new Client(i,rand.nextInt(4001) + 1000);
            cola.push(c);
        }
        
        caja1.start();
        caja2.start();
        
    }
    
}
