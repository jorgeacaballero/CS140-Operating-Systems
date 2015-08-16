/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz_2_control_threads;

/**
 *
 * @author jorgecaballero
 */
public class Client {
    private int id;
    private int time;

    public Client(int id, int time){
        this.id = id;
        this.time = time;
    }
    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }
    
    public int getID(){
        return id;
    }

    
}
