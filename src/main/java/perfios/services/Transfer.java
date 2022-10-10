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

import perfios.functionality.TransferAmt;
import perfios.pojo.Services;

/**
 * Servlet implementation class Transfer
 */
@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String accno = (String) session.getAttribute("acc");
		//String accno = request.getParameter("accno");
		String taccno = request.getParameter("taccno");
		String amt = request.getParameter("amt");
		
		int finamt = Integer.parseInt(amt);
		
		Services s1 = new Services();
		TransferAmt t = new TransferAmt();
		
		try {
			if(s1.balCheck(accno,finamt)) {
				double up_amt=t.transfer(accno,taccno, finamt);
				if(taccno.equals(accno)) {
					RequestDispatcher rd = request.getRequestDispatcher("transfer.jsp");
					rd.include(request, response);
					out.println("<center> Accno and Target Accno can not be same<br> ");
				}
				else {
					response.sendRedirect("transfer.jsp");
//				response.sendRedirect("https://www.google.com/");
				}
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("transfer.jsp");
				rd.include(request, response);
				out.println("");
				out.println("<center><font color = red> Insufficient Balance </font></center>");
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	}


