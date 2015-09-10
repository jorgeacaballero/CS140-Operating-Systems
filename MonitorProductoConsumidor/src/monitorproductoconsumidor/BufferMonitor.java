/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorproductoconsumidor;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorgecaballero
 */
public class BufferMonitor extends Buffer{
    private int[] datos;
    private int N;
    private int entrada;
    private int salida;
    private int nDatos;
    private ReentrantLock mutex = new ReentrantLock();
    private Condition vacio = mutex.newCondition();
    private Condition lleno = mutex.newCondition();
    
    public BufferMonitor(int N){
        super(N);
        this.N = N;
        datos = new int[N];
    }
    
    public void producir(int n){
        mutex.lock();
        while (true) {
            if (nDatos < N) {
                datos[entrada] = n;
                entrada =  (entrada + 1)%N;
                nDatos++;
                vacio.signal();
                break;
            } else {
                try {
                    lleno.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(BufferMonitor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        mutex.unlock();
    }
    
    public int consumir(){
        mutex.lock();
        int temp;
        while (true) {
            if (nDatos > 0) {
                temp = datos[salida];
                salida =  (salida + 1)%N;
                nDatos--;
                lleno.signal();
                break;
            } else {
                try {
                    vacio.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(BufferMonitor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        mutex.unlock();
        return temp;
    }
    
    public void ver(){
        System.out.println(Arrays.toString(datos));
    }
}
