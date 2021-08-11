/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBHandler;
import java.sql.SQLException;

/**
 *
 * @author Jess
 */
public class AccountModel {
    
    private DBHandler dbHandler;
    
    private User user;
    private String confirm = "Your account has been successfully created.";
    private boolean status = false;
    
   //constructor
    public AccountModel(){
        
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
    
    public void editUser(String name, String email, String address, String phone) throws SQLException{
        String dbName = dbHandler.getUserName(email);
        String editQuery = "UPDATE USERS SET NAME='" + name + "', ADDRESS='" + address + "', PHONE='" + phone + "' WHERE EMAIL='" + email + "'";
        if(dbName.equals(name)){
            dbHandler.editUser(editQuery);
        }
    }    
    private boolean authenticateAccount(){
        return status;
    }
    
    public void getUser(String email) throws SQLException{
        String getUserQuery = "SELECT * FROM USERS WHERE EMAIL='" + email + "'";
        dbHandler.getUserInfo(getUserQuery);
    }
}
