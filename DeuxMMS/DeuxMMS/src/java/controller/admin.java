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
import model.Admin;

/**
 *
 * @author Jess
 */
public class admin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, IllegalAccessException, SQLException, InterruptedException {
        Admin ad = new Admin();
        String _email = request.getParameter("email");
        String _email1 = request.getParameter("email1");
        String _email2 = request.getParameter("email2");
        String _pass = request.getParameter("pass");
        String _pass1 = request.getParameter("pass1");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if(_email != null && _email1 != null && _email2 != null && _pass != null && _pass1 != null){
                if(_email1.equals(_email2) && _pass.equals(_pass1)){
                    ad.createAdminUser(_email1); 
                    TimeUnit.SECONDS.sleep(5);
                    response.sendRedirect("Admin-Dashboard.jsp");
                }
                else{
                    TimeUnit.SECONDS.sleep(5);
                    out.println("User was not added, please try again...");
                }   
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException | IllegalAccessException | SQLException | InterruptedException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException | IllegalAccessException | SQLException | InterruptedException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
