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
    private String idNum;
    private String name;
    private String email;
    private String message;
    
    public void setIDNum(String idNum){
        this.idNum = idNum;
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
