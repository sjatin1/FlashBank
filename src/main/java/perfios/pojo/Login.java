package perfios.pojo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String pass = request.getParameter("pwd");
		String accno = Services.getAccno(user);
		
		Customer c1 = new Customer();
		c1.setUname(user);
		c1.setPwd(pass);
		
	//	UserDao.saveUser(u1);
		
		Statement st = Util.getStatement();
		String sql = "select uname,pwd from perfiosdata where uname='"+c1.getUname()+"' and pwd = '"+c1.getPwd()+"'";		
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) {
			if(user.equals("admin") && pass.equals("Java@1234")) {
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
			
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("acc", accno);
				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
				rd.forward(request, response);
				
			}
//			response.sendRedirect("https://www.google.com/");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
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
