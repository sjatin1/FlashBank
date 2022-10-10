package perfios.pojo;

import java.rmi.RemoteException;



import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.*;


public class Services{
	
	 public static String tran_id_generator() {
	        String uuid = UUID.randomUUID().toString();
	        uuid = uuid.replace("-", "");
	        return uuid;
	    }
   
    public boolean accnoCheck(String accno) throws SQLException{
    	try {
    	Statement st = Util.getStatement();
		String sql = "select * from perfiosdata where accno='"+accno+"'";		
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) {
			return true;
		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
        
        return false;
    }

    public static String getAccno(String user) throws SQLException{
    	
    	try {
    		Statement st = Util.getStatement();
    		String sql = "select * from perfiosdata where uname = '"+user+"' ";		
    		ResultSet rs = st.executeQuery(sql);
    		if(rs.next()) {
    		return rs.getString(1);}
	    }
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		return null;
    }
    public double getAmt(String accno){
        try {
        	Statement st = Util.getStatement();
    		String sql = "select * from perfiosdata where accno = '"+accno+"' ";		
    		ResultSet rs = st.executeQuery(sql);
    		if(!rs.next()) {
    			throw new SQLException("Result Set is empty");
    		}
    			else {
    		return rs.getDouble(9);}
        } catch (Exception e) {
            e.printStackTrace();
        }
		return -1;
    }
    public String getUname(String accno)throws SQLException {
        try {
        	Statement st = Util.getStatement();
    		String sql = "select * from perfiosdata where accno = '"+accno+"' ";		
    		ResultSet rs = st.executeQuery(sql);
    		if(rs.next()) {
    		return rs.getString(3);
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
    }
    public double getFdAmt(String accno)throws SQLException {
        try {
        	Statement st = Util.getStatement();
    		String sql = "select * from fixeddeposit where accno = '"+accno+"' ";		
    		ResultSet rs = st.executeQuery(sql);
    		if(rs.next()) {
    		return rs.getDouble(3);
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
		return -1;
    }
    
    
    public double getAmtInr(String type, String accno)throws SQLException {
        try {
        	Statement st = Util.getStatement();
    		String sql = "select * from foreign_exchange where currency_type = '"+type+"' and accno = '"+accno+"' ";		
    		ResultSet rs = st.executeQuery(sql);
    		if(rs.next()) {
    		return rs.getDouble(3);}
        } catch (Exception e) {
            e.printStackTrace();
        }
		return -1;
    }

    public boolean balCheck(String accno, double amt) throws SQLException{
        try {
        	Statement st = Util.getStatement();
    		String sql = "select * from perfiosdata where accno = '"+accno+"' ";		
    		ResultSet rs = st.executeQuery(sql);
    		if(rs.next()) {
    		double minamt = amt+100;
    		if(rs.getDouble(9)>=minamt) {
    		return true;
    		}
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
    }
    public boolean balCheckForType(String type, double amt) throws SQLException{
        try {
        	Statement st = Util.getStatement();
    		String sql = "select * from foreign_exchange where currency_type = '"+type+"' ";		
    		ResultSet rs = st.executeQuery(sql);
    		if(rs.next()) {
    		return true;
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
    }
    public boolean balCheckForCurr(String type, double amt) throws SQLException{
        try {
        	Statement st = Util.getStatement();
    		String sql = "select * from foreign_exchange where currency_type = '"+type+"' ";		
    		ResultSet rs = st.executeQuery(sql);
    		if(rs.next()) {
    		if(rs.getDouble(3)>=amt) {
    		return true;
    		}
    		
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
    }
    public double getAmtUpi(String upi_id) throws SQLException {
        try {
        	Statement st = Util.getStatement();
    		String sql = "select * from perfiosdata where upi_id = '"+upi_id+"' ";		
    		ResultSet rs = st.executeQuery(sql);
    		if(rs.next()) {
    		return rs.getDouble(9);
    		}
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
		
    public boolean balCheckUpi(String accno,String upi_id, double amt) throws SQLException {
        try {
        	Statement st = Util.getStatement();
    		String sql = "select * from perfiosdata where upi_id = '"+upi_id+"' ";		
    		ResultSet rs = st.executeQuery(sql);
    		double minamt = amt+100;
    		if(rs.next()) {
    		if(rs.getDouble(9)>=minamt) {
    		return true;
    		}
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
    }
	
	
	public String getType(String accno) throws SQLException {
		try {
			Statement st = Util.getStatement();
			String sql = "select * from foreign_exchange where accno = '"+accno+"' ";
			ResultSet rs = st.executeQuery(sql);
    		if(rs.next()) {
			return rs.getString(2);
    		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public double getCurr(String type) throws SQLException {
		try {
			Statement st = Util.getStatement();
			String sql = "select * from foreign_exchange where currency_type = '"+type+"' ";
			ResultSet rs = st.executeQuery(sql);
    		if(rs.next()) {
			return rs.getDouble(3);
    		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean closefd(String fd_name) throws RemoteException {
		 try {
	        	Statement st = Util.getStatement();
	    		String sql2 = "delete from fixeddeposit where fd_name='"+fd_name+"'";	
	    		int i= st.executeUpdate(sql2);
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
	public boolean closeCurr(String accno,String type) throws RemoteException {
		 try {
	        	Statement st = Util.getStatement();
	    		String sql2 = "delete from foreign_exchange where accno='"+accno+"' and currency_type='"+type+"' ";	
	    		int i= st.executeUpdate(sql2);
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
	
	
	
	
	
	
	
	
	
	

	public Customer display(String accno) throws RemoteException {
    
		Customer b = null;
		try{
            String sql = "select * from perfiosdata where accno = '"+accno+"'";
            ResultSet rs = Util.getStatement().executeQuery(sql);
            b = new Customer();
            while (rs.next()){
            	
                b.setAccno(rs.getString(1));
                b.setFullname(rs.getString(2));
                b.setUname(rs.getString(3));
                b.setPwd(rs.getString(4));
                b.setConf_pwd(rs.getString(5));
                b.setPhno(rs.getString(6));
                b.setEmail(rs.getString(7));
                b.setAddr(rs.getString(8));
                b.setAmt(rs.getDouble(9));
                b.setType_of_account(rs.getString(10));
                b.setUpi_id(rs.getString(11));
     
            }
            //return b;
        }
        catch (Exception et){
            et.printStackTrace();
            
        }
		
		 return b;
    }

	
	public static List<Transact> tran_hist(String accno) throws RemoteException {
		List<Transact> list = new ArrayList<Transact>();
		try{
            String sql = "select * from transaction_history where accno = '"+accno+"' ";
            ResultSet rs = Util.getStatement().executeQuery(sql);
            while (rs.next()){
            	Transact b = new Transact();
            	b.setAmt(rs.getDouble(1));
            	b.setTran_type(rs.getString(2));
            	b.setTran_id(rs.getString(3));
            	b.setTran_time(rs.getString(4));
            	list.add(b);
            }
            //return b;
        }
        catch (Exception et){
            et.printStackTrace();
            
        }
		
		 return list;
    }

	public static int saveUser(Customer bank) throws SQLIntegrityConstraintViolationException {
		String sql=null;
		try {
		sql = "insert into perfiosdata values(" + bank.getAccno() + ",'" + bank.getFullname() + "','" + bank.getUname() + "','" + bank.getPwd() + "','" + bank.getConf_pwd() + "','" + bank.getPhno() + "','" + bank.getEmail() + "','" + bank.getAddr() + "','" + bank.getAmt() + "','" + bank.getType_of_account()+"','" + bank.getUpi_id()+"')";
		Statement st = (Statement) Util.getStatement();
		int i = st.executeUpdate(sql);
		
		if(i!=1) {
			return -1;
		}
		else {
		return st.executeUpdate(sql);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static List<Customer> getAllEmployees() {
		List<Customer> list = new ArrayList<Customer>();
		try {
			Statement st = Util.getStatement();
			String sql = "select * from perfiosdata where email is NOT NULL" ;
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
            	Customer c = new Customer();
            	c.setAccno(rs.getString(1));
            	c.setFullname(rs.getString(2));
            	c.setUname(rs.getString(3));
            	c.setPhno(rs.getString(6));
            	c.setEmail(rs.getString(7));
            	c.setAddr(rs.getString(8));
            	c.setAmt(rs.getDouble(9));
            	c.setType_of_account(rs.getString(10));
            	c.setUpi_id(rs.getString(11));
            	list.add(c);
            }
		}
            catch(Exception e) {
            	e.printStackTrace();
            }
		
		
		return list;
	}
	public static List<FD_pojo> getFD_History() {
		List<FD_pojo> list = new ArrayList<FD_pojo>();
		try {
			Statement st = Util.getStatement();
			String sql = "select * from fixeddeposit order by accno asc" ;
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
            	FD_pojo c = new FD_pojo();
            	c.setAccno(rs.getString(1));
            	c.setFd_name(rs.getString(2));
            	c.setFd_amt(rs.getDouble(3));
            	c.setDt(rs.getString(4));
            	list.add(c);
            }
		}
            catch(Exception e) {
            	e.printStackTrace();
            }
		
		
		return list;
	}
	public static List<Foreign_Exchange_pojo> getFe_History() {
		List<Foreign_Exchange_pojo> list = new ArrayList<Foreign_Exchange_pojo>();
		try {
			Statement st = Util.getStatement();
			String sql = "select * from foreign_exchange order by accno asc" ;
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
            	Foreign_Exchange_pojo c = new Foreign_Exchange_pojo();
            	c.setAccno(rs.getString(1));
            	c.setCurr_type(rs.getString(2));
            	c.setFor_curr(rs.getString(3));
            	list.add(c);
            }
		}
            catch(Exception e) {
            	e.printStackTrace();
            }
		
		
		return list;
	}
	public static List<Transact> getTran_History() {
		List<Transact> list = new ArrayList<Transact>();
		try {
			Statement st = Util.getStatement();
			String sql = "select * from transaction_history order by tran_time desc" ;
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
            	Transact c = new Transact();	
            	c.setAmt(rs.getDouble(1));
            	c.setTran_type(rs.getString(2));
            	c.setTran_id(rs.getString(3));
            	c.setTran_time(rs.getString(4));
            	c.setAccno(rs.getString(5));
            	list.add(c);
            }
		}
            catch(Exception e) {
            	e.printStackTrace();
            }
		
		
		return list;
	}
	public static List<FD_pojo> displayAll(String accno) throws RemoteException {
		List<FD_pojo> list = new ArrayList<FD_pojo>();
		try{
            String sql = "select * from fixeddeposit where accno = '"+accno+"'";
            ResultSet rs = Util.getStatement().executeQuery(sql);
            while (rs.next()){
            	FD_pojo b = new FD_pojo();
                b.setAccno(rs.getString(1));
                b.setFd_name(rs.getString(2));
                b.setFd_amt(rs.getDouble(3));
                b.setDt(rs.getString(4));
                list.add(b);
     
            }
            //return b;
        }
        catch (Exception et){
            et.printStackTrace();
            
        }
		
		 return list;
    }
	public static List<Foreign_Exchange_pojo> displayAllCurrencies(String accno) throws RemoteException {
		List<Foreign_Exchange_pojo> list = new ArrayList<Foreign_Exchange_pojo>();
		try{
            String sql = "select * from foreign_exchange where accno = '"+accno+"'";
            ResultSet rs = Util.getStatement().executeQuery(sql);
            while (rs.next()){
            	Foreign_Exchange_pojo b = new Foreign_Exchange_pojo();
                b.setAccno(rs.getString(1));
                b.setCurr_type(rs.getString(2));
                b.setFor_curr(rs.getString(3));
                list.add(b);
     
            }
            //return b;
        }
        catch (Exception et){
            et.printStackTrace();
            
        }
		
		 return list;
    }


}

