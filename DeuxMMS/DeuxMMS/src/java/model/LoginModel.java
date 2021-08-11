/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBHandler;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jess
 */
public class LoginModel{
    
    public DBHandler dbHandler;

    private String cMessage = "Successful Login";
    private String uMessage = "Invalid Credentials";
    private User user = new User();
    private boolean confirm = false;
    
    //constructor
    public LoginModel() throws InstantiationException, IllegalAccessException{
        try {
            dbHandler = new DBHandler();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private boolean authenticateLogin(String email, String pass){
        confirm = dbHandler.authenticateUser(email, pass);
        return confirm;
    }
    
    public String loginUnsuccessful(){
        return this.uMessage;
    }
    
    public String confirmLogin(String email, String pass){
        String type;
            if(authenticateLogin(email, pass)){
                type = dbHandler.getUserType(email);
            }
            else{
                type = "INVALID";
            }
        return type;
    }
}
