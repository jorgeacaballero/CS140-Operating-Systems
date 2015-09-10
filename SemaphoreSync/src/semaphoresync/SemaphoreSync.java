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
public class SemaphoreSync {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Semaphore mutex = new Semaphore(1);
        new Hilo(mutex).start();
        try {
            System.out.println("Codigo de programa");
            mutex.acquire();
            System.out.println("Hilo principal: Estoy en la seccion critica");
            mutex.release();
            System.out.println("Codigo del programa");
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaphoreSync.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
