/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.*;

/**
 *
 * @author 738634
 */
public class LoginServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         String user_name = request.getParameter("user_name");
         String user_password = request.getParameter("user_password");
         String logout = request.getParameter("logout");
         
         if(user_name == null || user_name.equals("") 
                 || user_password == null || user_password.equals(""))
         {
             String denied = "You must enter something";
             request.setAttribute("message",denied);
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
             return;
         }
         
         HttpSession session = request.getSession();
         
          
         if(logout != null)
         {
             //String invalid = "You've succssfully logged out.";
             //request.setAttribute("message", invalid);
             session.invalidate();
             return;
         }
         
         User user = new User();
         AccountService as = new AccountService();
         user = as.login(user_name, user_password);
         if(user != null)
         {
            user = (User)session.getAttribute("user");
            response.sendRedirect("/home");
         }
         else
         {
             request.setAttribute("user_name", user_name);
             request.setAttribute("user_password", user_password);
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
             return;
         }
         
        
        
        
    }

   

}
