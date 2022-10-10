package perfios.functionality;

import java.sql.SQLException;
import java.sql.Statement;

import perfios.pojo.Services;
import perfios.pojo.Util;

public class INRExchange {
	Services s = new Services();
	public double exchangetoinr(String accno, double res, double amt, String type) throws SQLException {
		double dat_amt = s.getAmtInr(type,accno);
		//String dat_type = getType(accno);
		//System.out.println(dat_type);
		double dat_curr = s.getAmt(accno);
		
		 try {
			 Statement st = Util.getStatement();
			 double ex_amt = dat_amt-amt;
			 double inr_amt = dat_curr+res;
			 int i =0;
			 if(ex_amt>0) {
			 String sql = "update foreign_exchange set foreign_currency = '" +ex_amt+ "'where accno = '"+accno+"' and currency_type = '"+type+"' ";
			 i = st.executeUpdate(sql);
			 }
			 if(i==1) {
				 String sql1 = "update perfiosdata set amt = '" +inr_amt+ "'where accno = '"+accno+"'";	
				 st.executeUpdate(sql1);
			 }
			 return inr_amt;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 return 0;
		 
	}

}
