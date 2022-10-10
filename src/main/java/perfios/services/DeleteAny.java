package perfios.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import perfios.functionality.Close;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/DeleteAny")
public class DeleteAny extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//HttpSession session = request.getSession();
		//String accno = (String) session.getAttribute("acc");
		
		String accno = request.getParameter("accno");
		
		Close c = new Close();
		
		try {
				if(c.close(accno)) {
				RequestDispatcher rd = request.getRequestDispatcher("delacc.jsp");
				rd.include(request, response);	
				out.println("<center><font color = green> Account Deletion Successful.");
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("delacc.jsp");
					rd.include(request, response);	
					out.println("<center><font color = red> Account Number does not exist");
				}
			
					
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

}
