package perfios.pojo;

public class Customer {
	private String accno;
    private String fullname;
    private String uname;
    private String pwd;
    private String conf_pwd;
    private String phno;
    private String email;
    private String addr;
    private String upi_id;
    private String curr_type;
    private double foreign_currency;
    public String getCurr_type() {
		return curr_type;
	}

	public void setCurr_type(String curr_type) {
		this.curr_type = curr_type;
	}

	public double getForeign_currency() {
		return foreign_currency;
	}

	public void setForeign_currency(double foreign_currency) {
		this.foreign_currency = foreign_currency;
	}

	public String getUpi_id() {
		return upi_id;
	}

	public void setUpi_id(String upi_id) {
		this.upi_id = upi_id;
	}

	private double amt;
    private String type_of_account;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getConf_pwd() {
        return conf_pwd;
    }

    public void setConf_pwd(String conf_pwd) {
        this.conf_pwd = conf_pwd;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType_of_account() {
        return type_of_account;
    }

    public void setType_of_account(String type_of_account) {
        this.type_of_account = type_of_account;
    }

}
