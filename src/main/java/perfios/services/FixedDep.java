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

import perfios.functionality.FDeposit;
import perfios.pojo.Services;

/**
 * Servlet implementation class FixedDep
 */
@WebServlet("/FixedDep")
public class FixedDep extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String accno = (String) session.getAttribute("acc");
		//String accno = request.getParameter("accno")
		String amt = request.getParameter("amt");
		String fd_name = request.getParameter("fd_name");
		int finamt = Integer.parseInt(amt);
		
		Services s1 = new Services();
		FDeposit f = new FDeposit();
		
		try {
			if(s1.accnoCheck(accno)) {
				if(s1.balCheck(accno, finamt)) {
					if(f.fDeposit(accno, finamt, fd_name)) {
						response.sendRedirect("Fixeddep.jsp");
//				response.sendRedirect("https://www.google.com/");
					}
					else {
						RequestDispatcher rd = request.getRequestDispatcher("Fixeddep.jsp");
						rd.include(request, response);
						out.println("<center><font color = red> FD with same name already exists </font></center>");
					}
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("Fixeddep.jsp");
					rd.include(request, response);
					out.println("<center><font color = red> Insufficient Balance </font></center>");
				}
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("Fixeddep.jsp");
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
