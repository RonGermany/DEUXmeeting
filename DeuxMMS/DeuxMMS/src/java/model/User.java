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
public class User {
    private DBHandler dbHandler;

    public String name;
    private String password;
    public String address;
    public String phone;
    public String ccNum;
    public String ccExp;
    public String ccv;
    
    private String user = "";
    private char type = 'B';
    
    //constructor
    public User()throws InstantiationException, IllegalAccessException{
        try {
            dbHandler = new DBHandler();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public String getUserType(char type){
        this.type = type;
        
        if(this.type == 'A')
            this.user = "Administrator";
        else
            this.user = "Client";
        
        return user;
    }
}

