/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iFM;

import iFM.Model.Users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;
/**
 *
 * @author Nishant Sharma
 */
@SuppressWarnings("serial")
public class NewUser extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String token=request.getParameter("uid");
        Entity user = Users.getProfileByToken(token);
        if(( user != null))
        {
        	Users.setVerified(user.getProperty("Email").toString());
        	request.setAttribute("user", user);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>New User Verification</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Your Account with username "+user.getProperty("Email") +" at IIITD Finance Managment has been verified </h1><br>");
            out.println("<a href=\"http://iiitdfm.appspot.com\">Click Here</a> to login into IIITD Finance Managment.<br>");
            out.println("</body>");
            out.println("</html>");       
        	//request.getRequestDispatcher("profile.jsp").forward(request, response);
            out.close();
        }
        else
        {
        	out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>New User Verification</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Sorry!!! Account Not Found.</h1><br>");
            out.println("<a href=\"http://iiitdfm.appspot.com/sign_up.html\">Click Here</a> to Sign Up into IIITD Finance Managment.<br>");
            out.println("</body>");
            out.println("</html>");
        	//request.getRequestDispatcher("sign_up.html").forward(request, response);
            out.close();
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
        try {
			processRequest(request, response);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
        try {
			processRequest(request, response);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
