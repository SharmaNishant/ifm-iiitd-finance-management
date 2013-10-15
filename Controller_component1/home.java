package iFM;

import iFM.Model.Users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class home extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
	
    
    	String mail=request.getParameter("mail");
    	Entity user = Users.getProfile(mail);
    	request.setAttribute("profile", user);
    	request.getRequestDispatcher("sign_in_normal.jsp").forward(request, response);
            
    }
    
	
	
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }	   
}
