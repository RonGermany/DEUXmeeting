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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Complaint;
import model.ComplaintModel;

/**
 *
 * @author Jess
 */
public class getcomplaints extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, IllegalAccessException, SQLException {
        ComplaintModel cm = new ComplaintModel();
        List<Complaint> list = new ArrayList<Complaint>();
        String msg = request.getParameter("message");
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if(action.equals("list")){
                list = cm.getComplaintList();
            }
            String listMsg = "no data";
            if(list.size() > 0){
                listMsg = list.size() + (list.size() > 1 ? " complaints" : " complaint");
            }
            request.setAttribute("MSG", listMsg);
            request.setAttribute("list", list);
            
            request.getRequestDispatcher("Admin-Dashboard.jsp");
            
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(getcomplaints.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(getcomplaints.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
