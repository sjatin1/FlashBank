<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import = "java.util.List" %>
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
	<h1 align="center">Customer Account Details</h1>
		<span class="btn"><button class="btn-primary" onclick="ExportToExcel('xlsx')">DOWNLOAD</button></span><br><br>
	
	<%
	   List<Customer> list=Services.getAllEmployees();  
    
    out.print("<table id = 'acc_table' width='100%'");  
    
    out.print("<tr><th>Accno</th><th>Full Name</th><th>User Name</th><th>Mobile No.</th><th>Emal id</th><th>Address</th><th>Balance</th><th>Account Type</th><th>Upi Id</th></tr>");  
   
    for(Customer e:list)
    {  
     out.print("<tr><td>"+e.getAccno()+"</td><td>"+e.getFullname()+"</td><td>"+e.getUname()+"</td><td>"+e.getPhno()+"</td><td>"+e.getEmail()+"</td><td>"+e.getAddr()+"</td><td>"+e.getAmt()+"</td><td>"+e.getType_of_account()+"</td><td>"+e.getUpi_id()+"</td></tr>");  
    }  
    out.print("</table>");  
	%>
	<br><br><a href= "delacc.jsp">Delete account</a><br><br>
	<a href = "admin.jsp"> Go back </a>
		
	</center>
	</form>
		<script type="text/javascript" src="https://unpkg.com/xlsx@0.15.1/dist/xlsx.full.min.js"></script>
<script type="text/javascript">
	function ExportToExcel(type, fn, dl) {
	    var elt = document.getElementById('acc_table');
	    var wb = XLSX.utils.table_to_book(elt, { sheet: "sheet1" });
	    return dl ?
	    	XLSX.write(wb, { bookType: type, bookSST: true, type: 'base64' }):
	      	XLSX.writeFile(wb, fn || ('AllAccounts.' + (type || 'xlsx')));
	}
</script>

</body>
</html>