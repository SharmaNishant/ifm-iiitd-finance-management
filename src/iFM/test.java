package iFM;

import iFM.Model.Users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class test extends HttpServlet {
	
	List<String> test=new ArrayList<String>();  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	Users.addUser("Rishav Jain", "rishav11088@iiitd.ac.in", "rishav", "BT2011088", "", "", "", "");
    	Users.addUser("Nishant Sharma", "nishant11070@iiitd.ac.in", "nishant", "BT2011070", "", "", "", "");
    	Users.addUser("Mayank Garg", "mayank11065@iiitd.ac.in", "mayank", "BT2011065", "", "", "", "");
    	
    	test.add("Sample Users Added");
    	
    	response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>"+"Servlet test"+"</title>");            
            out.println("</head>");
            out.println("<body>");
            for(int i = 0; i < test.size(); i++) {   
                out.println(test.get(i)+"<br>");
            }  
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

}
