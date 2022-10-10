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

import perfios.functionality.DepositAmt;
import perfios.pojo.Services;

/**
 * Servlet implementation class Deposit
 */
@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String accno = (String) session.getAttribute("acc");
		String amt = request.getParameter("amt");
		
		int finamt = Integer.parseInt(amt);
		
		Services s1 = new Services();
		DepositAmt d = new DepositAmt();
		
		try {
			if(s1.accnoCheck(accno)) {
				d.deposit(accno, finamt);
				response.sendRedirect("deposit.jsp");
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
				rd.include(request, response);
				out.println("<center><font color = red> Please Login first </font> <a href = 'login.jsp'> login here </a></center>");
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
}

