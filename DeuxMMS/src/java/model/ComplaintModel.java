/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBHandler;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jess
 */
public class ComplaintModel {
    
    public DBHandler dbHandler;
    private User user;
    private String complaint = "";
    private int printNum = 0;
    
    
    //constructor
    public ComplaintModel()throws InstantiationException, IllegalAccessException{
        try {
            dbHandler = new DBHandler();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private String viewComplaint(){
        return complaint;
    }
    
    public int printComplaint(){
        return printNum;
    }
    
    public int closeComplaint(User user){
        return 0;
    }
    public List<Complaint> getComplaintList() throws SQLException{
        List<Complaint> list = new ArrayList<Complaint>();
        
        String complaintQuery = "SELECT * FROM COMPLAINTS";
        list = dbHandler.getComplaints(complaintQuery);
  
        return list;
    }
    
    public void addComplaint(String name, String email, String message) throws SQLException{
        int i = 0;
        String countComplaints = "SELECT COUNT(*) FROM COMPLAINTS";
        i = dbHandler.getCount(countComplaints);
        i++;
        String addComplaintQuery = "INSERT INTO COMPLAINTS (ID, NAME, EMAIL, MESSAGE) VALUES "
                + "(" + i + ", '" + name + "', '" + email + "', '" + message + "'" + ")";
        dbHandler.fileComplaint(addComplaintQuery);
    }
}
