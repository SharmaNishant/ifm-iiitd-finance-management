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
 * @author Greg Bakos <greg@londonfreelancers.co.uk>
 */
@SuppressWarnings("serial")
public class login extends HttpServlet {
	
	

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
    		String a[]={"1","1","1","1","1","1","1","1","1"};
    		request.setAttribute("profile", a);
    		
    		Entity user = Users.getProfile("rishav11088@iiitd.ac.in");
    		
    		if( user != null) {
    			System.out.println(user.getProperty("Name"));
    		
    			request.getRequestDispatcher("profile.jsp").forward(request, response);
    		}
    		else {
    			System.out.println("User Not Found");
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
