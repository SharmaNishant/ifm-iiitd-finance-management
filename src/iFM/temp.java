package iFM;

import iFM.Model.Users;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class temp extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		@SuppressWarnings("unchecked")
		ArrayList<String> old_data=(ArrayList<String>) request.getAttribute("old_data");
		System.out.println(old_data.size());
		if(old_data.get(4).equals("STU"))
		{
			String roll_no=request.getParameter("roll");
			String stream=request.getParameter("stream");
			String password=request.getParameter("password");
			String pass_con=request.getParameter("password_confirm");
			if(!(roll_no.isEmpty() || stream.isEmpty() || password.isEmpty() || pass_con.isEmpty()))
			{
				if(password.equals(pass_con))
				{
					Users.addUser(old_data.get(0), old_data.get(1), password, roll_no, old_data.get(2), old_data.get(3), old_data.get(4), "Student");
					request.getRequestDispatcher("thankyou.html").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("sign_up_stu.jsp").forward(request, response);
				}
			}
			else
			{
				request.getRequestDispatcher("sign_up_stu.jsp").forward(request, response);
			}
		}
		else if(old_data.get(4).equals("STA"))
		{
			String emp_id=request.getParameter("empid");
			String designation=request.getParameter("designation");
			String password=request.getParameter("password");
			String pass_con=request.getParameter("password_confirm");
			if(!(emp_id.isEmpty() || designation.isEmpty() || password.isEmpty() || pass_con.isEmpty()))
			{
				if(password.equals(pass_con))
				{
					Users.addUser(old_data.get(0), old_data.get(1), password, emp_id, old_data.get(2), old_data.get(3), old_data.get(4), designation);
					request.getRequestDispatcher("thankyou.html").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("sign_up_staff.jsp").forward(request, response);
				}
			}
			else
			{
				request.getRequestDispatcher("sign_up_staff.jsp").forward(request, response);
			}
		}
		else if(old_data.get(4).equals("FAC"))
		{
			String empid=request.getParameter("roll");
			String dept=request.getParameter("dept");
			String password=request.getParameter("password");
			String pass_con=request.getParameter("password_confirm");
			if(!(empid.isEmpty() || dept.isEmpty() || password.isEmpty() || pass_con.isEmpty()))
			{
				if(password.equals(pass_con))
				{
					Users.addUser(old_data.get(0), old_data.get(1), password, empid, old_data.get(2), old_data.get(3), old_data.get(4), dept);
					request.getRequestDispatcher("thankyou.html").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("sign_up_fac.jsp").forward(request, response);
				}
			}
			else
			{
				request.getRequestDispatcher("sign_up_fac.jsp").forward(request, response);
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
