/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorproductoconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorgecaballero
 */
public class Consumidor extends Thread{
    private Buffer buffer;
    
    public Consumidor(Buffer buffer){
        this.buffer = buffer;
    }
    
    public void run(){
        while (true){
            buffer.consumir();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
