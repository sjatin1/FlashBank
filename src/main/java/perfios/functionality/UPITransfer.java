package perfios.functionality;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import perfios.pojo.Services;
import perfios.pojo.Util;

public class UPITransfer {
	Services s = new Services();
	public double upi(String accno, String upi_id, String tarUpi_id, double amt) throws RemoteException, SQLException {
		// TODO Auto-generated method stub
		double database_amt1 = s.getAmtUpi(upi_id);
		double database_amt2 = s.getAmtUpi(tarUpi_id);
		try{   
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			Date date = new Date();  
			String dt = formatter.format(date);
			String tran_type = "Debit";
        	String tran_id = Services.tran_id_generator();
        	double tran_amt,rec_amt;
        	tran_amt = database_amt1-amt;
        	rec_amt = database_amt2+amt;
            Statement st = Util.getStatement();
            String sql2 = "update perfiosdata set amt ='"+rec_amt+"' where upi_id = '"+tarUpi_id+"' ";		
    		int i = st.executeUpdate(sql2);
    		
    		if(i==1) {
    		String sql1 = "update perfiosdata set amt ='"+tran_amt+"' where upi_id = '"+upi_id+"' ";		
    		st.executeUpdate(sql1);
    		String sql3 = "insert into transaction_history values("+ amt +",'" + tran_type +"', '" + tran_id + "', '"+ dt +"', '"+accno+"'  )";
    		st.executeUpdate(sql3);
    		return tran_amt;
    		}
    		
    		
    		return -1;
    }
    catch (Exception e){
        e.printStackTrace();
    }
return -1;
		
}

}
