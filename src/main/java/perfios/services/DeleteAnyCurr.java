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
@WebServlet("/DeleteAnyCurr")
public class DeleteAnyCurr extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//HttpSession session = request.getSession();
		//String accno = (String) session.getAttribute("acc");
		String accno = request.getParameter("accno");
		String type = request.getParameter("type");
		
		Services s1 = new Services();
		
		try {
				if(s1.closeCurr(accno,type)) {
				RequestDispatcher rd = request.getRequestDispatcher("delfor.jsp");
				rd.include(request, response);	
				out.println("<center><font color = green> Currency Deletion Successful.");
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("delfor.jsp");
					rd.include(request, response);	
					out.println("<center><font color = red> Currency with entered details not found");
				}
			
					
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

}
