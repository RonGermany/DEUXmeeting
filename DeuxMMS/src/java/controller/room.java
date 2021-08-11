/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.RoomModel;

/**
 *
 * @author Jess
 */
public class room extends HttpServlet {

    public room (){
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, IllegalAccessException, SQLException, InterruptedException {
        
        RoomModel rm = new RoomModel();
        String _roomName = request.getParameter("name");
        String _roomNum = request.getParameter("number");
        String _roomType = request.getParameter("type");
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            if(_roomName != null && _roomNum != null && _roomType != null){
                rm.createNewRoom(_roomNum, _roomType, "", _roomName);
                out.println("Room created successfully.....");
                TimeUnit.SECONDS.sleep(5);
                response.sendRedirect("Admin-Dashboard.jsp");
            }
            else
                out.println("Error entering data, refresh page and try again.");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException | IllegalAccessException | SQLException | InterruptedException ex) {
            Logger.getLogger(room.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException | IllegalAccessException | SQLException | InterruptedException ex) {
            Logger.getLogger(room.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
