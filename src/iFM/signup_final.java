package iFM;

import iFM.Model.Users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class signup_final extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String name=request.getParameter("name");
		String mail=request.getParameter("mail");
		String phone=request.getParameter("phone");
		String add=request.getParameter("add");
		String role=request.getParameter("role");
			String terms = request.getParameter("terms");
		String[] old_data ={name,mail,phone,add,role};
		old_data[1]=old_data[1].split("@iiitd.ac.in")[0];
		old_data[1]=old_data[1]+"@iiitd.ac.in";
		if(role.equals("STU\r\n"))
		{
			String roll_no=request.getParameter("roll");
			String stream=request.getParameter("stream");
			String password=request.getParameter("password");
			String pass_con=request.getParameter("password_confirm");
			if(!(roll_no.isEmpty() || stream.isEmpty() || password.isEmpty() || pass_con.isEmpty()))
			{
				if(password.equals(pass_con) && password.length()>3 && "1".equals(terms))
				{
					//clean all the fields below here
					Users.addUser(old_data[0], old_data[1], password, roll_no, old_data[2], old_data[3], old_data[4], "Student");
					request.getRequestDispatcher("thankyou.html").forward(request, response);
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
		else if(role.equals("STA\r\n"))
		{
			String emp_id=request.getParameter("empid");
			String designation=request.getParameter("designation");
			String password=request.getParameter("password");
			String pass_con=request.getParameter("password_confirm");
			if(!(emp_id.isEmpty() || designation.isEmpty() || password.isEmpty() || pass_con.isEmpty()))
			{
				if(password.equals(pass_con) && password.length()>3)
				{
					//clean all the fields below here
					Users.addUser(old_data[0], old_data[1], password, emp_id, old_data[2], old_data[3], old_data[4], "Student");
					request.getRequestDispatcher("thankyou.html").forward(request, response);
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
		else if(role.equals("FAC\r\n"))
		{
			String empid=request.getParameter("empid");
			String dept=request.getParameter("dept");
			String password=request.getParameter("password");
			String pass_con=request.getParameter("password_confirm");
			if(!(empid.isEmpty() || dept.isEmpty() || password.isEmpty() || pass_con.isEmpty()))
			{
				if(password.equals(pass_con) && password.length()>3 )
				{
					//clean all the fields below here
					Users.addUser(old_data[0], old_data[1], password, empid, old_data[2], old_data[3], old_data[4], "Student");
					request.getRequestDispatcher("thankyou.html").forward(request, response);
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
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}
}
