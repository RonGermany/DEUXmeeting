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
import model.ComplaintModel;

/**
 *
 * @author Jess
 */
public class filecomplaint extends HttpServlet {

    public filecomplaint(){
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, IllegalAccessException, SQLException, InterruptedException {
        ComplaintModel cm = new ComplaintModel();
        
        String _name = request.getParameter("name");
        String _email = request.getParameter("email");
        String _message = request.getParameter("message");
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            if(_name != null){
                cm.addComplaint(_name, _email, _message);
                TimeUnit.SECONDS.sleep(5);
                response.sendRedirect("User-Dashboard.jsp");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException | IllegalAccessException | SQLException | InterruptedException ex) {
            Logger.getLogger(filecomplaint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException | IllegalAccessException | SQLException | InterruptedException ex) {
            Logger.getLogger(filecomplaint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
