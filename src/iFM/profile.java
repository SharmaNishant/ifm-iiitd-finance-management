/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iFM;

import iFM.Model.Users.Transactions;
import iFM.Model.Users.Users;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;

/**
 *
 * @author Greg Bakos <greg@londonfreelancers.co.uk>
 */
@SuppressWarnings("serial")
public class profile extends HttpServlet {

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
    	boolean flag=false; 
    	String userName = "";
    	{Cookie[] cookies = request.getCookies();
    	if(cookies !=null){
    	for(Cookie cookie : cookies){
    	    if(cookie.getName().equals("mail"))
    	    	{
    	    		userName = cookie.getValue();
    	    		if(userName.equals(""))
					{
						request.getRequestDispatcher("index.html").forward(request, response);
		    			return;
					}
    	    		flag=true;
    	    	}

    	}
    	}
    	else
    	{
    		request.getRequestDispatcher("index.html").forward(request, response);
    		return;
    	}


    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
    	response.setHeader("Pragma", "no-cache"); 
    	response.setDateHeader("Expires", 0); 
    	}
    	
    	if(flag==true){
    	String mail = userName;//request.getParameter("mail");
		Entity user = Users.getProfile(mail);
		request.setAttribute("user", user);
		
    	ArrayList<Entity> tran = Transactions.getAllTransactions(mail);
    	ArrayList<String> top5 = Transactions.getLatest5Transactions(mail);
    	request.setAttribute("all_trans", tran);
    	request.setAttribute("notify", top5);
		
		request.getRequestDispatcher("profile.jsp").forward(request, response);       
    	}
    	else
    	{
    		request.getRequestDispatcher("index.html").forward(request, response);
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
