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

import perfios.functionality.BreakDeposit;
import perfios.pojo.Services;

/**
 * Servlet implementation class Breakfd
 */
@WebServlet("/Breakfd")
public class Breakfd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String accno = (String) session.getAttribute("acc");
		
		String fd_name = request.getParameter("fd_name");
		
		Services s1 = new Services();
		BreakDeposit b = new BreakDeposit();
		
		try {
			if(s1.accnoCheck(accno)) {
				if(b.breakDeposit(accno,fd_name)) {
				RequestDispatcher rd = request.getRequestDispatcher("breakfd.jsp");
				rd.include(request, response);
				out.println("<center><font color = green> FD Break Successful</font></center>");
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("breakfd.jsp");
					rd.include(request, response);
					out.println("");
					out.println("<center><font color = red> FD Name Not Found </font></center>");
				}
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("breakfd.jsp");
				rd.include(request, response);
				out.println("");
				out.println("<center><font color = red> Invalid credentials </font></center>");
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

}
