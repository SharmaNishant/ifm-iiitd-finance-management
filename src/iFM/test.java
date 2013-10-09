package iFM;

import iFM.Model.Transactions;
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
        Users.addUser("Priyam Kumar", "priyam11083@iiitd.ac.in", "priyam", "BT2011083", "", "", "", "");
        Users.addUser("Saurabh Arya", "saurabh11100@iiitd.ac.in", "saurabh", "BT2011100", "", "", "", "");
        Users.addUser("Admin", "admin@iiitdfm.appspotmail.com", "admin", "ADMIN", "", "", "", "");
        
        String rishavToken = Users.getToken("rishav11088@iiitd.ac.in");
        String nishantToken = Users.getToken("nishant11070@iiitd.ac.in");
        String mayankToken = Users.getToken("mayank11065@iiitd.ac.in");
        String priyamToken = Users.getToken("priyam11083@iiitd.ac.in");
        String saurabhToken = Users.getToken("saurabh11100@iiitd.ac.in");
        String adminToken = Users.getToken("admin@iiitdfm.appspotmail.com");
        
        System.out.println(rishavToken);
        System.out.println(nishantToken);
        System.out.println(mayankToken);
        System.out.println(priyamToken);
        System.out.println(saurabhToken);
        System.out.println(adminToken);
        
        // Sample Transactions by PRIYAM 
        Transactions.addTransaction(rishavToken,adminToken,"50000","10/9/2013","Fees");
        Transactions.addTransaction(mayankToken,adminToken,"10000","9/9/2013","Fees");
        Transactions.addTransaction(nishantToken,adminToken,"34435","10/9/2013","Fees");
        Transactions.addTransaction(priyamToken,adminToken,"54534","5/9/2013","Fees");
        Transactions.addTransaction(saurabhToken,adminToken,"56454","8/9/2013","Fees"); 
        Transactions.addTransaction(adminToken,saurabhToken,"23443","1/9/2013","Fees"); 
        Transactions.addTransaction(adminToken,priyamToken,"34311","4/9/2013","Fees"); 
        Transactions.addTransaction(adminToken,mayankToken,"12312","11/9/2013","Fees"); 
        Transactions.addTransaction(adminToken,nishantToken,"78675","3/9/2013","Fees");
        Transactions.addTransaction(adminToken,rishavToken,"22325","8/9/2013","Fees");
        Transactions.addTransaction(adminToken,saurabhToken,"3434","5/9/2013","Internship Under Professor X"); 
        Transactions.addTransaction(adminToken,priyamToken,"4545","2/9/2013","Internship Under Professor Y"); 
        Transactions.addTransaction(adminToken,mayankToken,"4523","4/9/2013","Internship Under Professor Z"); 
        Transactions.addTransaction(adminToken,nishantToken,"7867","11/9/2013","Internship Under Professor Q");
        Transactions.addTransaction(adminToken,rishavToken,"8235","8/9/2013","Internship Under Professor P");
    	
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
