/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Jess
 */
public class MeetingModel {
    
    private User user;
    private String meetConfirm = "Your meeting has been scheduled.";
    private boolean status = false;
    private String invMeet = "Invalid Meeting criteria, please try again.";
    private String editMeet = "Your changes have been saved.";
    private String invEdit = "Your changes are not valid, please try again.";
    private String display = "Meetings for you are as follows: ";
    
    //constructor
    public MeetingModel(){
        
    }
    
    public String createMeeting(User user){
        return meetConfirm;
    }
    
    private boolean authenticateMeeting(){
        return status;
    }
    
    public String invalidMeeting(){
        return invMeet;
    }
    
    public String editMeeting(User user){
        return editMeet;
    }
    
    public String invalidMeetingEdit(){
        return invEdit;
    }
    
    public String displayMeeting(Date date){
        return display;
    }
}
