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
public class deleteroom extends HttpServlet {

    public deleteroom(){
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, IllegalAccessException, SQLException, InterruptedException {
        RoomModel rm = new RoomModel();
        String _roomNum = request.getParameter("number");
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            rm.deleteRoom(_roomNum);
            response.sendRedirect("Success.jsp");
            TimeUnit.SECONDS.sleep(5);
        }
        response.sendRedirect("Admin-Dashboard.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException | IllegalAccessException | SQLException | InterruptedException ex) {
            Logger.getLogger(deleteroom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException | IllegalAccessException | SQLException | InterruptedException ex) {
            Logger.getLogger(deleteroom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
