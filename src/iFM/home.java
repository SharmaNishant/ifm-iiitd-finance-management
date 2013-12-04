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

@SuppressWarnings("serial")
public class home extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	boolean flag=false;
    	String name = "";
    	{
    		Cookie[] cookies = request.getCookies();
    		if(cookies !=null){
    			for(Cookie cookie : cookies){
    				if(cookie.getName().equals("mail"))
    				{
    					name = cookie.getValue();
    					if(name.equals(""))
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
    	
    	
    	
    	if(flag==true)
    	{	    
    	String mail=name;//request.getParameter("mail");

    	ArrayList<Entity> tran = Transactions.getAllTransactions(mail);
    	ArrayList<String> top5 = Transactions.getLatest5Transactions(mail);
    	request.setAttribute("all_trans", tran);
    	request.setAttribute("notify", top5);
    	Entity user = Users.getProfile(mail);
    	request.setAttribute("profile", user);
    	request.getRequestDispatcher("sign_in_normal.jsp").forward(request, response);
    	}
    	else
    	{
        		request.getRequestDispatcher("index.html").forward(request, response);
    	}
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
