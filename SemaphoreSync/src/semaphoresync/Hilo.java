/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphoresync;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jorgecaballero
 */
public class Hilo extends Thread {
    private Semaphore mutex;
    
    public Hilo(Semaphore mutex){
        this.mutex = mutex;
    }
    
    public void run() {
        try {
            System.out.println("Codigo del hilo");
            mutex.acquire();
            System.out.println("Hilo: estoy en seccion critica parte 1");
            Thread.sleep(1000);
            System.out.println("Hilo: estoy en seccion critica parte 2");
            mutex.release();
            System.out.println("Codigo del programa");
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
