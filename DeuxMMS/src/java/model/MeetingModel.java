/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBHandler;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jess
 */
public class MeetingModel {
    
    public DBHandler dbHandler;
    
    private User user;
    private String meetConfirm = "Your meeting has been scheduled.";
    private boolean status = false;
    private String invMeet = "Invalid Meeting criteria, please try again.";
    private String editMeet = "Your changes have been saved.";
    private String invEdit = "Your changes are not valid, please try again.";
    private String display = "Meetings for you are as follows: ";
    
    //constructor
    public MeetingModel()throws InstantiationException, IllegalAccessException{
        try {
            dbHandler = new DBHandler();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public void createMeeting(String user, String name, String date, String hour, String min,  String duration, String room) throws SQLException{
        int i = 0;
        int hours, minute, dur;
        String startHour = hour;
        String startMin = min;
        String endHour, endMin, meetDur;
        minute = Integer.parseInt(min);
        hours = Integer.parseInt(hour);
        dur = Integer.parseInt(duration);
        if(dur > 60){
            dur = 60;
        }
        if(dur == 60){
            hours++;
        }
        else if(dur < 60){
            minute += dur;
            if(minute >= 60){
                hours++;
                minute -= 60;
            }
        }
        endMin = String.valueOf(minute);
        endHour = String.valueOf(hours);
        meetDur = String.valueOf(dur);
        String countMeetings = "SELECT COUNT(*) FROM MEETING";
        i = dbHandler.getCount(countMeetings);
        i++;
        String id = String.valueOf(i);
        String meetingQuery = "INSERT INTO MEETING (ID, NAME, ROOMNUM, CREATOR, STARTTIME, ENDTIME, DURATION, DATE) VALUES "
                + "('" + id + "', '" + name + "', '" + room + "', '" + user + "', '" + startHour + ":" + startMin + "', '"
                + endHour + ":" + endMin + "', '" + meetDur + "', '" + date + "'" + ")";
        dbHandler.newMeeting(meetingQuery);
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
