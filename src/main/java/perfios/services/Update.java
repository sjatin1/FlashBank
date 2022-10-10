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

import perfios.functionality.UpdateAmt;
import perfios.pojo.Services;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String accno = (String) session.getAttribute("acc");
		//String accno = request.getParameter("accno");
		String type = request.getParameter("dat_type");
		String data = request.getParameter("data");
		
		Services s1 = new Services();
		UpdateAmt u = new UpdateAmt();
		
		try {
			if(s1.accnoCheck(accno)) {
				u.update(type,accno,data);
				RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
				rd.include(request, response);
				out.println("<center><font color = green> Updation Successful </font></center>");
//				response.sendRedirect("https://www.google.com/");
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
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
