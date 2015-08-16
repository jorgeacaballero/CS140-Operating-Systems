/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz_2_control_threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorgecaballero
 */
public class Cashier extends Thread {
    public int id;
    
    public Cashier(int id){
        this.id = id;
    }
    
    public void run(){
        while(true){
            if (!Quiz_2_control_threads.cola.isEmpty()) {
                try {
                    Client c = (Client)Quiz_2_control_threads.cola.removeFirst();
                    System.out.println("El cajero con ID "+id+ " esta atendiendo a cliente con ID " + c.getID() + " con una transaccion de " + c.getTime() + " ms.");
                    Cashier.sleep(c.getTime());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("Esta vacia la cola!");
                try {
                    Cashier.sleep(300);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
