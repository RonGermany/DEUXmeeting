/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Complaint;
import model.User;
/**
 *
 * @author Jess
 */
public class DBHandler {
    
    private static final String DBURL = "jdbc:derby:C:/Derby/DeuxMMS";
    private Connection conn;
    private static Statement stmt = null;
    private String TableName = "";
    private static boolean status = false;
    
    public DBHandler() throws SQLException, InstantiationException, IllegalAccessException {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (ClassNotFoundException e) {
            //handle exception
        }
        this.conn = DriverManager.getConnection(DBURL);
        //createConnection();
    }

//    private void createConnection(){
//        try{
//            conn = DriverManager.getConnection(DBURL);
//            System.out.println("I made it to DB");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
    //Function that executes a SELECT query and returns the requested values/data from the database
    public ResultSet executeQuery(String query) {
        ResultSet result;
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        }
        catch (SQLException ex) {
            System.out.println("Exception at executeQuery:dataHandler --> ERROR: " + ex.getLocalizedMessage());
            return null;
        }
        return result;
    }
    
    //Function that executes an insertion, deletion, or update query
    public boolean executeAction(String query2) {
        try {
            stmt = conn.createStatement();
            stmt.execute(query2);
            return true;
        }
        catch (SQLException ex) {
            System.out.println("Exception at executeQuery:dataHandler  --> ERROR: " + ex.getLocalizedMessage());
            return false;
        }
    }    
    //Get user name from database by using login information. This will carry throughout the session for ID purposes.
    //This is how a typical query should look...
    
    public String getUserName(String email) {
        String name = "";
        String nameQuery = "SELECT NAME "
                + "FROM USERS "
                + "WHERE EMAIL= '" + email + "'";
        ResultSet rs = executeQuery(nameQuery);
        try {
            while (rs.next()) {
                name = rs.getString("NAME");
            }
        } catch (SQLException e) {

        }
        return name;
    }

    public String getUserType(String email) {
        String type = "";
        String typeQuery = "SELECT TYPE "
                + "FROM USERS "
                + "WHERE EMAIL= '" + email + "'";
        ResultSet rs = executeQuery(typeQuery);
        try {
            while (rs.next()) {
                type = rs.getString("TYPE");
            }
        } catch (SQLException e) {

        }
        return type;
    }

    public boolean authenticateUser(String email, String pass) {
        String user;
        String password;
        String checkUser = "SELECT EMAIL, PASSWORD FROM USERS WHERE EMAIL= '" + email + "'";

        ResultSet res = executeQuery(checkUser);
        try {
            while (res.next()) {
                user = res.getString("EMAIL");
                password = res.getString("PASSWORD");
                status = user.equals(email) && password.equals(pass);
            }
        } catch (SQLException ex) {
            System.out.println("Error authenticating user.");
        }
        return status;
    }
    public void createRoom(String query) throws SQLException{
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }
    
    /*two methods to create users*/
    public void createAdminUser(String query) throws SQLException{
        stmt = conn.createStatement();
        stmt.executeUpdate(query);            
    }
    
    public void createClientUser(String query) throws SQLException{
        stmt = conn.createStatement();
        stmt.executeUpdate(query); 
    }
    
    public void editUser(String query) throws SQLException{
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }
    
    public void fileComplaint(String query) throws SQLException{
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }
    
    public void removeRoom(String query) throws SQLException{
        stmt = conn.createStatement();
        stmt.executeUpdate(query);        
    }
    
    public int getCount(String query) throws SQLException{
        ResultSet res = executeQuery(query);
        res.next();
        int count = res.getInt(1);
        return count;
    }
    public List<User> getUserInfo(String query) throws SQLException{
        List<User> u = new ArrayList<User>();
        
        ResultSet rs = executeQuery(query);
        while(rs.next()){};
        return u;
    }
    
    public List<Complaint> getComplaints(String query) throws SQLException{
        List<Complaint> list = new ArrayList<Complaint>();
        
        ResultSet rs = executeQuery(query);
        
        while(rs.next()){
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            String email = rs.getString("EMAIL");
            String msg = rs.getString("MESSAGE");
            Complaint c = new Complaint(id,name,email,msg);
            list.add(c);
        }
        return list;
    }

    public void newMeeting(String query) {
        
    } 
}
