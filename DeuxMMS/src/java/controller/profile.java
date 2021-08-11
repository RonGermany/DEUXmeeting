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
import model.User;

/**
 *
 * @author Jess
 */
public class profile extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, IllegalAccessException, SQLException, InterruptedException {
        User user = new User();
        
        String _name = request.getParameter("name");
        String _email = request.getParameter("email");
        String _email1 = request.getParameter("email-1");
        String _pass = request.getParameter("pass");
        String _pass1 = request.getParameter("pass-1");
        String _address = request.getParameter("address");
        String _phone = request.getParameter("phone");
        String _ccnum = request.getParameter("ccnum");
        String _ccexp = request.getParameter("ccexp");
        String _ccv = request.getParameter("ccv");
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            if(_name != null && _email != null && _pass != null && _address != null && _phone != null){
                if(_email.equals(_email1) && _pass.equals(_pass1)){
                    user.addUser(_email, _pass, _name, _address, _phone, _ccnum, _ccexp, _ccv);
                    TimeUnit.SECONDS.sleep(5);
                    response.sendRedirect("index.jsp");
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
            Logger.getLogger(profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException | IllegalAccessException | SQLException | InterruptedException ex) {
            Logger.getLogger(profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
