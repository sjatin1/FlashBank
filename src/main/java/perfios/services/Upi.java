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

import perfios.functionality.UPITransfer;
import perfios.pojo.Services;

/**
 * Servlet implementation class Upi
 */
@WebServlet("/Upi")
public class Upi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String accno = (String) session.getAttribute("acc");
		//String accno = request.getParameter("accno");
		String upi_id = request.getParameter("upi_id");
		String tUpi_id = request.getParameter("tarUpi_id");
	
		String amt = request.getParameter("amt");
		
		int finamt = Integer.parseInt(amt);
		
		Services s1 = new Services();
		UPITransfer u = new UPITransfer();
		
		try {
			if(s1.balCheckUpi(accno,upi_id,finamt)) {
				double up_amt=u.upi(accno, upi_id, tUpi_id, finamt);
				if(tUpi_id.equals(upi_id)) {
					RequestDispatcher rd = request.getRequestDispatcher("upi.jsp");
					rd.include(request, response);
					out.println("<center><font color = red> Upi ID and Target Upi ID can not be same<br> ");
				}
				else {
					if(up_amt!= -1) {
						response.sendRedirect("upi.jsp");
//				response.sendRedirect("https://www.google.com/");
					}
					else {
						RequestDispatcher rd = request.getRequestDispatcher("upi.jsp");
						rd.include(request, response);
						out.println("<center><font color = red> NO Target Upi ID Found <br> ");
					}
				}
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("upi.jsp");
				rd.include(request, response);
				out.println("");
				out.println("<center><font color = red> UPI ID Not Found </font></center>");
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}

}
