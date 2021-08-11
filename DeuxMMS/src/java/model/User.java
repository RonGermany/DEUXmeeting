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
    public DBHandler dbHandler;

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
    
    public void addUser(String email, String password, String name, String address, String phone, String ccNum, String ccExp, String ccv) throws SQLException{
        String type = "C";
        String meeting = "";
        String addUserQuery = "INSERT INTO USERS (EMAIL, PASSWORD, NAME, ADDRESS, PHONE, TYPE, CCNUM, CCEXP, CCV, MEETINGS) VALUES "
                + "('" + email + "', '" + password + "', '" + name + "', '" + address
                + "', '" + phone + "', '" + type + "', '" + ccNum + "', '" + ccExp
                + "', '" + ccv + "', '" + meeting + "'" + ")";
        dbHandler.createClientUser(addUserQuery);
    }
}

