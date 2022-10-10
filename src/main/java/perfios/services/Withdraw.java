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

import perfios.functionality.WithdrawAmt;
import perfios.pojo.Services;



@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String accno = (String) session.getAttribute("acc");
		//String accno = request.getParameter("accno");
		String amt = request.getParameter("amt");
		
		double finamt = Double.parseDouble(amt);
		Services s1 = new Services();
		
		
		try {
			if(s1.balCheck(accno,finamt)) {
				WithdrawAmt w = new WithdrawAmt();
				w.withdrawamt(accno, finamt);
				//session.setAttribute("helloWorld", "Hello world");
				response.sendRedirect("withdraw.jsp");
			
			}
			else {
				
				RequestDispatcher rd = request.getRequestDispatcher("withdraw.jsp");
				rd.include(request, response);
				out.println("<center><font color = red> Insufficient Balance </font></center>");
			
			}
			//
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

}
