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
public class Admin extends User{
    
    public DBHandler dbHandler;
    
    public Admin()throws InstantiationException, IllegalAccessException{
        try {
            dbHandler = new DBHandler();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createAdminUser(String email) throws SQLException{
        
        String insertAdmin = "UPDATE USERS SET TYPE='A' WHERE EMAIL='" + email + "'";
        dbHandler.createAdminUser(insertAdmin);
    }
}
