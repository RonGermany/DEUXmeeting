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
import model.AccountModel;

/**
 *
 * @author Jess
 */
public class editprofile extends HttpServlet {
    
    public editprofile(){
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, InterruptedException {
        AccountModel am = new AccountModel();
        
        String _name = request.getParameter("name");
        String _email = request.getParameter("email");
        String _address = request.getParameter("address");
        String _phone = request.getParameter("phone");
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            if(_name != null){
                am.editUser(_name, _email, _address, _phone);
                TimeUnit.SECONDS.sleep(5);
                response.sendRedirect("Admin-Dashboard.jsp");
                }       
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | InterruptedException ex) {
            Logger.getLogger(editprofile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | InterruptedException ex) {
            Logger.getLogger(editprofile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
