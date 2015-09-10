/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorproductoconsumidor;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorgecaballero
 */
public class Buffer {
    private int[] datos;
    private int N;
    private int entrada;
    private int salida;
    private int nDatos;
    
    public Buffer(int N){
        this.N = N;
        datos = new int[N];
    }
    
    public synchronized void producir(int n){
        while (true) {
            if (nDatos < N) {
                datos[entrada] = n;
                entrada =  (entrada + 1)%N;
                nDatos++;
                notify();
                break;
            } else {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public synchronized int consumir(){
        int temp;
        while (true) {
            if (nDatos > 0) {
                temp = datos[salida];
                salida =  (salida + 1)%N;
                nDatos--;
                notify();
                break;
            } else {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return temp;
    }
    
    public void ver(){
        System.out.println(Arrays.toString(datos));
    }
}
