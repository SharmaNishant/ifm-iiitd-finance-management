package iFM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class Logout extends HttpServlet {
	
	public void processrequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	Cookie[] cookies = req.getCookies();
    	if(cookies !=null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("mail"));
    		{
                cookie.setValue("");
                cookie.setMaxAge(0);
                cookie.setPath("/");
                resp.addCookie(cookie);
                break;
    		}
    		
    		}
    	}
		/*HttpSession session = req.getSession();// .getSession(false);
		if (session != null) {
		    session.invalidate();
		}*/
		req.getRequestDispatcher("index.html").forward(req, resp);
		
		
	}
	
	
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		processrequest(req,resp);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		processrequest(req,resp);
	}
}
