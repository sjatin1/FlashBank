<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import="perfios.pojo.Customer" %>
<%@ page import="perfios.pojo.Services" %>
<meta charset="UTF-8">
<style>
th, td {
 padding: 10px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}
.btn{
padding-left:1500px;
}
h1{
padding-top : 30px;
}
th {background-color: DarkTurquoise;}
td:hover {background-color: aqua;}
</style>
<link rel="stylesheet" href="style1.css">
<title>Account details</title>
</head>
<body>
<form>
<center>
	<h1 align="center">Account Details</h1>
	<span class="btn"><button class="btn-primary" onclick="ExportToExcel('xlsx')">DOWNLOAD</button></span><br><br>
	<%      
			String accno = (String) session.getAttribute("acc");
			Services s = new Services(); 
			Customer c = s.display(accno);
			 out.print("<table id='tran_table' width='100%'");  
		        
		        out.print("<tr><th>Accno</th><th>Full Name</th><th>User Name</th><th>Mobile No.</th><th>Emal id</th><th>Address</th><th>Balance</th><th>Account Type</th><th>Upi Id</th></tr>");  
		       
		         out.print("<tr><td>"+c.getAccno()+"</td><td>"+c.getFullname()+"</td><td>"+c.getUname()+"</td><td>"+c.getPhno()+"</td><td>"+c.getEmail()+"</td><td>"+c.getAddr()+"</td><td>"+c.getAmt()+"</td><td>"+c.getType_of_account()+"</td><td>"+c.getUpi_id()+"</td></tr>");    
		        out.print("</table>");  
		          


	%>
	<br><br><span class="back"><a href = "dashboard.jsp"> Go back </a><br><br></span>
	
	
		
	</center>
	</form>
	
				<script type="text/javascript" src="https://unpkg.com/xlsx@0.15.1/dist/xlsx.full.min.js"></script>
<script type="text/javascript">
	function ExportToExcel(type, fn, dl) {
	    var elt = document.getElementById('tran_table');
	    var wb = XLSX.utils.table_to_book(elt, { sheet: "sheet1" });
	    return dl ?
	    	XLSX.write(wb, { bookType: type, bookSST: true, type: 'base64' }):
	      	XLSX.writeFile(wb, fn || ('AccountDetails.' + (type || 'xlsx')));
	}
</script>
	
	
	
	

</body>
</html>