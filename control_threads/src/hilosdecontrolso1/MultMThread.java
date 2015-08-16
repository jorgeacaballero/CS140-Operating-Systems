/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilosdecontrolso1;

/**
 *
 * @author Juan Leonardo
 */
public class MultMThread implements Runnable {
    private int[][] C;
    public MultMThread() {}
    public MultMThread(int[][] C) {
        this.C = C;
    }
    public void run() {
        int[][] A = {{1,2,3},{1,2,3},{1,2,4}};
        int[][] B = {{1,2,3},{1,2,3},{1,2,4}};        
        int n=3;
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++) {
                C[i][j] =0;
                for (int k=0; k<n; k++)
                    C[i][j] += A[i][k]*B[k][j];                    
            }        
    }
}
