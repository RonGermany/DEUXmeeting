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
public class BillingModel {
    private DBHandler dbHandler;
    private User user;
    private String confirm = "";
    private boolean status = false;
    
    //constructor
    public BillingModel()throws InstantiationException, IllegalAccessException{
        try {
            dbHandler = new DBHandler();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    private String editBilling(User user){
        this.user = user;
        return confirm;
    }
    
    private boolean authenticateBillingEdits(){
        return status;
    }
}
