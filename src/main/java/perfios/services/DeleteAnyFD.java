package perfios.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import perfios.pojo.Services;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/DeleteAnyFD")
public class DeleteAnyFD extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//HttpSession session = request.getSession();
		//String accno = (String) session.getAttribute("acc");
		
		String fd_name = request.getParameter("fd_name");
		
		Services s1 = new Services();
		
		try {
				if(s1.closefd(fd_name)) {
				RequestDispatcher rd = request.getRequestDispatcher("delfd.jsp");
				rd.include(request, response);	
				out.println("<center><font color = green> FD Deletion Successful.");
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("delfd.jsp");
					rd.include(request, response);	
					out.println("<center><font color = red> fd_name does not exist");
				}
			
					
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

}
