package perfios.functionality;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import perfios.pojo.Services;
import perfios.pojo.Util;

public class WithdrawAmt {
	Services s = new Services();
	public double withdrawamt(String accno, double amt) throws SQLException {
		double dat_amt = s.getAmt(accno); 
		try{   
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			Date date = new Date();  
			String dt = formatter.format(date);
			String tran_type = "Debit";
        	String tran_id = Services.tran_id_generator();
	        double with_amt;
	      	with_amt = dat_amt-amt;
            Statement st = Util.getStatement();
            String sql1 = "update perfiosdata set amt ='"+with_amt+"' where accno = "+accno+" ";		
	  		st.executeUpdate(sql1);
      		String sql2 = "insert into transaction_history values("+ amt +",'" + tran_type +"', '" + tran_id + "', '"+ dt +"', '"+accno+"' )";
      		st.executeUpdate(sql2);
      		return with_amt;
	        }
	    catch (Exception e){
	            e.printStackTrace();
	            return 0;
	        }
	}

}
