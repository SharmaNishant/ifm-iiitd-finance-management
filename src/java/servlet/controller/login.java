/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Nishant
 */
public class login extends HttpServlet {
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            String mail = request.getParameter("email");
            String pass = request.getParameter("pass");
            String result = servlet.model.login.getPassword(mail);
            //response.addCookie(null);
            if(pass.equals(result))
            {
                request.setAttribute("mail", mail);
                request.getRequestDispatcher("/IFM/dist/profile.jsp").forward(request, response);
            }
            
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
