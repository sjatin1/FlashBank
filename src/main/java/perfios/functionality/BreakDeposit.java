package perfios.functionality;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Statement;

import perfios.pojo.Services;
import perfios.pojo.Util;

public class BreakDeposit {
	Services s = new Services();
	public boolean breakDeposit(String accno,String fd_name) throws RemoteException, SQLException {
		double dat_amt = s.getAmt(accno);
		double fd_amt = s.getFdAmt(accno);
		try{   
	            	double dep_amt;
	            	dep_amt = dat_amt+fd_amt;
		            Statement st = Util.getStatement();
	        		String sql1 = "update perfiosdata set amt ='"+dep_amt+"' where accno = "+accno+" ";	
	        		st.executeUpdate(sql1);
	        		String sql2 = "delete from fixeddeposit where fd_name = '"+fd_name+"' ";	
	    			int i = st.executeUpdate(sql2);
	        		if(i!=1) {
	        			return false;
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
