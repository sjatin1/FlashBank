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

import perfios.functionality.INRExchange;
import perfios.pojo.Services;

/**
 * Servlet implementation class Exchange
 */
@WebServlet("/InrExchange")
public class InrExchange extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String accno = (String) session.getAttribute("acc");
		String type = request.getParameter("cur_type");
		String amt = request.getParameter("amt");
		double amount = Double.parseDouble(amt);
		double res=0;
		Services s = new Services();
		INRExchange i = new INRExchange();
		try {
		if(s.balCheckForType(type, amount)) {
			if(s.balCheckForCurr(type, amount)) {
				
							if(type.equals("USD")) {
								res=amount*81.45;
							}
							else if(type.equals("EUR")) {
								res=amount*79.21;
							}
							else if(type.equals("GBP")) {
								res=88.56*amount;
							}
							else if(type.equals("AED")) {
								res=22.17*amount;
							}
							
							else if(type.equals("JPY")) {
								
								res=amount*0.56;
							
							}
							else if(type.equals("AUD")) {
								
								res=52.83*amount;
							
							}
							else if(type.equals("CAD")) {
								
								res=59.65*amount;
							
							}
							else if(type.equals("CHF")) {
								
								res=amount*83.33;
							
							}
							else if(type.equals("CNY")) {
								
								res=11.45*amount;
							
							}
							else if(type.equals("SEK")) {
								
								res=7.23*amount;
							
							}
							else if(type.equals("MXN")) {
								
								res=amount*4.05;
							
							}
							else if(type.equals("NZD")) {
								
								res=46.49*amount;
							
							}
							else if(type.equals("SGD")) {
								
								res=56.86*amount;
							
							}
							else if(type.equals("HKD")) {
								
								res=amount*10.41;
							
							}
							else if(type.equals("NOK")) {
								
								res=7.58*amount;
							
							}
							else if(type.equals("KRW")) {
								
								res=0.057*amount;
							
							}
							else if(type.equals("TRY")) {
								
								res=amount*4.41;
							
							}
							else if(type.equals("RUB")) {
								
								res=1.43	*amount;
							
							}
							else if(type.equals("BRL")) {
								
								res=15.20*amount;
							
							}
							else if(type.equals("ZAR")) {
								
								res=amount*4.55;
							
							}
							else if(type.equals("DKK")) {
								
								res=10.67*amount;
							
							}
							else if(type.equals("PLN")) {
								
								res=16.34*amount;
							
							}
							else if(type.equals("TWD")) {
								
								res=amount*2.58;
							
							}
							else if(type.equals("THB")) {
								
								res=2.15*amount;
							
							}
							else if(type.equals("MYR")) {
								
								res=17.58*amount;
							
							}
							i.exchangetoinr(accno, res, amount, type);
							RequestDispatcher rd = request.getRequestDispatcher("inrexchange.jsp");
							rd.include(request, response);
							out.println("<center><font color = green> Currency Exchange Successful.</font></center>");
							}
			
			else {
				RequestDispatcher rd = request.getRequestDispatcher("inrexchange.jsp");
				rd.include(request, response);
				out.println("<center><font color = red>Insufficient Balance</font></center>");
			}
		}	
		
		else {
			RequestDispatcher rd = request.getRequestDispatcher("inrexchange.jsp");
			rd.include(request, response);
			out.println("<center><font color = red>Requested Currency type not found in your account</font></center>");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
