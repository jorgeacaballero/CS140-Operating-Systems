/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftpoperativosproyecto;

/**
 *
 * @author jorgecaballero
 */
public class User {
    private String username;
    private String password;
    
    public User(String user, String pass){
        this.password = pass;
        this.username = user;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    
    
}
