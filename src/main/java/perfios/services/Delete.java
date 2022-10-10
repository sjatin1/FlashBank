package perfios.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import perfios.functionality.Close;
import perfios.pojo.Services;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String accno = (String) session.getAttribute("acc");
		
		//String accno = request.getParameter("accno");
		
		Services s1 = new Services();
		Close c = new Close();
		
		try {
			if(s1.accnoCheck(accno)) {
				if(c.close(accno)) {
				response.sendRedirect("index.jsp");	
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
					rd.include(request, response);
					out.println("");
					out.println("<center><font color = red> Deletion Failed </font></center>");
				}
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
				rd.include(request, response);
				out.println("");
				out.println("<center><font color = red> Invalid accno </font></center>");
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

}
