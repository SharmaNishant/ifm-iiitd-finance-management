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
 * @author Greg Bakos <greg@londonfreelancers.co.uk>
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mail= request.getParameter("mail");//.getAttribute("mail").toString();
        String mailcheck[] = servlet.model.login.getDetails(mail);
        if(mailcheck==null)
        {
            request.getRequestDispatcher("signin.jsp").forward(request, response);
        }
        String pass= request.getParameter("pass");
        String result = servlet.model.login.getPassword(mail);
        if(result.equals(pass))
        {
            String res[] = servlet.model.login.getDetails(mail);
            request.setAttribute("profile", res);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        }
        else
        {
            //System.out.println(request.getContextPath());
            //request.getServerPort();
            request.getRequestDispatcher("signin.jsp").forward(request, response);///.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
