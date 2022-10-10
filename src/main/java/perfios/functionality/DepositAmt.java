package perfios.functionality;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import perfios.pojo.Services;
import perfios.pojo.Util;

public class DepositAmt {
	Services s = new Services();
	public double deposit(String accno, double amt) throws RemoteException, SQLException {
		double dat_amt = s.getAmt(accno); 
		try{   
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
					Date date = new Date();  
					String dt = formatter.format(date);
					String tran_type = "Credit";
	            	String tran_id = Services.tran_id_generator();
	            	double dep_amt;
	            	dep_amt = dat_amt+amt;
		            Statement st = Util.getStatement();
	        		String sql1 = "update perfiosdata set amt ='"+dep_amt+"' where accno = "+accno+" ";		
	        		st.executeUpdate(sql1);
	        		String sql2 = "insert into transaction_history values("+ amt +",'" + tran_type +"', '" + tran_id + "', '"+ dt +"', '"+accno+"'  )";
	        		st.executeUpdate(sql2);
	        		return dep_amt;
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
		return 0;
	}

}
