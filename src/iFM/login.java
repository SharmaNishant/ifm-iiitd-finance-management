/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iFM;

import iFM.Model.Users;

import java.io.IOException;

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
public class login extends HttpServlet {
	
	protected boolean mailTest()
	{
		return true;
	}

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		
    		String mail = request.getParameter("mail");
    		if(mail.isEmpty())
    		{
				request.getRequestDispatcher("index.html").forward(request, response);
				return;
    		}
			Entity user = Users.getProfile(mail);
    		if( user != null) {
    			String pass = request.getParameter("pass");
    			if(pass.isEmpty())
    			{
    				request.getRequestDispatcher("index.html").forward(request, response);
    			}
    			String u_pass = Users.getPassword(mail);
    			if(u_pass.equals(pass))
    			{
    				request.setAttribute("user", user);
    				//Entity profile = Users
    				//request.setAttribute("profile", profile);
    				if(Users.getVerified(mail))
    					request.getRequestDispatcher("profile.jsp").forward(request, response);
    				else
    					request.getRequestDispatcher("index.html").forward(request, response);
    			}
    			else
    			{
    				request.getRequestDispatcher("index.html").forward(request, response);
    			}
    		}
    		else {
    			System.out.println("User Not Found");
    			request.getRequestDispatcher("index.html").forward(request, response);
    		}
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
