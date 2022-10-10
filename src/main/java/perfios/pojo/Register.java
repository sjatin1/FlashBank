package perfios.pojo;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static List<String> Validator(String pass, String confPass, String user, String fname) {
		Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
	    Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
	    Pattern lowerCasePatten = Pattern.compile("[a-z ]");
	    Pattern digitCasePatten = Pattern.compile("[0-9 ]");
	    //Pattern unamePattern = Pattern.compile("^[A-Za-z][A-Za-z0-9_]{7,29}$");
	    List<String> errorList = new ArrayList<String>();
	    errorList.clear();
	    if (pass.length() < 8) {
	        errorList.add("Password length must have atleast 8 characters");
	    }
	    if (!lowerCasePatten.matcher(pass).find()) {
	        errorList.add("1 lowercase character");
	    }
	    if (!UpperCasePatten.matcher(pass).find()) {
	        errorList.add("1 uppercase character");
	    }
	    if (!digitCasePatten.matcher(pass).find()) {
	        errorList.add("1 digit character");
	    }
	    if (!specailCharPatten.matcher(pass).find()) {
	        errorList.add("1 special character !!");
	    }
	  

	    return errorList;
	}
	
	public void refresh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		 rd.include(request, response);
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("fname");
		String user = request.getParameter("user");
		String pass = request.getParameter("pwd");
		String repass = request.getParameter("cpwd");
		String phone = request.getParameter("mobile");
		String mail = request.getParameter("email");
		String add = request.getParameter("addr");
		String amt = request.getParameter("amt");
		String type = request.getParameter("acc_type");
		String upi_id = request.getParameter("upi");
//		

		List<String> errorsList = new ArrayList<String>();
		errorsList = Validator(pass,repass,user,name);
	    
	    
		double finamt = Double.parseDouble(amt);
		
		if(!errorsList.isEmpty()) {
			 refresh(request,response);
			 out.println("<center><font color = red>"+errorsList+"</font></center>");
		}
		else if(!pass.equals(repass)) {
			 refresh(request,response);
			 out.println("<center><font color = red> Password and Confirm password is not matching</font></center>");
		}
		else if (phone.length()!=10) {
			 refresh(request,response);
			 out.println("<center><font color = red> Mobile number should have 10 digits </font></center>");
		}
		else if (type.equals("savings") && finamt < 500){
			 refresh(request,response);
			 out.println("<center><font color = red> Minimum balance should be 500 for savings account. </font></center>");
        }
        else if (type.equals("current") && finamt<1000) {
        	 refresh(request,response);
			 out.println("<center><font color = red> Minimum balance should be 1000 for current account. </font></center>");
        }
		else {
		Customer c1 = new Customer();
		double x = Math.random();
		
		String str = String.valueOf(x);
		
		String str1 = "1308";
		
		String accno = str1+str.substring(2,9);
		
		c1.setAccno(accno);
	   // String accno = request.getParameter("12312322");  
		HttpSession session = request.getSession();
		session.setAttribute("acc", c1.getAccno());
			
		
		c1.setFullname(name);
		c1.setUname(user);
		c1.setPwd(pass);
		c1.setConf_pwd(repass);
		c1.setPhno(phone);
		c1.setEmail(mail);
		c1.setAddr(add);
		c1.setAmt(finamt);
		c1.setType_of_account(type);
		c1.setUpi_id(upi_id);
	
		try {
			Services.saveUser(c1);
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);
			
		}
	
	}

}
