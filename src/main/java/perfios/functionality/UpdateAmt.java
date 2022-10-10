package perfios.functionality;

import java.rmi.RemoteException;
import java.sql.Statement;

import perfios.pojo.Util;

public class UpdateAmt {
	
	public boolean update(String type, String accno, String data) throws RemoteException {
		 try {
	        	Statement st = Util.getStatement();
	    		String sql = "update perfiosdata set "+type+ "='" +data+ "'where accno = '"+accno+"' ";	
	    		int i = st.executeUpdate(sql);
	    		if(type.equals("pwd")) {
	    			String sql1 = "update perfiosdata set cpwd ='" +data+ "'where accno = '"+accno+"' ";	
		    		st.executeUpdate(sql1);
	    		}
	    		if(i!=1) {
	    			return false;
	    		}
	    		else {
	    			return true;
	    		}
	        } catch (Exception e) {
	            e.printStackTrace();
	            return true;
	        }
	}

}
