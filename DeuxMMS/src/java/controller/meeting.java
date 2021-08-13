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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MeetingModel;

/**
 *
 * @author Jess
 */
public class meeting extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException {
        MeetingModel mm = new MeetingModel();
        
        String _user = request.getParameter("user");
        String _name = request.getParameter("name");
        String _date = request.getParameter("date").toString();
        String _hour = request.getParameter("hour");
        String _min = request.getParameter("minutes");
        String _room = request.getParameter("select");
        String _duration = request.getParameter("duration");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            mm.createMeeting(_name, _room, _user, _hour, _min, _duration, _date);
            response.sendRedirect("User-Dashboard.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(meeting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(meeting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
