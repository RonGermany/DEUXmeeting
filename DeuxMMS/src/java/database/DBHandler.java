/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
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
        finally {
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
        finally {
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
        String user = "";
        String password = "";
        String checkUser = "SELECT EMAIL, PASSWORD FROM USERS WHERE EMAIL= '" + email + "'";

        ResultSet res = executeQuery(checkUser);
        try {
            while (res.next()) {
                user = res.getString("EMAIL");
                password = res.getString("PASSWORD");
                if (user.equals(email) && password.equals(pass)) {
                    status = true;
                } else {
                    status = false;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error authenticating user.");
            System.out.println("I am coming from here");
        }
        return status;
    }
    
    /*two methods to create users*/
    public void createAminUser(String name, String email, String pass, String address, String phone, String ccNum, String exp, String ccv){
        String meeting = "";    //default place holder
        String insertAdmin = "INSERT INTO APP.USERS VALUES ('" + email + "', '" + pass + "', '" + name + "', '" + address + "', '" + phone + "', '" + "A" + "', " + ccNum + "', " + exp + "'," + ccv + "'," + "'" + meeting + "'" + ")"; 
    
        if(executeAction(insertAdmin)){
            //do something to let user know successful
        }
    }
    
    public void createClientUser(String name, String email, String pass, String address, String phone, String ccNum, String exp, String ccv){
        String meeting = "";    //default place holder
        String insertClient = "INSERT INTO APP.USERS VALUES ('" + email + "', '" + pass + "', '" + name + "', '" + address + "', '" + phone + "', '" + "C" + "', " + ccNum + "', " + exp + "'," + ccv + "'," + "'" + meeting + "'" + ")";
    
        if(executeAction(insertClient)){
            //do something to let user know successful
        }
    }
}
