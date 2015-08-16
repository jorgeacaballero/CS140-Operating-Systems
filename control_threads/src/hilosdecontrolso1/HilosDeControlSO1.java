/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilosdecontrolso1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Leonardo
 */
public class HilosDeControlSO1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            int C[][] = new int[3][3];
            int n=3;
            
            Thread fibThread = new FibThread();
            fibThread.start();         
            Thread multThread =new Thread(new MultMThread(C));
            multThread.start();
            multThread.join();
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++)
                    System.out.print(C[i][j]+ " ");
                System.out.println("");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosDeControlSO1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
