/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jess
 */
public class Complaint {
    private int id;
    private String name;
    private String email;
    private String message;
    
    public Complaint(int id, String name, String email, String msg){
        this.id = id;
        this.name = name;
        this.email = email;
        this.message = msg;
    }
    
    public void setIDNum(int idNum){
        this.id = idNum;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setMessage(String message){
        this.message = message;
    }
}
