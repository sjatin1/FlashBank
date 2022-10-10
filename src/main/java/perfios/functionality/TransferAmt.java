package perfios.functionality;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import perfios.pojo.Services;
import perfios.pojo.Util;

public class TransferAmt {
	Services s = new Services();
	
	public double transfer(String accno, String tarAccno, double amt) throws RemoteException, SQLException {
		double dat1_amt = s.getAmt(accno); 
		double dat2_amt = s.getAmt(tarAccno); 
		try{   
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			Date date = new Date();  
			String dt = formatter.format(date);
			String tran_type = "Debit";
        	String tran_id = Services.tran_id_generator();
	            	double tran_amt,rec_amt;
	            	tran_amt = dat1_amt-amt;
	            	rec_amt = dat2_amt+amt;
		            Statement st = Util.getStatement();
	        		String sql1 = "update perfiosdata set amt ='"+tran_amt+"' where accno = "+accno+" ";		
	        		st.executeUpdate(sql1);
	        		String sql2 = "update perfiosdata set amt ='"+rec_amt+"' where accno = "+tarAccno+" ";		
	        		st.executeUpdate(sql2);
	        		String sql3 = "insert into transaction_history values("+ amt +",'" + tran_type +"', '" + tran_id + "', '"+ dt +"', '"+accno+"'  )";
	        		st.executeUpdate(sql3);
	        		return tran_amt;
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
		return -1;
	}

}
