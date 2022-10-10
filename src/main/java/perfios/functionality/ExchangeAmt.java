package perfios.functionality;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Statement;

import perfios.pojo.Services;
import perfios.pojo.Util;

public class ExchangeAmt {
	Services s = new Services();
	
	public double exchangeamt(String accno, double res, double amt, String type) throws RemoteException, SQLException {
		double dat_amt = s.getAmt(accno);
		//System.out.println(dat_type);
		double dat_curr = s.getCurr(type);
		double tax = amt*0.25/100;
		double newamt = amt+tax;
		 double ex_amt = dat_amt-newamt;
		
		 try {
			 Statement st = Util.getStatement();
			
			 double for_amt = dat_curr+res;
			 String sql = "update perfiosdata set amt = '" +ex_amt+ "'where accno = '"+accno+"' ";
			 st.executeUpdate(sql);
			 String sql1 = "update foreign_exchange set foreign_currency = '" +for_amt+ "'where currency_type = '"+type+"'";	
			 int i = st.executeUpdate(sql1);
			 
			if(i!=1) {		
			String sql2 = "insert into foreign_exchange values("+ accno +",'" + type +"', '" + res + "')";	
			st.executeUpdate(sql2);
			 }
			
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 return tax;
	}

}
