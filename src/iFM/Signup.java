/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iFM;

import iFM.Model.Users.Users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author Nishant Sharma
 */
@SuppressWarnings("serial")
public class Signup extends HttpServlet {

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

    	String fname=request.getParameter("firstname");
    	String lname=request.getParameter("lastname");
    	String mail=request.getParameter("email");
    	String phone=request.getParameter("phone");
    	String add1=request.getParameter("address1");
    	String add2=request.getParameter("address2");
    	String city=request.getParameter("city");
    	String state=request.getParameter("state");
    	String coun=request.getParameter("country");
    	String zip=request.getParameter("zip");	
    	String role=request.getParameter("role");
    	//Entity user = Users.getProfile(mail);
//    	if()
    	mail=mail.toLowerCase();
    	if(!mail.contains("@iiitd.ac.in"))
    	{
    		request.getRequestDispatcher("sign_up.html").forward(request, response);
    		return;
    	}
    	String cancel= request.getParameter("cancel");
    	if(cancel != null)
    	{
    		request.getRequestDispatcher("index.html").forward(request, response);
    		return;    		
    	}
    	
    	if(!Users.checkExistingUser(mail) && !(fname.isEmpty() || lname.isEmpty() || mail.isEmpty() || phone.isEmpty() || add1.isEmpty() || city.isEmpty() || state.isEmpty() || coun.isEmpty() || zip.isEmpty() || role.isEmpty()))
    	{
    		String name=fname+" "+lname;
    		String add=add1+", "+add2+", "+city+", "+state+", "+coun+", "+zip;
    		String[] signup_info = {name,mail,phone,add,role};
    		request.setAttribute("signup_info", signup_info);
    		if(role.equals("STU"))
    		{
    			request.getRequestDispatcher("sign_up_stu.jsp").forward(request, response);
    		}
    		else if(role.equals("FAC"))
    		{
    			request.getRequestDispatcher("sign_up_fac.jsp").forward(request, response);
    		}
    		else if(role.equals("STA"))
    		{
    			request.getRequestDispatcher("sign_up_staff.jsp").forward(request, response);
    		}
    		else
    		{
    			request.getRequestDispatcher("sign_up.html").forward(request, response);
    		}
    	}
    	else
    	{
    		request.getRequestDispatcher("sign_up.html").forward(request, response);
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
