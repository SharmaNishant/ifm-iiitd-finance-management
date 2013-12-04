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
    		
    		mail=mail.split("@iiitd.ac.in")[0];
    		mail=mail+"@iiitd.ac.in";
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

    		    	ArrayList<Entity> tran = Transactions.getAllTransactions(mail);
    		    	ArrayList<String> top5 = Transactions.getLatest5Transactions(mail);
    		    	request.setAttribute("all_trans", tran);
    		    	request.setAttribute("notify", top5);
    				
    		    	if(Users.getVerified(mail)){
    					Cookie cook = new Cookie("mail",mail);
    					cook.setMaxAge(30*60);
    					cook.setPath("/");
    					response.addCookie(cook);
    					request.getRequestDispatcher("profile.jsp").forward(request, response);
    				}
    			
    				else
    					request.getRequestDispatcher("index.html").forward(request, response);
    			}
    			else
    			{
    				request.getRequestDispatcher("index.html").forward(request, response);
    			}
    		}
    		else {
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
