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

import perfios.functionality.ExchangeAmt;
import perfios.pojo.Services;

/**
 * Servlet implementation class Exchange
 */
@WebServlet("/Exchange")
public class Exchange extends HttpServlet {
	
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
		double rem_amt=0;
		Services s = new Services();
		ExchangeAmt e = new ExchangeAmt();
		try {
		if(s.balCheck(accno, amount)) {
			if(type.equals("USD")) {
				type="USD";
				res=0.012*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("EUR")) {
				type="EUR";
				res=0.013*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("GBP")) {
				type="GBP";
				res=0.011*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("AED")) {
				type="AED";
				res=0.045*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("JPY")) {
				type="JPY";
				res=1.77*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("CAD")) {
				type="CAD";
				res=0.017*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("CNY")) {
				type="CNY";
				res=0.087*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("AUD")) {
				type="AUD";
				res=0.019*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("CHF")) {
				type="CHF";
				res=0.012*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("SEK")) {
				type="SEK";
				res=0.14*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("MXN")) {
				type="MXN";
				res=0.25*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("NZD")) {
				type="NZD";
				res=0.022*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("SGD")) {
				type="SGD";
				res=0.018*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("HKD")) {
				type="HKD";
				res=0.096*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("NOK")) {
				type="NOK";
				res=0.13*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("KRW")) {
				type="KRW";
				res=17.52*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("TRY")) {
				type="TRY";
				res=0.23*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("RUB")) {
				type="RUB";
				res=0.70*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("BRL")) {
				type="BRL";
				res=0.066*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("ZAR")) {
				type="ZAR";
				res=0.22*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("DKK")) {
				type="DKK";
				res=0.094*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("PLN")) {
				type="PLN";
				res=0.061*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("TWD")) {
				type="TWD";
				res=0.39*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("THB")) {
				type="THB";
				res=0.47*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			else if(type.equals("MYR")) {
				type="MYR";
				res=0.057*amount;
				rem_amt = e.exchangeamt(accno, res,amount,type);
			}
			RequestDispatcher rd = request.getRequestDispatcher("exchange.jsp");
			rd.include(request, response);
			out.println("<center><font color = green> Currency Exchange Successful. Tax amt : " + rem_amt+" inr </font></center>");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("exchange.jsp");
			rd.include(request, response);
			out.println("<center><font color = red> Insufficient Balance</font></center>");
		}
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}

}
