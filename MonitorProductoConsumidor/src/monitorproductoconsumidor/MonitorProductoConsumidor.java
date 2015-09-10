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
public class MonitorProductoConsumidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        BufferMonitor buffer = new BufferMonitor(10);
        new Productor(buffer).start();
        new Consumidor(buffer).start();
        new Consumidor(buffer).start();
        new Consumidor(buffer).start();
        new Consumidor(buffer).start();
        new Consumidor(buffer).start();
        new Consumidor(buffer).start();
        
        while(true){
            buffer.ver();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MonitorProductoConsumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
