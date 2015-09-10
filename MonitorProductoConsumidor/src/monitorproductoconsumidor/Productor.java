/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorproductoconsumidor;

import java.util.Random;

/**
 *
 * @author jorgecaballero
 */
public class Productor extends Thread{
    private Buffer buffer;
    public Productor(Buffer buffer){
        this.buffer = buffer;
    }
    
    public void run(){
        Random rand = new Random();
        while (true){
            buffer.producir(Math.abs(rand.nextInt())%100);
        }
    }
    
}
