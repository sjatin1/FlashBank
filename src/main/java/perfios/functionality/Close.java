package perfios.functionality;

import java.rmi.RemoteException;
import java.sql.Statement;

import perfios.pojo.Util;

public class Close {
	
	public boolean close(String accno) throws RemoteException {
		 try {
	        	Statement st = Util.getStatement();
	        	String sql1 = "delete from fixeddeposit where accno='"+accno+"'";	
	    		st.executeUpdate(sql1);
	    		String sql2 = "delete from foreign_exchange where accno='"+accno+"'";	
	    		st.executeUpdate(sql2);
	    		String sql3 = "delete from transaction_history where accno='"+accno+"'";	
	    		st.executeUpdate(sql3);
	    		String sql4 = "delete from perfiosdata where accno='"+accno+"'";	
	    		int i= st.executeUpdate(sql4);
	    		if(i!=1) {
       			return false;
       		}
       		else {
       		return true;
       		}
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 return false;
	}

}
