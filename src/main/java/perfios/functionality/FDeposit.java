package perfios.functionality;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import perfios.pojo.Services;
import perfios.pojo.Util;

public class FDeposit {
	
	Services s = new Services();
	
	public boolean fDeposit(String accno, double amt, String fd_name) throws RemoteException, SQLException, SQLIntegrityConstraintViolationException {
		double dat_amt = s.getAmt(accno); 
			try{   
					SimpleDateFormat formatter = new SimpleDateFormat("YYY-MM-dd");  
					Date date = new Date();  
					String dt = formatter.format(date);
					//System.out.println(dt);
	            	double dep_amt;
	            	dep_amt = dat_amt-amt;
		            Statement st = Util.getStatement();
	        		String sql1 = "update perfiosdata set amt ='"+dep_amt+"' where accno = "+accno+" ";	
	        		st.executeUpdate(sql1);
	        		String sql2 = "insert into fixeddeposit values("+ accno +",'" + fd_name +"', '" + amt + "', '" + dt + "')";	
	    			int i = st.executeUpdate(sql2);
	    			
	    			if(i!=1) {
	    				throw new SQLIntegrityConstraintViolationException();
	    			}
	    			else {
	    				return true;
	    			}
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
			return false;
	}

}
