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
public class RoomModel {
    
    public DBHandler dbHandler;
    
    private User user;
    private String confirm = "";
    private boolean status = false;
    
    //constructor
    public RoomModel()throws InstantiationException, IllegalAccessException{
        try {
            dbHandler = new DBHandler();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void createNewRoom(String roomNum, String roomType, String roomCost, String roomName) throws SQLException{
        String roomTypeUC = roomType.toUpperCase();
        if(roomTypeUC.equals("SPECIAL"))
            roomCost = "100";
        else
            roomCost = "0";
        String assembleQuery = "INSERT INTO ROOMS (ROOMNUM, ROOMTYPE, ROOMCOST, ROOMNAME) VALUES "
                + "('" + roomNum + "', '" + roomTypeUC + "', '" + roomCost + "', '" + roomName + "'" + ")";
        dbHandler.createRoom(assembleQuery);
    }
    
    private boolean authenticateRoom(){
        return status;
    }
    
    public String editRoom(){
        return confirm;
    }
}
