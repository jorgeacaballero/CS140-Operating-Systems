/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilosdecontrolso1;

import java.util.Scanner;

/**
 *
 * @author Juan Leonardo
 */
public class FibThread extends Thread {
    public void run() {
        Scanner scn = new Scanner(System.in);
        System.out.print("N= ");
        //int n = scn.nextInt();
        System.out.println("fib(N): "+FibThread.fib(100));
    }
    
    public static int fib(int n) {
        if (n==0) return 0;
        else if(n==1) return 1;
        else return fib(n-2) + fib(n-1);
    }
    
}
